package com.ferhat.breast;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.text.NumberFormat;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import com.ferhat.breast.report.ReportBean;
import com.ferhat.breast.report.ReportGenerator;

public class BreastNewWindow {

	private JFrame frame;
	private JTextField patientName;
	private JTextField patientAge;
	private JTextField patientWeight;
	private JTextField patientHeight;
	private JTextField breastBaseWidthRight;
	private JTextField breastBaseWidthLeft;
	private JTextField plannedbreastBaseWidthRight;
	private JTextField plannedbreastBaseWidthLeft;
	private JTextField medialPitchRight;
	private JTextField medialPitchLeft;
	private JTextField lateralPitchRight;
	private JTextField lateralPitchLeft;
	private JTextField avrgPitchRight;
	private JTextField avrgPitchLeft;
	private JTextField implantBaseWidthRight;
	private JTextField implantBaseWidthLeft;
	private JTable foundImplantsTable;
	private LineBorder selectedDesireBorder = new LineBorder(Color.RED, 2);
	private LineBorder unSelectedDesireBorder = new LineBorder(Color.RED, 0);
	private JLabel lblDesiredOutcomeLow;
	private JLabel lblDesiredOutcomeModerate;
	private JLabel lblDesiredOutcomeModeratePlus;
	private JLabel lblDesiredOutcomeHigh;
	private JLabel lblDesiredOutcomeUltraHigh;
	private JTable foundImplantsTableLeft;
	private JPanel panelResultLeft;
	private JPanel panelResultRight;
	private ButtonGroup roundImplantGroup;
	private JRadioButton roundedSmooth;
	private JRadioButton roundedGranuler;
	private JLabel lblNewLabel_12;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BreastNewWindow window = new BreastNewWindow(new FindImplantItemActionListener(null, null));			
					//window.frame.pack();
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
	public BreastNewWindow(FindImplantItemActionListener findImplantActionListener) {
		initialize(findImplantActionListener);
		//findImplantActionListener.registerWindow(this);
		//frame.pack();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(FindImplantItemActionListener findImplantActionListener) {
		frame = new JFrame();
		frame.setBounds(0, 0, 1000, 590);
		frame.setResizable(true);
		
		setLookAndFeel();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel mainPanel = new JPanel();
		frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(new BorderLayout(0, 0));
		
		
		
		
		
		
		
		
		JPanel leftPanel = new JPanel();
		mainPanel.add(leftPanel, BorderLayout.WEST);
		leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.PAGE_AXIS));
		
		JPanel panelPatientName = new JPanel();
		panelPatientName.setAlignmentY(Component.TOP_ALIGNMENT);
		panelPatientName.setAlignmentX(5.0f);
		panelPatientName.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Hasta", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		leftPanel.add(panelPatientName);
		GridBagLayout gbl_panelPatientName = new GridBagLayout();
		gbl_panelPatientName.columnWidths = new int[] {43, 46, 42, 49, 0, 49};
		gbl_panelPatientName.rowHeights = new int[] {0, 0, 0};
		gbl_panelPatientName.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 0.0, 1.0};
		gbl_panelPatientName.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panelPatientName.setLayout(gbl_panelPatientName);
		
		JLabel lblNewLabel = new JLabel("Adı :");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panelPatientName.add(lblNewLabel, gbc_lblNewLabel);
		
		patientName = new JTextField();
		patientName.setFont(new Font("Tahoma", Font.PLAIN, 9));
		GridBagConstraints gbc_patientName = new GridBagConstraints();
		gbc_patientName.gridwidth = 5;
		gbc_patientName.insets = new Insets(0, 0, 5, 0);
		gbc_patientName.fill = GridBagConstraints.HORIZONTAL;
		gbc_patientName.gridx = 1;
		gbc_patientName.gridy = 0;
		panelPatientName.add(patientName, gbc_patientName);
		patientName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Yaşı :");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panelPatientName.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		patientAge = new JTextField();
		patientAge.setFont(new Font("Tahoma", Font.PLAIN, 9));
		GridBagConstraints gbc_patientAge = new GridBagConstraints();
		gbc_patientAge.anchor = GridBagConstraints.NORTH;
		gbc_patientAge.insets = new Insets(0, 0, 0, 5);
		gbc_patientAge.fill = GridBagConstraints.HORIZONTAL;
		gbc_patientAge.gridx = 1;
		gbc_patientAge.gridy = 1;
		panelPatientName.add(patientAge, gbc_patientAge);
		patientAge.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Kilosu :");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_2.gridx = 2;
		gbc_lblNewLabel_2.gridy = 1;
		panelPatientName.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		patientWeight = new JTextField();
		patientWeight.setFont(new Font("Tahoma", Font.PLAIN, 9));
		GridBagConstraints gbc_patientWeight = new GridBagConstraints();
		gbc_patientWeight.anchor = GridBagConstraints.NORTH;
		gbc_patientWeight.insets = new Insets(0, 0, 0, 5);
		gbc_patientWeight.fill = GridBagConstraints.HORIZONTAL;
		gbc_patientWeight.gridx = 3;
		gbc_patientWeight.gridy = 1;
		panelPatientName.add(patientWeight, gbc_patientWeight);
		patientWeight.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Boyu :");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.gridx = 4;
		gbc_lblNewLabel_3.gridy = 1;
		panelPatientName.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		patientHeight = new JTextField();
		patientHeight.setFont(new Font("Tahoma", Font.PLAIN, 9));
		GridBagConstraints gbc_patientHeight = new GridBagConstraints();
		gbc_patientHeight.anchor = GridBagConstraints.NORTH;
		gbc_patientHeight.fill = GridBagConstraints.HORIZONTAL;
		gbc_patientHeight.gridx = 5;
		gbc_patientHeight.gridy = 1;
		panelPatientName.add(patientHeight, gbc_patientHeight);
		patientHeight.setColumns(10);
		
		JPanel panelDesired = new JPanel();
		panelDesired.setAlignmentY(Component.TOP_ALIGNMENT);
		panelDesired.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panelDesired.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u0130stenen Sonu\u00E7", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		leftPanel.add(panelDesired);
		
		MouseListener desiredClickMouseListener = new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				handleDesiredClick(e);
			}
		};
		
		lblDesiredOutcomeLow = new JLabel("");
		lblDesiredOutcomeLow.setHorizontalAlignment(SwingConstants.LEFT);
		lblDesiredOutcomeLow.setToolTipText("Low (1)");
		lblDesiredOutcomeLow.addMouseListener(desiredClickMouseListener);
		panelDesired.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		lblDesiredOutcomeLow.setIcon(new ImageIcon(BreastNewWindow.class.getResource("/icons/1.png")));
		lblDesiredOutcomeLow.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblDesiredOutcomeLow.setBorder(selectedDesireBorder);
		panelDesired.add(lblDesiredOutcomeLow);
		
		lblDesiredOutcomeModerate = new JLabel("");
		lblDesiredOutcomeModerate.setHorizontalAlignment(SwingConstants.LEFT);
		lblDesiredOutcomeModerate.setToolTipText("Moderate (2)");
		lblDesiredOutcomeModerate.setIcon(new ImageIcon(BreastNewWindow.class.getResource("/icons/2.png")));
		lblDesiredOutcomeModerate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblDesiredOutcomeModerate.setBorder(unSelectedDesireBorder);
		lblDesiredOutcomeModerate.addMouseListener(desiredClickMouseListener);
		panelDesired.add(lblDesiredOutcomeModerate);
		
		lblDesiredOutcomeModeratePlus = new JLabel("");
		lblDesiredOutcomeModeratePlus.setHorizontalAlignment(SwingConstants.LEFT);
		lblDesiredOutcomeModeratePlus.setToolTipText("ModeratePlus (2+)");
		lblDesiredOutcomeModeratePlus.setIcon(new ImageIcon(BreastNewWindow.class.getResource("/icons/2plus.png")));
		lblDesiredOutcomeModeratePlus.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblDesiredOutcomeModeratePlus.setBorder(unSelectedDesireBorder);
		lblDesiredOutcomeModeratePlus.addMouseListener(desiredClickMouseListener);
		panelDesired.add(lblDesiredOutcomeModeratePlus);
		
		lblDesiredOutcomeHigh = new JLabel("");
		lblDesiredOutcomeHigh.setHorizontalAlignment(SwingConstants.LEFT);
		lblDesiredOutcomeHigh.setToolTipText("High (3)");
		lblDesiredOutcomeHigh.setIcon(new ImageIcon(BreastNewWindow.class.getResource("/icons/3.png")));
		lblDesiredOutcomeHigh.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblDesiredOutcomeHigh.setBorder(unSelectedDesireBorder);
		lblDesiredOutcomeHigh.addMouseListener(desiredClickMouseListener);
		panelDesired.add(lblDesiredOutcomeHigh);
		
		lblDesiredOutcomeUltraHigh = new JLabel("");
		lblDesiredOutcomeUltraHigh.setHorizontalAlignment(SwingConstants.LEFT);
		lblDesiredOutcomeUltraHigh.setToolTipText("Ultra High (4)");
		lblDesiredOutcomeUltraHigh.setIcon(new ImageIcon(BreastNewWindow.class.getResource("/icons/4.png")));
		lblDesiredOutcomeUltraHigh.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblDesiredOutcomeUltraHigh.setBorder(unSelectedDesireBorder);
		lblDesiredOutcomeUltraHigh.addMouseListener(desiredClickMouseListener);
		panelDesired.add(lblDesiredOutcomeUltraHigh);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
		leftPanel.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Yuvarlak Implant", null, panel_1, null);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel_1.add(panel, BorderLayout.NORTH);
		panel.setBorder(new TitledBorder(null, "Y\u00FCzey Se\u00E7imi", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{93, 0, 0};
		gbl_panel.rowHeights = new int[]{23, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		roundImplantGroup = new ButtonGroup();
		
		roundedSmooth = new JRadioButton("Düz Yüzey");
		roundedSmooth.setHorizontalAlignment(SwingConstants.LEFT);
		roundedSmooth.setSelected(true);
		GridBagConstraints gbc_roundedSmooth = new GridBagConstraints();
		gbc_roundedSmooth.anchor = GridBagConstraints.WEST;
		gbc_roundedSmooth.insets = new Insets(0, 0, 0, 5);
		gbc_roundedSmooth.gridx = 0;
		gbc_roundedSmooth.gridy = 0;
		panel.add(roundedSmooth, gbc_roundedSmooth);
		roundImplantGroup.add(roundedSmooth);
		
		
		roundedGranuler = new JRadioButton("Pürüzlü Yüzey");
		GridBagConstraints gbc_roundedGranuler = new GridBagConstraints();
		gbc_roundedGranuler.anchor = GridBagConstraints.WEST;
		gbc_roundedGranuler.gridx = 1;
		gbc_roundedGranuler.gridy = 0;
		panel.add(roundedGranuler, gbc_roundedGranuler);
		roundImplantGroup.add(roundedGranuler);
		
		JPanel panelValues = new JPanel();
		panel_1.add(panelValues, BorderLayout.CENTER);
		panelValues.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u00D6l\u00E7\u00FCler", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gbl_panelValues = new GridBagLayout();
		gbl_panelValues.columnWidths = new int[] {30, 30, 30, 30, 30, 112, 82, 30};
		gbl_panelValues.rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 20};
		gbl_panelValues.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panelValues.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelValues.setLayout(gbl_panelValues);
		
		JLabel lblSagcm = new JLabel("Sağ (cm)");
		GridBagConstraints gbc_lblSagcm = new GridBagConstraints();
		gbc_lblSagcm.insets = new Insets(0, 0, 5, 5);
		gbc_lblSagcm.gridx = 5;
		gbc_lblSagcm.gridy = 0;
		panelValues.add(lblSagcm, gbc_lblSagcm);
		
		JLabel lblSolcm = new JLabel("Sol (cm)");
		GridBagConstraints gbc_lblSolcm = new GridBagConstraints();
		gbc_lblSolcm.insets = new Insets(0, 0, 5, 0);
		gbc_lblSolcm.gridx = 6;
		gbc_lblSolcm.gridy = 0;
		panelValues.add(lblSolcm, gbc_lblSolcm);
		
		JLabel lblNewLabel_6 = new JLabel("Meme Taban Çapı :");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.gridwidth = 4;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 1;
		gbc_lblNewLabel_6.gridy = 1;
		panelValues.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		breastBaseWidthRight = new JFormattedTextField(NumberFormat.getNumberInstance());
		breastBaseWidthRight.setFont(new Font("Tahoma", Font.PLAIN, 9));
		GridBagConstraints gbc_breastBaseWidthRight = new GridBagConstraints();
		gbc_breastBaseWidthRight.insets = new Insets(0, 0, 5, 5);
		gbc_breastBaseWidthRight.gridx = 5;
		gbc_breastBaseWidthRight.gridy = 1;
		panelValues.add(breastBaseWidthRight, gbc_breastBaseWidthRight);
		breastBaseWidthRight.setColumns(10);
		
		breastBaseWidthLeft = new JFormattedTextField(NumberFormat.getNumberInstance());
		breastBaseWidthLeft.setFont(new Font("Tahoma", Font.PLAIN, 9));
		GridBagConstraints gbc_breastBaseWidthLeft = new GridBagConstraints();
		gbc_breastBaseWidthLeft.insets = new Insets(0, 0, 5, 0);
		gbc_breastBaseWidthLeft.gridx = 6;
		gbc_breastBaseWidthLeft.gridy = 1;
		panelValues.add(breastBaseWidthLeft, gbc_breastBaseWidthLeft);
		breastBaseWidthLeft.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Planlanan Meme Taban Çapı :");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.gridwidth = 4;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.gridx = 1;
		gbc_lblNewLabel_7.gridy = 2;
		panelValues.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		plannedbreastBaseWidthRight = new JFormattedTextField(NumberFormat.getNumberInstance());
		plannedbreastBaseWidthRight.setFont(new Font("Tahoma", Font.PLAIN, 9));
		GridBagConstraints gbc_plannedbreastBaseWidthRight = new GridBagConstraints();
		gbc_plannedbreastBaseWidthRight.insets = new Insets(0, 0, 5, 5);
		gbc_plannedbreastBaseWidthRight.gridx = 5;
		gbc_plannedbreastBaseWidthRight.gridy = 2;
		panelValues.add(plannedbreastBaseWidthRight, gbc_plannedbreastBaseWidthRight);
		plannedbreastBaseWidthRight.setColumns(10);
		
		plannedbreastBaseWidthLeft = new JFormattedTextField(NumberFormat.getNumberInstance());
		plannedbreastBaseWidthLeft.setFont(new Font("Tahoma", Font.PLAIN, 9));
		GridBagConstraints gbc_plannedbreastBaseWidthLeft = new GridBagConstraints();
		gbc_plannedbreastBaseWidthLeft.insets = new Insets(0, 0, 5, 0);
		gbc_plannedbreastBaseWidthLeft.gridx = 6;
		gbc_plannedbreastBaseWidthLeft.gridy = 2;
		panelValues.add(plannedbreastBaseWidthLeft, gbc_plannedbreastBaseWidthLeft);
		plannedbreastBaseWidthLeft.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Medyal Doku Kalınlığı");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.gridwidth = 4;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_8.gridx = 1;
		gbc_lblNewLabel_8.gridy = 3;
		panelValues.add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		medialPitchRight = new JFormattedTextField(NumberFormat.getNumberInstance());
		medialPitchRight.setFont(new Font("Tahoma", Font.PLAIN, 9));
		GridBagConstraints gbc_medialPitchRight = new GridBagConstraints();
		gbc_medialPitchRight.insets = new Insets(0, 0, 5, 5);
		gbc_medialPitchRight.gridx = 5;
		gbc_medialPitchRight.gridy = 3;
		panelValues.add(medialPitchRight, gbc_medialPitchRight);
		medialPitchRight.setColumns(10);
		
		medialPitchLeft = new JFormattedTextField(NumberFormat.getNumberInstance());
		medialPitchLeft.setFont(new Font("Tahoma", Font.PLAIN, 9));
		GridBagConstraints gbc_medialPitchLeft = new GridBagConstraints();
		gbc_medialPitchLeft.insets = new Insets(0, 0, 5, 0);
		gbc_medialPitchLeft.gridx = 6;
		gbc_medialPitchLeft.gridy = 3;
		panelValues.add(medialPitchLeft, gbc_medialPitchLeft);
		medialPitchLeft.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Lateral Doku Kalınlığı");
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.gridwidth = 4;
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_9.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_9.gridx = 1;
		gbc_lblNewLabel_9.gridy = 4;
		panelValues.add(lblNewLabel_9, gbc_lblNewLabel_9);
		
		lateralPitchRight = new JFormattedTextField(NumberFormat.getNumberInstance());
		lateralPitchRight.setFont(new Font("Tahoma", Font.PLAIN, 9));
		GridBagConstraints gbc_lateralPitchRight = new GridBagConstraints();
		gbc_lateralPitchRight.insets = new Insets(0, 0, 5, 5);
		gbc_lateralPitchRight.gridx = 5;
		gbc_lateralPitchRight.gridy = 4;
		panelValues.add(lateralPitchRight, gbc_lateralPitchRight);
		lateralPitchRight.setColumns(10);
		
		lateralPitchLeft = new JFormattedTextField(NumberFormat.getNumberInstance());
		lateralPitchLeft.setFont(new Font("Tahoma", Font.PLAIN, 9));
		GridBagConstraints gbc_lateralPitchLeft = new GridBagConstraints();
		gbc_lateralPitchLeft.insets = new Insets(0, 0, 5, 0);
		gbc_lateralPitchLeft.gridx = 6;
		gbc_lateralPitchLeft.gridy = 4;
		panelValues.add(lateralPitchLeft, gbc_lateralPitchLeft);
		lateralPitchLeft.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Ortalama Doku Kalınlığı");
		GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
		gbc_lblNewLabel_10.gridwidth = 4;
		gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_10.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_10.gridx = 1;
		gbc_lblNewLabel_10.gridy = 5;
		panelValues.add(lblNewLabel_10, gbc_lblNewLabel_10);
		
		avrgPitchRight = new JFormattedTextField(NumberFormat.getNumberInstance());
		avrgPitchRight.setFont(new Font("Tahoma", Font.PLAIN, 9));
		GridBagConstraints gbc_avrgPitchRight = new GridBagConstraints();
		gbc_avrgPitchRight.insets = new Insets(0, 0, 5, 5);
		gbc_avrgPitchRight.gridx = 5;
		gbc_avrgPitchRight.gridy = 5;
		panelValues.add(avrgPitchRight, gbc_avrgPitchRight);
		avrgPitchRight.setColumns(10);
		
		avrgPitchLeft = new JFormattedTextField(NumberFormat.getNumberInstance());
		avrgPitchLeft.setFont(new Font("Tahoma", Font.PLAIN, 9));
		GridBagConstraints gbc_avrgPitchLeft = new GridBagConstraints();
		gbc_avrgPitchLeft.insets = new Insets(0, 0, 5, 0);
		gbc_avrgPitchLeft.gridx = 6;
		gbc_avrgPitchLeft.gridy = 5;
		panelValues.add(avrgPitchLeft, gbc_avrgPitchLeft);
		avrgPitchLeft.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Implant Taban Capi");
		GridBagConstraints gbc_lblNewLabel_11 = new GridBagConstraints();
		gbc_lblNewLabel_11.gridwidth = 4;
		gbc_lblNewLabel_11.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_11.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_11.gridx = 1;
		gbc_lblNewLabel_11.gridy = 6;
		panelValues.add(lblNewLabel_11, gbc_lblNewLabel_11);
		
		implantBaseWidthRight = new JFormattedTextField(NumberFormat.getNumberInstance());
		implantBaseWidthRight.setFont(new Font("Tahoma", Font.PLAIN, 9));
		GridBagConstraints gbc_implantBaseWidthRight = new GridBagConstraints();
		gbc_implantBaseWidthRight.insets = new Insets(0, 0, 5, 5);
		gbc_implantBaseWidthRight.gridx = 5;
		gbc_implantBaseWidthRight.gridy = 6;
		panelValues.add(implantBaseWidthRight, gbc_implantBaseWidthRight);
		implantBaseWidthRight.setColumns(10);
		
		implantBaseWidthLeft = new JFormattedTextField(NumberFormat.getNumberInstance());
		implantBaseWidthLeft.setFont(new Font("Tahoma", Font.PLAIN, 9));
		GridBagConstraints gbc_implantBaseWidthLeft = new GridBagConstraints();
		gbc_implantBaseWidthLeft.insets = new Insets(0, 0, 5, 0);
		gbc_implantBaseWidthLeft.gridx = 6;
		gbc_implantBaseWidthLeft.gridy = 6;
		panelValues.add(implantBaseWidthLeft, gbc_implantBaseWidthLeft);
		implantBaseWidthLeft.setColumns(10);
		
		JButton findImplant = new JButton("Implant Bul");
		findImplant.setFont(new Font("Tahoma", Font.PLAIN, 10));
		GridBagConstraints gbc_findImplant = new GridBagConstraints();
		gbc_findImplant.gridx = 6;
		gbc_findImplant.gridy = 7;
		panelValues.add(findImplant, gbc_findImplant);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		tabbedPane.addTab("Anatomik Implant", null, panel_2, null);
		findImplant.addActionListener(findImplantActionListener);
		
				
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
		
		JPanel centerPanel = new JPanel();
		mainPanel.add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		centerPanel.add(lblNewLabel_12, BorderLayout.WEST);
		
		//final Image img = new ;
		JPanel panel_4 = new JPanel();
		centerPanel.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel(){
			public void paintComponent(Graphics g) {
			    g.drawImage(new ImageIcon(BreastNewWindow.class.getResource("/icons/bckgrnd.png")).getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
			  }
			
			public Dimension getPreferredSize() {
		        return new Dimension(250,200);
		    }
		};
		panel_5.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				frame.setTitle(frame.getSize().getWidth() + " - " + frame.getSize().getHeight());
			}
		});
		panel_4.add(panel_5, BorderLayout.CENTER);
		
		JPanel panel_3 = new JPanel();
		panel_4.add(panel_3, BorderLayout.SOUTH);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));
		
		panelResultRight = new JPanel();
		panel_3.add(panelResultRight);
		panelResultRight.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		panelResultRight.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panelResultRight.setBorder(new TitledBorder(null, "Uygun \u0130mplant Sonucu", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelResultRight.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panelResultRight.add(scrollPane, BorderLayout.CENTER);
		
		foundImplantsTable = new JTable();
		foundImplantsTable.setFont(new Font("Tahoma", Font.PLAIN, 9));
		scrollPane.setViewportView(foundImplantsTable);
		scrollPane.setPreferredSize(new Dimension(foundImplantsTable.getWidth(), 75));
		foundImplantsTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"DIAMETER", "VOLUME", "PROJECTION", "PROFILE"
			}
		));
		panelResultLeft = new JPanel();
		panel_3.add(panelResultLeft);
		panelResultLeft.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panelResultLeft.setBorder(new TitledBorder(null, "Uygun Implant Sonucu (Sol)", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelResultLeft.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panelResultLeft.add(scrollPane_1, BorderLayout.CENTER);
		
		panelResultLeft.setVisible(false);
		
		foundImplantsTableLeft = new JTable();
		foundImplantsTableLeft.setFont(new Font("Tahoma", Font.PLAIN, 9));
		foundImplantsTableLeft.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"DIAMETER", "VOLUME", "PROJECTION", "PROFILE"
			}
		));
		foundImplantsTableLeft.getColumnModel().getColumn(0).setPreferredWidth(50);
		foundImplantsTableLeft.getColumnModel().getColumn(1).setPreferredWidth(50);
		foundImplantsTableLeft.getColumnModel().getColumn(2).setPreferredWidth(50);
		foundImplantsTableLeft.getColumnModel().getColumn(3).setPreferredWidth(50);
		scrollPane_1.setViewportView(foundImplantsTableLeft);
		scrollPane_1.setPreferredSize(new Dimension(foundImplantsTableLeft.getWidth(), 75));
		foundImplantsTable.getColumnModel().getColumn(0).setPreferredWidth(25);
		foundImplantsTable.getColumnModel().getColumn(1).setPreferredWidth(25);
		foundImplantsTable.getColumnModel().getColumn(2).setPreferredWidth(25);
		foundImplantsTable.getColumnModel().getColumn(3).setPreferredWidth(25);
		
		Border border = LineBorder.createBlackLineBorder();
		
		JPanel bottomPanel = new JPanel();
		mainPanel.add(bottomPanel, BorderLayout.SOUTH);
		bottomPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		bottomPanel.add(lblNewLabel_5, BorderLayout.NORTH);
		
		JMenuBar menuBar = new JMenuBar();
		frame.getContentPane().add(menuBar, BorderLayout.NORTH);
		
		JMenu mnFile = new JMenu("Dosya");
		menuBar.add(mnFile);
		
		JMenuItem mntmExit = new JMenuItem("Çıkış");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				
				System.out.println("OK");
				//System.exit(0);
			}
		});
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Görüntüle ");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ReportBean reportBean = new ReportBean();
				reportBean.setPatientHeight(patientHeight.getText());
				reportBean.setPatientAge(patientAge.getText());
				reportBean.setPatientName(patientName.getText());
				reportBean.setPatientWeight(patientWeight.getText());
				
				try {
					new ReportGenerator().show(reportBean);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(frame, "Görüntüleme başarısız, Hata:" + e.getMessage());
					e.printStackTrace();
				}
			}
		});
		mnFile.add(mntmNewMenuItem);
		mnFile.add(mntmExit);
		
		JMenu mnHelp = new JMenu("Yardım");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("Hakkında");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JDialog d6 = new JDialog(frame, "Hakkında", true);
				d6.getContentPane().add(new JLabel(new ImageIcon(BreastNewWindow.class.getResource("/icons/drkul.jpg"))));
				d6.setSize(400,200);
				d6.setLocationRelativeTo(null);
				d6.setVisible(true);
			 	//frame.get
			 	//jif.show();
			 	System.out.println("ok");
			 	//jif.setBounds(20*(windowCount%10), 20*(windowCount%10), width, height); 
			 	//jif.setContentPane(new ImageScroller(this, icon, 0, windowCount));
			}
		});
		mnHelp.add(mntmAbout);
		
		JInternalFrame jifAbout = new JInternalFrame(); 
		
		
		jifAbout.setClosable(true); 
		jifAbout.setMaximizable(false); 
		jifAbout.setIconifiable(false); 
		jifAbout.setResizable(true); 
	 	
		jifAbout.setVisible(false);
	 	//frame.add(jifAbout);				
	}

	private void setLookAndFeel() {
		try{
			UIManager.setLookAndFeel( new com.nilo.plaf.nimrod.NimRODLookAndFeel());
			//UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		}
		catch(Exception  e){
			try {
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
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
	
	private void handleDesiredClick(MouseEvent e){
		lblDesiredOutcomeLow.setBorder(unSelectedDesireBorder);
		lblDesiredOutcomeModerate.setBorder(unSelectedDesireBorder);
		lblDesiredOutcomeModeratePlus.setBorder(unSelectedDesireBorder);
		lblDesiredOutcomeHigh.setBorder(unSelectedDesireBorder);
		lblDesiredOutcomeUltraHigh.setBorder(unSelectedDesireBorder);
		
		
		if(e.getComponent().equals(lblDesiredOutcomeLow)){
			lblDesiredOutcomeLow.setBorder(selectedDesireBorder);
		}else if(e.getComponent().equals(lblDesiredOutcomeModerate)){
			lblDesiredOutcomeModerate.setBorder(selectedDesireBorder);
		}else if(e.getComponent().equals(lblDesiredOutcomeModeratePlus)){
			lblDesiredOutcomeModeratePlus.setBorder(selectedDesireBorder);
		}else if(e.getComponent().equals(lblDesiredOutcomeHigh)){
			lblDesiredOutcomeHigh.setBorder(selectedDesireBorder);
		}else if(e.getComponent().equals(lblDesiredOutcomeUltraHigh)){
			lblDesiredOutcomeUltraHigh.setBorder(selectedDesireBorder);
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
	
	public ImplantProfile getDesiredImplantProfile(){
		if (lblDesiredOutcomeLow.getBorder().equals(selectedDesireBorder)) {
			return ImplantProfile.LOW;
		} else if (lblDesiredOutcomeModerate.getBorder().equals(selectedDesireBorder)) {
			return ImplantProfile.MODERATE;
		} else if (lblDesiredOutcomeModeratePlus.getBorder().equals(selectedDesireBorder)) {
			return ImplantProfile.MODERATE_PLUS;
		} else if (lblDesiredOutcomeHigh.getBorder().equals(selectedDesireBorder)) {
			return ImplantProfile.HIGH;
		} else if (lblDesiredOutcomeUltraHigh.getBorder().equals(selectedDesireBorder)) {
			return ImplantProfile.ULTRA_HIGH;
		}
		return null;
	}

	public JFrame getFrame() {
		return frame;
	}

	public JTable getFoundImplantsTable() {
		return foundImplantsTable;
	}

	public JTable getFoundImplantsTableLeft() {
		return foundImplantsTableLeft;
	}

	public JPanel getPanelResultLeft() {
		return panelResultLeft;
	}

	public JPanel getPanelResultRight() {
		return panelResultRight;
	}

	public JRadioButton getRoundedSmooth() {
		return roundedSmooth;
	}

	public JRadioButton getRoundedGranuler() {
		return roundedGranuler;
	}
}
