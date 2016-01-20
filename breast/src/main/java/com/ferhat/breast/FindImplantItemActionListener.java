package com.ferhat.breast;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

class FindImplantItemActionListener implements ActionListener {

	private CatalogContainer smoothCatalogContainer;
	private CatalogContainer siltexCatalogContainer;
	private BreastNewWindow4 window;

	public FindImplantItemActionListener(CatalogContainer smoothCatalogContainer, CatalogContainer siltexCatalogContainer) {
		this.smoothCatalogContainer = smoothCatalogContainer;
		this.siltexCatalogContainer = siltexCatalogContainer;
	}

	public void actionPerformed(ActionEvent e) {
		// ButtonModel selection =
		// window.getDesiredSelectionGroup().getSelection();
		ImplantProfile ip = window.getDesiredImplantProfile();
		if (ip == null){
			JOptionPane.showMessageDialog(window, "İmplant bulmadan önce [İstenen Sonuç] u seçiniz");
			return;
		}
		
		if (ip == ImplantProfile.LOW && window.getRoundedGranuler().isSelected()){
			JOptionPane.showMessageDialog(window, "Low Profile Pürüzlü Yüzey implant desteklenmemektedir");
			return;
		}

		String rightImplantBaseWidthText = window.getImplantBaseWidthRight().getText();
		String leftImplantBaseWidthText = window.getImplantBaseWidthLeft().getText();
		if (Util.isEmpty(rightImplantBaseWidthText) || Util.isEmpty(leftImplantBaseWidthText)) {
			JOptionPane.showMessageDialog(window, "İmplant bulmadan once [İmplant Taban Çapı] hesaplamasını tamamlayınız");
			return;
		}
		
		boolean symetric = true;
		float rightImplantBaseWidth = Float.valueOf(rightImplantBaseWidthText);
		float leftImplantBaseWidth = Float.valueOf(leftImplantBaseWidthText);

		if (rightImplantBaseWidth != leftImplantBaseWidth)
			symetric = false;
		
		CatalogContainer cc = null;
		if (window.getRoundedGranuler().isSelected()){
			cc = siltexCatalogContainer;
		}else{
			cc = smoothCatalogContainer;
		}
		
		ImplantItem implant = cc.getImplant(ip, rightImplantBaseWidth);

		Vector<Vector> tableData = new Vector<Vector>();
		boolean couldNotHitWarningShown = false;

		if (implant != null) {
			tableData.add(implant.getVector());
		} else {
			JOptionPane.showMessageDialog(window, "Uygun implant bulunamadı. Alternatifler listeleniyor");
			couldNotHitWarningShown = true;
			List<ImplantItem> alternatives = cc.getAlternativeImplants(ip, rightImplantBaseWidth);
			for (ImplantItem alternative : alternatives) {
				tableData.add(alternative.getVector());
			}
		}
		System.out.println("found Implant=" + implant);
		DefaultTableModel tableModel = new DefaultTableModel(tableData, Util.getColumnNames());
		window.getFoundImplantsTable().setModel(tableModel);
		
		//if(symetric){
//			TitledBorder border = (TitledBorder)window.getPanelResultRight().getBorder();
	//		border.setTitle("Uygun \u0130mplant Sonucu");
	//		window.getPanelResultLeft().setVisible(false);
	//	}else{
			//TitledBorder border = (TitledBorder)window.getPanelResultRight().getBorder();
			//border.setTitle("Uygun \u0130mplant Sonucu  (Sağ)");
			
			ImplantItem implantLeft = cc.getImplant(ip, leftImplantBaseWidth);

			Vector<Vector> tableDataLeft = new Vector<Vector>();

			if (implantLeft != null) {
				tableDataLeft.add(implantLeft.getVector());
			} else {
				if(!couldNotHitWarningShown){
					JOptionPane.showMessageDialog(window, "Uygun implant bulunamadı. Alternatifler listeleniyor");
				}
				List<ImplantItem> alternatives = cc.getAlternativeImplants(ip, leftImplantBaseWidth);
				for (ImplantItem alternative : alternatives) {
					tableDataLeft.add(alternative.getVector());
				}
			}
			System.out.println("found Implant=" + implant);
			DefaultTableModel tableModelLeft = new DefaultTableModel(tableDataLeft, Util.getColumnNames());
			window.getFoundImplantsTableLeft().setModel(tableModelLeft);
			//window.getPanelResultLeft().setVisible(true);
		//}

		//window.getFrame().pack();
	}

	public void registerWindow(BreastNewWindow4 breastNewWindow4) {
		this.window = breastNewWindow4;
	}

	public static void main(String[] args) {
		for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
	        	System.out.println(info.getClassName());
	    }
	}
}
