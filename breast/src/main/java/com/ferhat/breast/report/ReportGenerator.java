package com.ferhat.breast.report;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Locale;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class ReportGenerator {
	public void show(ReportBean bean) throws JRException, IllegalArgumentException, IllegalAccessException{
		JasperReport jasperReport = JasperCompileManager.compileReport(ReportGenerator.class.getResourceAsStream("/report/breast_report.jrxml"));
		HashMap reportValues = populateMap(bean);

		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, reportValues, new JREmptyDataSource());
		//JasperExportManager.exportReportToPdfFile(jasperPrint, "E:\\implants\\simple_report.pdf");
		
		//new JRViewer(jasperPrint).setVisible(true);
		JasperViewer.viewReport(jasperPrint, false, new Locale("TR"));
	}
	
	public HashMap<String, String> populateMap(ReportBean bean) throws IllegalArgumentException, IllegalAccessException {
		HashMap<String, String> map = new HashMap<String, String>();
		Field[] fields = ReportBean.class.getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			map.put(field.getName(), (String) field.get(bean));

		}
		return map;
	}
}
