package com.ferhat.breast;

import java.awt.EventQueue;
import java.io.IOException;

public class Breast {

	private BreastNewWindow4 window;
	private CatalogContainer smoothCatalogContainer;
	private CatalogContainer siltexCatalogContainer;
	private FindImplantItemActionListener findImplantActionListener;

	public Breast() throws IOException {
		String smoothRoundFile = "/SmoothRound.txt";
		String siltexRoundFile = "/SiltexRound.txt";
		
		smoothCatalogContainer = new CatalogContainer(smoothRoundFile);
		smoothCatalogContainer.loadCatalog(smoothRoundFile);
		
		siltexCatalogContainer = new CatalogContainer(siltexRoundFile);
		siltexCatalogContainer.loadCatalog(siltexRoundFile);

		findImplantActionListener = new FindImplantItemActionListener(smoothCatalogContainer, siltexCatalogContainer);
		initGui();
	}

	public void initGui() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new BreastNewWindow4(findImplantActionListener);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void main(String[] args) throws IOException {
		new Breast();
	}
}
