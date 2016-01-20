package com.ferhat.breast;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

public class BreastWindow {

	private JFrame frame;
	private JTextField patientName;
	private JTextField patientAge;
	private JLabel lblKilo;
	private JTextField patientWeight;
	private JLabel lblBoy;
	private JTextField patientHeight;
	private JTextField breastBaseWidthRight;
	private JTextField breastBaseWidthLeft;
	private JTextField medialPitchRight;
	private JTextField medialPitchLeft;
	private JTextField lateralPitchRight;
	private JTextField lateralPitchLeft;
	private JTextField avrgPitchRight;
	private JTextField avrgPitchLeft;
	private JTextField plannedbreastBaseWidthRight;
	private JTextField plannedbreastBaseWidthLeft;
	private JTextField implantBaseWidthRight;
	private JTextField implantBaseWidthLeft;
	private ButtonGroup desiredSelectionGroup;
	private JRadioButton desiredOutcomeLow;
	private JRadioButton desiredOutcomeModerate;
	private JRadioButton desiredOutcomeModeratePlus;
	private JRadioButton desiredOutcomeHigh;
	private JRadioButton desiredOutcomeUltraHigh;
	private JTable foundImplantsTable;
	private JLabel lblNewLabel_2;
	
	private LineBorder selectedDesireBorder = new LineBorder(Color.RED, 2);
	private LineBorder unSelectedDesireBorder = new LineBorder(Color.RED, 0);
	
