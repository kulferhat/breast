import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Locale;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

import com.ferhat.breast.report.ReportBean;

public class ReportTest {
	public static void main(String[] args) throws JRException, IllegalArgumentException, IllegalAccessException {

		JasperReport jasperReport = JasperCompileManager.compileReport(ReportTest.class.getResourceAsStream("/report/Blank_A4.jrxml"));
		ReportBean bean = new ReportBean();
		bean.setPatientAge("12");
		bean.setPatientHeight("125");
		bean.setPatientName("ferhat");
		bean.setPatientWeight("90");

		HashMap reportValues = populateMap(bean);

		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, reportValues, new JREmptyDataSource());
		JasperExportManager.exportReportToPdfFile(jasperPrint, "E:\\implants\\simple_report.pdf");
		
		//new JRViewer(jasperPrint).setVisible(true);
		JasperViewer.viewReport(jasperPrint, true, new Locale("tr")); 
	}

	public static HashMap populateMap(ReportBean bean) throws IllegalArgumentException, IllegalAccessException {
		HashMap<String, String> map = new HashMap<String, String>();
		Field[] fields = ReportBean.class.getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			map.put(field.getName(), (String) field.get(bean));

		}
		return map;
	}
}