	private EditableJLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BreastWindow window = new BreastWindow(new FindImplantItemActionListener(null,null));
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BreastWindow(FindImplantItemActionListener findImplantActionListener) {
		initialize(findImplantActionListener);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(FindImplantItemActionListener findImplantActionListener) {
		frame = new JFrame();
		frame.setBounds(100, 100, 951, 584);
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(240, 255, 240));
		panel_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_4.setBounds(10, 164, 549, 232);
		frame.getContentPane().add(panel_4);
		panel_4.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Meme Taban Capi");
		lblNewLabel_1.setBounds(10, 34, 211, 14);
		panel_4.add(lblNewLabel_1);

		JLabel lblPlanlananMemeTaban = new JLabel("Planlanan Meme Taban Capi");
		lblPlanlananMemeTaban.setBounds(10, 59, 211, 14);
		panel_4.add(lblPlanlananMemeTaban);

		JLabel lblMedyalDokuKalinligi = new JLabel("Medyal Doku Kalinligi");
		lblMedyalDokuKalinligi.setBounds(10, 84, 211, 14);
		panel_4.add(lblMedyalDokuKalinligi);

		JLabel lblLateralDokuKalinligi = new JLabel("Lateral Doku Kalinligi");
		lblLateralDokuKalinligi.setBounds(10, 109, 211, 14);
		panel_4.add(lblLateralDokuKalinligi);

		JLabel lblOrtalamaDokuKalinligi = new JLabel("Ortalama Doku Kalinligi");
		lblOrtalamaDokuKalinligi.setBounds(10, 134, 211, 14);
		panel_4.add(lblOrtalamaDokuKalinligi);

		JLabel lblSag = new JLabel("Sag (cm)");
		lblSag.setBounds(231, 11, 57, 14);
		panel_4.add(lblSag);

		JLabel lblSol = new JLabel("Sol (cm)");
		lblSol.setBounds(305, 11, 57, 14);
		panel_4.add(lblSol);

		breastBaseWidthRight = new JTextField();
		breastBaseWidthRight.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {

			}

			public void removeUpdate(DocumentEvent e) {
				breastBaseWidthLeft.setText(breastBaseWidthRight.getText());
				plannedbreastBaseWidthRight.setText(breastBaseWidthRight.getText());
			}

			public void insertUpdate(DocumentEvent e) {
				breastBaseWidthLeft.setText(breastBaseWidthRight.getText());
				plannedbreastBaseWidthRight.setText(breastBaseWidthRight.getText());
			}
		});

		breastBaseWidthRight.setColumns(10);
		breastBaseWidthRight.setBounds(231, 31, 57, 20);
		panel_4.add(breastBaseWidthRight);

		breastBaseWidthLeft = new JTextField();
		breastBaseWidthLeft.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {

			}

			public void removeUpdate(DocumentEvent e) {
				plannedbreastBaseWidthLeft.setText(breastBaseWidthLeft.getText());
			}

			public void insertUpdate(DocumentEvent e) {
				plannedbreastBaseWidthLeft.setText(breastBaseWidthLeft.getText());
			}
		});
		breastBaseWidthLeft.setColumns(10);
		breastBaseWidthLeft.setBounds(305, 31, 57, 20);
		panel_4.add(breastBaseWidthLeft);

		medialPitchRight = new JTextField();

		medialPitchRight.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {

			}

			public void removeUpdate(DocumentEvent e) {
				medialPitchLeft.setText(medialPitchRight.getText());
				handleAveragePitchRight();
			}

			public void insertUpdate(DocumentEvent e) {
				medialPitchLeft.setText(medialPitchRight.getText());
				handleAveragePitchRight();
			}
		});

		medialPitchRight.setColumns(10);
		medialPitchRight.setBounds(231, 84, 57, 20);
		panel_4.add(medialPitchRight);

		medialPitchLeft = new JTextField();
		medialPitchLeft.setColumns(10);
		medialPitchLeft.setBounds(305, 84, 57, 20);
		panel_4.add(medialPitchLeft);

		medialPitchLeft.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {

			}

			public void removeUpdate(DocumentEvent e) {
				handleAveragePitchLeft();
			}

			public void insertUpdate(DocumentEvent e) {
				handleAveragePitchLeft();
			}
		});

		lateralPitchRight = new JTextField();
		lateralPitchRight.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {

			}

			public void removeUpdate(DocumentEvent e) {
				lateralPitchLeft.setText(lateralPitchRight.getText());
				handleAveragePitchRight();
			}

			public void insertUpdate(DocumentEvent e) {
				lateralPitchLeft.setText(lateralPitchRight.getText());
				handleAveragePitchRight();
			}
		});
		lateralPitchRight.setColumns(10);
		lateralPitchRight.setBounds(231, 109, 57, 20);
		panel_4.add(lateralPitchRight);

		lateralPitchLeft = new JTextField();
		lateralPitchLeft.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {

			}

			public void removeUpdate(DocumentEvent e) {
				handleAveragePitchLeft();
			}

			public void insertUpdate(DocumentEvent e) {
				handleAveragePitchLeft();
			}
		});

		lateralPitchLeft.setColumns(10);
		lateralPitchLeft.setBounds(305, 109, 57, 20);
		panel_4.add(lateralPitchLeft);

		avrgPitchRight = new JTextField();
		avrgPitchRight.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {

			}

			public void removeUpdate(DocumentEvent e) {
				handleImplantBaseWidthRight();
			}

			public void insertUpdate(DocumentEvent e) {
				handleImplantBaseWidthRight();
				;
			}
		});

		avrgPitchRight.setColumns(10);
		avrgPitchRight.setBounds(231, 132, 57, 20);
		panel_4.add(avrgPitchRight);

		avrgPitchLeft = new JTextField();
		avrgPitchLeft.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {

			}

			public void removeUpdate(DocumentEvent e) {
				handleImplantBaseWidthLeft();
			}

			public void insertUpdate(DocumentEvent e) {
				handleImplantBaseWidthLeft();
			}
		});
		avrgPitchLeft.setColumns(10);
		avrgPitchLeft.setBounds(305, 132, 57, 20);
		panel_4.add(avrgPitchLeft);

		plannedbreastBaseWidthRight = new JTextField();
		plannedbreastBaseWidthRight.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {

			}

			public void removeUpdate(DocumentEvent e) {
				handleImplantBaseWidthRight();
			}

			public void insertUpdate(DocumentEvent e) {
				handleImplantBaseWidthRight();
			}
		});

		plannedbreastBaseWidthRight.setColumns(10);
		plannedbreastBaseWidthRight.setBounds(231, 56, 57, 20);
		panel_4.add(plannedbreastBaseWidthRight);

		plannedbreastBaseWidthLeft = new JTextField();
		plannedbreastBaseWidthLeft.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {

			}

			public void removeUpdate(DocumentEvent e) {
				handleImplantBaseWidthLeft();
			}

			public void insertUpdate(DocumentEvent e) {
				handleImplantBaseWidthLeft();
			}
		});

		plannedbreastBaseWidthLeft.setColumns(10);
		plannedbreastBaseWidthLeft.setBounds(305, 56, 57, 20);
		panel_4.add(plannedbreastBaseWidthLeft);

		JButton findImplant = new JButton("Implant Bul");
		findImplant.addActionListener(findImplantActionListener);

		findImplant.setBounds(231, 189, 131, 23);
		panel_4.add(findImplant);

		JLabel lblImplantTabanCapi = new JLabel("Implant Taban Capi");
		lblImplantTabanCapi.setBounds(10, 162, 211, 14);
		panel_4.add(lblImplantTabanCapi);

		implantBaseWidthRight = new JTextField();
		implantBaseWidthRight.setColumns(10);
		implantBaseWidthRight.setBounds(231, 159, 57, 20);
		panel_4.add(implantBaseWidthRight);

		implantBaseWidthLeft = new JTextField();
		implantBaseWidthLeft.setColumns(10);
		implantBaseWidthLeft.setBounds(305, 159, 57, 20);
		panel_4.add(implantBaseWidthLeft);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBackground(new Color(240, 255, 240));
		panel_1.setBounds(10, 11, 549, 142);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("Hasta Adi :");
		lblNewLabel.setBounds(10, 14, 63, 14);
		panel_1.add(lblNewLabel);

		patientName = new JTextField();
		patientName.setBounds(83, 11, 282, 20);
		panel_1.add(patientName);
		patientName.setColumns(10);

		JLabel lblYas = new JLabel("Yas :");
		lblYas.setBounds(10, 45, 46, 14);
		panel_1.add(lblYas);

		patientAge = new JTextField();
		patientAge.setBounds(83, 42, 57, 20);
		panel_1.add(patientAge);
		patientAge.setColumns(10);

		lblKilo = new JLabel("Kilo :");
		lblKilo.setBounds(150, 45, 46, 14);
		panel_1.add(lblKilo);

		patientWeight = new JTextField();
		patientWeight.setBounds(190, 42, 57, 20);
		panel_1.add(patientWeight);
		patientWeight.setColumns(10);

		lblBoy = new JLabel("Boy :");
		lblBoy.setBounds(257, 45, 46, 14);
		panel_1.add(lblBoy);

		patientHeight = new JTextField();
		patientHeight.setBounds(303, 42, 57, 20);
		panel_1.add(patientHeight);
		patientHeight.setColumns(10);

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 73, 63, 53);
		panel_1.add(panel);
		panel.setLayout(null);

		desiredOutcomeLow = new JRadioButton("1");
		desiredOutcomeLow.setSelected(true);
		desiredOutcomeLow.setBounds(6, 7, 36, 23);
		panel.add(desiredOutcomeLow);

		JPanel panel1 = new JPanel();
		panel1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel1.setBounds(83, 73, 63, 53);
		panel_1.add(panel1);
		panel1.setLayout(null);

		desiredOutcomeModerate = new JRadioButton("2");
		desiredOutcomeModerate.setBounds(6, 7, 36, 23);
		panel1.add(desiredOutcomeModerate);

		JPanel panel2 = new JPanel();
		panel2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel2.setBounds(156, 73, 63, 53);
		panel_1.add(panel2);
		panel2.setLayout(null);

		desiredOutcomeModeratePlus = new JRadioButton("2+");
		desiredOutcomeModeratePlus.setBounds(6, 7, 51, 23);
		panel2.add(desiredOutcomeModeratePlus);

		JPanel panel3 = new JPanel();
		panel3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel3.setBounds(229, 73, 63, 53);
		panel_1.add(panel3);
		panel3.setLayout(null);

		desiredOutcomeHigh = new JRadioButton("3");
		desiredOutcomeHigh.setBounds(6, 7, 36, 23);
		panel3.add(desiredOutcomeHigh);

		JPanel panel4 = new JPanel();
		panel4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel4.setBounds(302, 73, 63, 53);
		panel_1.add(panel4);
		panel4.setLayout(null);

		desiredOutcomeUltraHigh = new JRadioButton("4");
		desiredOutcomeUltraHigh.setBounds(6, 7, 36, 23);
		panel4.add(desiredOutcomeUltraHigh);

		desiredSelectionGroup = new ButtonGroup();
		desiredSelectionGroup.add(desiredOutcomeLow);
		desiredSelectionGroup.add(desiredOutcomeModerate);
		desiredSelectionGroup.add(desiredOutcomeModeratePlus);
		desiredSelectionGroup.add(desiredOutcomeHigh);
		desiredSelectionGroup.add(desiredOutcomeUltraHigh);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBounds(10, 407, 549, 153);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		Vector initialData = new Vector();
		initialData.add(Util.getColumnNames());
		initialData.add(Util.getEmptyDataForTable());

		foundImplantsTable = new JTable(initialData, Util.getColumnNames());
		foundImplantsTable.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		foundImplantsTable.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "DIAMETER", "VOLUME", "PROJECTION", "PROFILE" }));
		foundImplantsTable.setBounds(10, 34, 529, 95);
		panel_2.add(foundImplantsTable);

		lblNewLabel_2 = new JLabel("Uygun Implant Sonucu:");
		lblNewLabel_2.setBounds(10, 11, 148, 14);
		panel_2.add(lblNewLabel_2);
		
		final Image img = new ImageIcon(BreastWindow.class.getResource("/icons/IMG01221-20130322-0756.jpg")).getImage();
		
		JPanel panel_3 = new JPanel(){
			public void paintComponent(Graphics g) {
			    g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), null);
			  }
		};
		panel_3.setBounds(569, 129, 356, 267);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		
		lblNewLabel_3 = new EditableJLabel("");
		lblNewLabel_3.getLabel().setBackground(Color.WHITE);
		lblNewLabel_3.setBackground(Color.WHITE);
		lblNewLabel_3.getLabel().setText("");
		lblNewLabel_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblNewLabel_3.setBorder(selectedDesireBorder);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_3.setBorder(unSelectedDesireBorder);
			}
		});
		
		lblNewLabel_3.setBorder(selectedDesireBorder);
		lblNewLabel_3.setBounds(56, 97, 29, 24);
		panel_3.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("BWL :");
		lblNewLabel_4.setBounds(22, 97, 35, 14);
		panel_3.add(lblNewLabel_4);

		// new JTable(data, columnNames);
		// foundImplantsTable.setCo
	}

	private void handleAveragePitchRight() {
		// TODO: Format to 1 decimal point
		if (!Util.isEmpty(medialPitchRight.getText()) && !Util.isEmpty(lateralPitchRight.getText())) {
			float medialPitchRightVal = Float.parseFloat(medialPitchRight.getText());
			float lateralPitchRightVal = Float.parseFloat(lateralPitchRight.getText());
			float average = (medialPitchRightVal + lateralPitchRightVal) / 2;
			avrgPitchRight.setText(String.valueOf(average));
		}
	}

	private void handleAveragePitchLeft() {
		// TODO: Format to 1 decimal point
		if (!Util.isEmpty(medialPitchLeft.getText()) && !Util.isEmpty(lateralPitchLeft.getText())) {
			float medialPitchLeftVal = Float.parseFloat(medialPitchLeft.getText());
			float lateralPitchLeftVal = Float.parseFloat(lateralPitchLeft.getText());
			float average = (medialPitchLeftVal + lateralPitchLeftVal) / 2;
			avrgPitchLeft.setText(String.valueOf(average));
		}
	}

	private void handleImplantBaseWidthRight() {
		if (!Util.isEmpty(plannedbreastBaseWidthRight.getText()) && !Util.isEmpty(avrgPitchRight.getText())) {
			float plannedBreastBaseWidthRightValue = Float.parseFloat(plannedbreastBaseWidthRight.getText());
			float avrgPitchRightValue = Float.parseFloat(avrgPitchRight.getText());

			implantBaseWidthRight.setText(String.valueOf(plannedBreastBaseWidthRightValue - avrgPitchRightValue));
		}
	}

	private void handleImplantBaseWidthLeft() {
		if (!Util.isEmpty(plannedbreastBaseWidthLeft.getText()) && !Util.isEmpty(avrgPitchLeft.getText())) {
			float plannedbreastBaseWidthLeftValue = Float.parseFloat(plannedbreastBaseWidthLeft.getText());
			float avrgPitchLeftValue = Float.parseFloat(avrgPitchLeft.getText());

			implantBaseWidthLeft.setText(String.valueOf(plannedbreastBaseWidthLeftValue - avrgPitchLeftValue));
		}
	}

	public JTextField getImplantBaseWidthLeft() {
		return implantBaseWidthLeft;
	}

	public void setImplantBaseWidthLeft(JTextField implantBaseWidthLeft) {
		this.implantBaseWidthLeft = implantBaseWidthLeft;
	}

	public JTextField getImplantBaseWidthRight() {
		return implantBaseWidthRight;
	}

	public void setImplantBaseWidthRight(JTextField implantBaseWidthRight) {
		this.implantBaseWidthRight = implantBaseWidthRight;
	}

	public ButtonGroup getDesiredSelectionGroup() {
		return desiredSelectionGroup;
	}

	public void setDesiredSelectionGroup(ButtonGroup desiredSelectionGroup) {
		this.desiredSelectionGroup = desiredSelectionGroup;
	}

	public JRadioButton getDesiredOutcomeLow() {
		return desiredOutcomeLow;
	}

	public JRadioButton getDesiredOutcomeModerate() {
		return desiredOutcomeModerate;
	}

	public JRadioButton getDesiredOutcomeModeratePlus() {
		return desiredOutcomeModeratePlus;
	}

	public JRadioButton getDesiredOutcomeHigh() {
		return desiredOutcomeHigh;
	}

	public JRadioButton getDesiredOutcomeUltraHigh() {
		return desiredOutcomeUltraHigh;
	}

	public JFrame getFrame() {
		return frame;
	}

	public JTable getFoundImplantsTable() {
		return foundImplantsTable;
	}
}
