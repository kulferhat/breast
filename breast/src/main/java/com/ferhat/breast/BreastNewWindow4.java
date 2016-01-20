package com.ferhat.breast;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;

import javax.swing.border.CompoundBorder;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JRadioButton;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollBar;

import com.ferhat.breast.report.ReportBean;
import com.ferhat.breast.report.ReportGenerator;

public class BreastNewWindow4 extends JFrame {

	private JPanel contentPane;
	private JTextField patientName;
	private JPanel pnlPatientName;
	private JLabel lblNewLabel;
	private JTextField patientAge;
	private JTextField patientWeight;
	private JTextField patientHeight;
	private JLabel lblNewLabel_1;
	private JTextField breastBaseWidthRight;
	private JLabel lblNewLabel_2;
	private JLabel lblMemeTabanap;
	private JLabel lblPlanlananMemeTaban;
	private JTextField breastBaseWidthLeft;
	private JTextField plannedbreastBaseWidthRight;
	private JTextField plannedbreastBaseWidthLeft;
	private JLabel lblMemeTaban;
	private JLabel lblPlanlananMeme;
	private JLabel lblMedyalDoku;
	private JTextField medialPitchRight;
	private JTextField medialPitchLeft;
	private JLabel lblKalnl;
	private JLabel label;
	private JLabel lblKalnl_1;
	private JLabel lblLateralDoku;
	private JLabel label_2;
	private JTextField lateralPitchRight;
	private JTextField lateralPitchLeft;
	private JLabel lblLateralDoku_1;
	private JLabel label_4;
	private JLabel lblOrtalamaDoku;
	private JLabel label_3;
	private JTextField avrgPitchRight;
	private JTextField avrgPitchLeft;
	private JLabel lblOrtalamaDoku_1;
	private JLabel label_6;
	private JLabel lblImplantTaban;
	private JLabel lblap;
	private JTextField implantBaseWidthRight;
	private JTextField implantBaseWidthLeft;
	private JLabel label_1;
	private JLabel label_5;
	private JButton findImplant;
	private JRadioButton rdbtnDesiredOutcomeLow;
	private JRadioButton rdbtnDesiredOutcomeModerate;
	private JRadioButton rdbtnDesiredOutcomeModeratePlus;
	private JRadioButton rdbtnDesiredOutcomeHigh;
	private JRadioButton rdbtnDesiredOutcomeUltraHigh;
	private JRadioButton roundedGranuler;
	private JRadioButton roundedSmooth;
	private JLabel lblPrzlYzey;
	private JPanel panelResultRightBreast;
	private JTable foundImplantsTableRight;
	private JPanel panelResultLeftBreast;
	private JScrollPane scrollPane_1;
	private JTable foundImplantsTableLeft;
	private JFrame jframe;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BreastNewWindow4 frame = new BreastNewWindow4(new FindImplantItemActionListener(null, null));
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BreastNewWindow4(FindImplantItemActionListener findImplantActionListener) {
		jframe = this;
		initialize();
		
		prepareActionHandlers(findImplantActionListener);
		findImplantActionListener.registerWindow(this);
		setVisible(true);
	}
	
	
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 10, 1145, 677);
		
		initializeMenu();
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnlBackground = new JPanel(){
			public void paintComponent(Graphics g) {
			    g.drawImage(new ImageIcon(BreastNewWindow.class.getResource("/icons/bckgrnd.png")).getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
			}
		};
		//pnlBackground.addMouseMotionListener(new MouseMotionAdapter() {
		//	@Override
		//	public void mouseMoved(MouseEvent arg0) {
		//		lblNewLabel_1.setText(arg0.getX() + "  " + arg0.getY());
		//	}
		//});
		pnlBackground.setBounds(20, 87, 603, 512);
		contentPane.add(pnlBackground);
		pnlBackground.setLayout(null);
		
		breastBaseWidthRight = new JTextField();
		breastBaseWidthRight.setBounds(241, 402, 46, 20);
		pnlBackground.add(breastBaseWidthRight);
		breastBaseWidthRight.setColumns(10);
		
		lblNewLabel_2 = new JLabel("İstenen Sonuç:");
		lblNewLabel_2.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setBounds(60, 487, 79, 14);
		pnlBackground.add(lblNewLabel_2);
		
		ButtonGroup desiredOutcomeGroup = new ButtonGroup();

		rdbtnDesiredOutcomeLow = new JRadioButton("Low");
		rdbtnDesiredOutcomeLow.setSelected(true);
		rdbtnDesiredOutcomeLow.setFont(new Font("SansSerif", Font.PLAIN, 10));
		rdbtnDesiredOutcomeLow.setForeground(Color.BLUE);
		rdbtnDesiredOutcomeLow.setBounds(145, 482, 55, 23);
		pnlBackground.add(rdbtnDesiredOutcomeLow);
		desiredOutcomeGroup.add(rdbtnDesiredOutcomeLow);
		
		rdbtnDesiredOutcomeModerate = new JRadioButton("Moderate");
		rdbtnDesiredOutcomeModerate.setFont(new Font("SansSerif", Font.PLAIN, 10));
		rdbtnDesiredOutcomeModerate.setForeground(Color.BLUE);
		rdbtnDesiredOutcomeModerate.setBounds(202, 482, 79, 23);
		pnlBackground.add(rdbtnDesiredOutcomeModerate);
		desiredOutcomeGroup.add(rdbtnDesiredOutcomeModerate);
		
		rdbtnDesiredOutcomeModeratePlus = new JRadioButton("Moderate+");
		rdbtnDesiredOutcomeModeratePlus.setFont(new Font("SansSerif", Font.PLAIN, 10));
		rdbtnDesiredOutcomeModeratePlus.setForeground(Color.BLUE);
		rdbtnDesiredOutcomeModeratePlus.setBounds(283, 482, 79, 23);
		pnlBackground.add(rdbtnDesiredOutcomeModeratePlus);
		desiredOutcomeGroup.add(rdbtnDesiredOutcomeModeratePlus);

		rdbtnDesiredOutcomeHigh = new JRadioButton("High");
		rdbtnDesiredOutcomeHigh.setFont(new Font("SansSerif", Font.PLAIN, 10));
		rdbtnDesiredOutcomeHigh.setForeground(Color.BLUE);
		rdbtnDesiredOutcomeHigh.setBounds(364, 482, 55, 23);
		pnlBackground.add(rdbtnDesiredOutcomeHigh);
		desiredOutcomeGroup.add(rdbtnDesiredOutcomeHigh);
		
		rdbtnDesiredOutcomeUltraHigh = new JRadioButton("UltraHigh");
		rdbtnDesiredOutcomeUltraHigh.setFont(new Font("SansSerif", Font.PLAIN, 10));
		rdbtnDesiredOutcomeUltraHigh.setForeground(Color.BLUE);
		rdbtnDesiredOutcomeUltraHigh.setBounds(421, 482, 79, 23);
		pnlBackground.add(rdbtnDesiredOutcomeUltraHigh);
		desiredOutcomeGroup.add(rdbtnDesiredOutcomeUltraHigh);

		lblMemeTabanap = new JLabel("Meme Taban Çapı:");
		lblMemeTabanap.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblMemeTabanap.setForeground(Color.BLUE);
		lblMemeTabanap.setBounds(138, 402, 97, 14);
		pnlBackground.add(lblMemeTabanap);
		
		lblPlanlananMemeTaban = new JLabel("Planlanan Meme Taban Çapı:");
		lblPlanlananMemeTaban.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblPlanlananMemeTaban.setForeground(Color.BLUE);
		lblPlanlananMemeTaban.setBounds(88, 427, 146, 14);
		pnlBackground.add(lblPlanlananMemeTaban);
		
		breastBaseWidthLeft = new JTextField();
		breastBaseWidthLeft.setColumns(10);
		breastBaseWidthLeft.setBounds(328, 402, 46, 20);
		pnlBackground.add(breastBaseWidthLeft);
		
		plannedbreastBaseWidthRight = new JTextField();
		plannedbreastBaseWidthRight.setColumns(10);
		plannedbreastBaseWidthRight.setBounds(241, 427, 46, 20);
		pnlBackground.add(plannedbreastBaseWidthRight);
		
		plannedbreastBaseWidthLeft = new JTextField();
		plannedbreastBaseWidthLeft.setColumns(10);
		plannedbreastBaseWidthLeft.setBounds(328, 427, 45, 20);
		pnlBackground.add(plannedbreastBaseWidthLeft);
		
		lblMemeTaban = new JLabel(": Meme Taban Çapı");
		lblMemeTaban.setForeground(Color.BLUE);
		lblMemeTaban.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblMemeTaban.setBounds(384, 405, 97, 14);
		pnlBackground.add(lblMemeTaban);
		
		lblPlanlananMeme = new JLabel(": Planlanan Meme Taban Çapı");
		lblPlanlananMeme.setForeground(Color.BLUE);
		lblPlanlananMeme.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblPlanlananMeme.setBounds(384, 427, 157, 14);
		pnlBackground.add(lblPlanlananMeme);
		
		lblMedyalDoku = new JLabel("Medyal Doku");
		lblMedyalDoku.setForeground(Color.BLUE);
		lblMedyalDoku.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblMedyalDoku.setBounds(156, 182, 79, 14);
		pnlBackground.add(lblMedyalDoku);
		
		medialPitchRight = new JTextField();
		medialPitchRight.setColumns(10);
		medialPitchRight.setBounds(241, 189, 46, 20);
		pnlBackground.add(medialPitchRight);
		
		medialPitchLeft = new JTextField();
		medialPitchLeft.setColumns(10);
		medialPitchLeft.setBounds(328, 189, 46, 20);
		pnlBackground.add(medialPitchLeft);
		
		lblKalnl = new JLabel("Kalınlığı:");
		lblKalnl.setForeground(Color.BLUE);
		lblKalnl.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblKalnl.setBounds(166, 195, 55, 14);
		pnlBackground.add(lblKalnl);
		
		label = new JLabel("Medyal Doku");
		label.setForeground(Color.BLUE);
		label.setFont(new Font("SansSerif", Font.PLAIN, 10));
		label.setBounds(388, 182, 79, 14);
		pnlBackground.add(label);
		
		lblKalnl_1 = new JLabel(": Kalınlığı");
		lblKalnl_1.setForeground(Color.BLUE);
		lblKalnl_1.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblKalnl_1.setBounds(398, 195, 55, 14);
		pnlBackground.add(lblKalnl_1);
		
		lblLateralDoku = new JLabel("Lateral Doku");
		lblLateralDoku.setForeground(Color.BLUE);
		lblLateralDoku.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblLateralDoku.setBounds(156, 220, 79, 14);
		pnlBackground.add(lblLateralDoku);
		
		label_2 = new JLabel("Kalınlığı:");
		label_2.setForeground(Color.BLUE);
		label_2.setFont(new Font("SansSerif", Font.PLAIN, 10));
		label_2.setBounds(166, 233, 55, 14);
		pnlBackground.add(label_2);
		
		lateralPitchRight = new JTextField();
		lateralPitchRight.setColumns(10);
		lateralPitchRight.setBounds(241, 227, 46, 20);
		pnlBackground.add(lateralPitchRight);
		
		lateralPitchLeft = new JTextField();
		lateralPitchLeft.setColumns(10);
		lateralPitchLeft.setBounds(328, 227, 46, 20);
		pnlBackground.add(lateralPitchLeft);
		
		lblLateralDoku_1 = new JLabel("Lateral Doku");
		lblLateralDoku_1.setForeground(Color.BLUE);
		lblLateralDoku_1.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblLateralDoku_1.setBounds(388, 220, 79, 14);
		pnlBackground.add(lblLateralDoku_1);
		
		label_4 = new JLabel(": Kalınlığı");
		label_4.setForeground(Color.BLUE);
		label_4.setFont(new Font("SansSerif", Font.PLAIN, 10));
		label_4.setBounds(398, 233, 55, 14);
		pnlBackground.add(label_4);
		
		lblOrtalamaDoku = new JLabel("Ortalama Doku");
		lblOrtalamaDoku.setForeground(Color.BLUE);
		lblOrtalamaDoku.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblOrtalamaDoku.setBounds(156, 256, 79, 14);
		pnlBackground.add(lblOrtalamaDoku);
		
		label_3 = new JLabel("Kalınlığı:");
		label_3.setForeground(Color.BLUE);
		label_3.setFont(new Font("SansSerif", Font.PLAIN, 10));
		label_3.setBounds(166, 269, 55, 14);
		pnlBackground.add(label_3);
		
		avrgPitchRight = new JTextField();
		avrgPitchRight.setColumns(10);
		avrgPitchRight.setBounds(241, 263, 46, 20);
		pnlBackground.add(avrgPitchRight);
		
		avrgPitchLeft = new JTextField();
		avrgPitchLeft.setColumns(10);
		avrgPitchLeft.setBounds(328, 263, 46, 20);
		pnlBackground.add(avrgPitchLeft);
		
		lblOrtalamaDoku_1 = new JLabel("Ortalama Doku");
		lblOrtalamaDoku_1.setForeground(Color.BLUE);
		lblOrtalamaDoku_1.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblOrtalamaDoku_1.setBounds(388, 256, 79, 14);
		pnlBackground.add(lblOrtalamaDoku_1);
		
		label_6 = new JLabel(": Kalınlığı");
		label_6.setForeground(Color.BLUE);
		label_6.setFont(new Font("SansSerif", Font.PLAIN, 10));
		label_6.setBounds(398, 269, 55, 14);
		pnlBackground.add(label_6);
		
		lblImplantTaban = new JLabel("Implant Taban");
		lblImplantTaban.setForeground(Color.BLUE);
		lblImplantTaban.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblImplantTaban.setBounds(156, 289, 79, 14);
		pnlBackground.add(lblImplantTaban);
		
		lblap = new JLabel("Çapı:");
		lblap.setForeground(Color.BLUE);
		lblap.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblap.setBounds(166, 302, 55, 14);
		pnlBackground.add(lblap);
		
		implantBaseWidthRight = new JTextField();
		implantBaseWidthRight.setColumns(10);
		implantBaseWidthRight.setBounds(241, 296, 46, 20);
		pnlBackground.add(implantBaseWidthRight);
		
		implantBaseWidthLeft = new JTextField();
		implantBaseWidthLeft.setColumns(10);
		implantBaseWidthLeft.setBounds(328, 296, 46, 20);
		pnlBackground.add(implantBaseWidthLeft);
		
		label_1 = new JLabel("Implant Taban");
		label_1.setForeground(Color.BLUE);
		label_1.setFont(new Font("SansSerif", Font.PLAIN, 10));
		label_1.setBounds(388, 294, 79, 14);
		pnlBackground.add(label_1);
		
		label_5 = new JLabel("Çapı:");
		label_5.setForeground(Color.BLUE);
		label_5.setFont(new Font("SansSerif", Font.PLAIN, 10));
		label_5.setBounds(398, 307, 55, 14);
		pnlBackground.add(label_5);
		
		findImplant = new JButton("İmplant Bul");
		findImplant.setFont(new Font("SansSerif", Font.PLAIN, 10));
		findImplant.setBounds(506, 483, 89, 23);
		pnlBackground.add(findImplant);
		
		ButtonGroup roundImplantGroup = new ButtonGroup();
		
		roundedGranuler = new JRadioButton("");
		roundedGranuler.setForeground(Color.BLUE);
		roundedGranuler.setFont(new Font("SansSerif", Font.PLAIN, 10));
		roundedGranuler.setBounds(321, 55, 21, 23);
		pnlBackground.add(roundedGranuler);
		roundImplantGroup.add(roundedGranuler);
		
		roundedSmooth = new JRadioButton("");
		roundedSmooth.setSelected(true);
		roundedSmooth.setHorizontalAlignment(SwingConstants.LEFT);
		roundedSmooth.setBounds(266, 55, 21, 23);
		pnlBackground.add(roundedSmooth);
		roundImplantGroup.add(roundedSmooth);
		
		lblPrzlYzey = new JLabel("Düz Yüzey");
		lblPrzlYzey.setForeground(Color.BLUE);
		lblPrzlYzey.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblPrzlYzey.setBounds(181, 59, 79, 14);
		pnlBackground.add(lblPrzlYzey);
		
		JLabel label_7 = new JLabel("Pürüzlü Yüzey");
		label_7.setForeground(Color.BLUE);
		label_7.setFont(new Font("SansSerif", Font.PLAIN, 10));
		label_7.setBounds(351, 59, 79, 14);
		pnlBackground.add(label_7);
		
		pnlPatientName = new JPanel();
		pnlPatientName.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlPatientName.setBounds(10, 11, 411, 65);
		contentPane.add(pnlPatientName);
		pnlPatientName.setLayout(null);
		
		lblNewLabel = new JLabel("Hasta Adı :");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblNewLabel.setBounds(10, 11, 65, 14);
		pnlPatientName.add(lblNewLabel);
		
		patientName = new JTextField();
		patientName.setBounds(85, 8, 316, 20);
		pnlPatientName.add(patientName);
		patientName.setColumns(10);
		
		JLabel lblYa = new JLabel("Yaş :");
		lblYa.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblYa.setBounds(38, 42, 44, 14);
		pnlPatientName.add(lblYa);
		
		patientAge = new JTextField();
		patientAge.setColumns(10);
		patientAge.setBounds(85, 39, 44, 20);
		pnlPatientName.add(patientAge);
		
		JLabel lblKilo = new JLabel("Kilo :");
		lblKilo.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblKilo.setBounds(139, 42, 44, 14);
		pnlPatientName.add(lblKilo);
		
		patientWeight = new JTextField();
		patientWeight.setColumns(10);
		patientWeight.setBounds(181, 39, 44, 20);
		pnlPatientName.add(patientWeight);
		
		JLabel lblBoy = new JLabel("Boy :");
		lblBoy.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblBoy.setBounds(235, 42, 44, 14);
		pnlPatientName.add(lblBoy);
		
		patientHeight = new JTextField();
		patientHeight.setColumns(10);
		patientHeight.setBounds(274, 39, 44, 20);
		pnlPatientName.add(patientHeight);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(442, 28, 104, 14);
		contentPane.add(lblNewLabel_1);
		
		panelResultRightBreast = new JPanel();
		panelResultRightBreast.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Uygun \u0130mplant Sonucu (Sa\u011F)", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelResultRightBreast.setBounds(633, 87, 476, 166);
		contentPane.add(panelResultRightBreast);
		panelResultRightBreast.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panelResultRightBreast.add(scrollPane);
		
		foundImplantsTableRight = new JTable();
		foundImplantsTableRight.setFont(new Font("Tahoma", Font.PLAIN, 9));
		scrollPane.setViewportView(foundImplantsTableRight);
		scrollPane.setPreferredSize(new Dimension(foundImplantsTableRight.getWidth(), 75));
		foundImplantsTableRight.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"DIAMETER", "VOLUME", "PROJECTION", "PROFILE"
			}
		));
		
		panelResultLeftBreast = new JPanel();
		panelResultLeftBreast.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Uygun \u0130mplant Sonucu (Sol)", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelResultLeftBreast.setBounds(633, 274, 476, 166);
		contentPane.add(panelResultLeftBreast);
		panelResultLeftBreast.setLayout(new BorderLayout(0, 0));
		
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panelResultLeftBreast.add(scrollPane_1);
				
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
		foundImplantsTableRight.getColumnModel().getColumn(0).setPreferredWidth(25);
		foundImplantsTableRight.getColumnModel().getColumn(1).setPreferredWidth(25);
		foundImplantsTableRight.getColumnModel().getColumn(2).setPreferredWidth(25);
		foundImplantsTableRight.getColumnModel().getColumn(3).setPreferredWidth(25);
		
	}

	private void initializeMenu() {
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu dosya = new JMenu("Dosya");
		menuBar.add(dosya);
		
		JMenuItem display = new JMenuItem("Görüntüle");
		display.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ReportBean reportBean = new ReportBean();
				reportBean.setPatientHeight(patientHeight.getText());
				reportBean.setPatientAge(patientAge.getText());
				reportBean.setPatientName(patientName.getText());
				reportBean.setPatientWeight(patientWeight.getText());
				
				try {
					new ReportGenerator().show(reportBean);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(getContentPane(), "Görüntüleme başarısız, Hata:" + e.getMessage());
					e.printStackTrace();
				}
			}
		});
		dosya.add(display);
		
		JMenuItem exit = new JMenuItem("Çıkış");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
				System.exit(0);
			}
		});
		dosya.add(exit);
		
		JMenu mnYardm = new JMenu("Yardım");
		menuBar.add(mnYardm);
		
		JMenuItem about = new JMenuItem("Hakkında");
		about.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JDialog d6 = new JDialog(jframe, "Hakkında", true);
				d6.getContentPane().add(new JLabel(new ImageIcon(BreastNewWindow.class.getResource("/icons/drkul.jpg"))));
				d6.setSize(400,200);
				d6.setLocationRelativeTo(null);
				d6.setVisible(true);
			}
		});
		mnYardm.add(about);
	}

	private void prepareActionHandlers(ActionListener findImplantActionListener) {
		findImplant.addActionListener(findImplantActionListener);
		
		
		breastBaseWidthRight.getDocument().addDocumentListener(
				new DocumentListener() {
					public void changedUpdate(DocumentEvent e) {

					}

					public void removeUpdate(DocumentEvent e) {
						breastBaseWidthLeft.setText(breastBaseWidthRight
								.getText());
						plannedbreastBaseWidthRight
								.setText(breastBaseWidthRight.getText());
					}

					public void insertUpdate(DocumentEvent e) {
						breastBaseWidthLeft.setText(breastBaseWidthRight
								.getText());
						plannedbreastBaseWidthRight
								.setText(breastBaseWidthRight.getText());
					}
				});

		breastBaseWidthLeft.getDocument().addDocumentListener(
				new DocumentListener() {
					public void changedUpdate(DocumentEvent e) {

					}

					public void removeUpdate(DocumentEvent e) {
						plannedbreastBaseWidthLeft.setText(breastBaseWidthLeft
								.getText());
					}

					public void insertUpdate(DocumentEvent e) {
						plannedbreastBaseWidthLeft.setText(breastBaseWidthLeft
								.getText());
					}
				});

		medialPitchRight.getDocument().addDocumentListener(
				new DocumentListener() {
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

		medialPitchLeft.getDocument().addDocumentListener(
				new DocumentListener() {
					public void changedUpdate(DocumentEvent e) {

					}

					public void removeUpdate(DocumentEvent e) {
						handleAveragePitchLeft();
					}

					public void insertUpdate(DocumentEvent e) {
						handleAveragePitchLeft();
					}
				});

		lateralPitchRight.getDocument().addDocumentListener(
				new DocumentListener() {
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

		lateralPitchLeft.getDocument().addDocumentListener(
				new DocumentListener() {
					public void changedUpdate(DocumentEvent e) {

					}

					public void removeUpdate(DocumentEvent e) {
						handleAveragePitchLeft();
					}

					public void insertUpdate(DocumentEvent e) {
						handleAveragePitchLeft();
					}
				});

		avrgPitchRight.getDocument().addDocumentListener(
				new DocumentListener() {
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

		plannedbreastBaseWidthRight.getDocument().addDocumentListener(
				new DocumentListener() {
					public void changedUpdate(DocumentEvent e) {

					}

					public void removeUpdate(DocumentEvent e) {
						handleImplantBaseWidthRight();
					}

					public void insertUpdate(DocumentEvent e) {
						handleImplantBaseWidthRight();
					}
				});

		plannedbreastBaseWidthLeft.getDocument().addDocumentListener(
				new DocumentListener() {
					public void changedUpdate(DocumentEvent e) {

					}

					public void removeUpdate(DocumentEvent e) {
						handleImplantBaseWidthLeft();
					}

					public void insertUpdate(DocumentEvent e) {
						handleImplantBaseWidthLeft();
					}
				});

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
	
	public ImplantProfile getDesiredImplantProfile(){
		if (rdbtnDesiredOutcomeLow.isSelected()) {
			return ImplantProfile.LOW;
		} else if (rdbtnDesiredOutcomeModerate.isSelected()) {
			return ImplantProfile.MODERATE;
		} else if (rdbtnDesiredOutcomeModeratePlus.isSelected()) {
			return ImplantProfile.MODERATE_PLUS;
		} else if (rdbtnDesiredOutcomeHigh.isSelected()) {
			return ImplantProfile.HIGH;
		} else if (rdbtnDesiredOutcomeUltraHigh.isSelected()) {
			return ImplantProfile.ULTRA_HIGH;
		}
		return null;
	}

	public JTextField getBreastBaseWidthRight() {
		return breastBaseWidthRight;
	}

	public JTextField getBreastBaseWidthLeft() {
		return breastBaseWidthLeft;
	}

	public JTextField getPlannedbreastBaseWidthRight() {
		return plannedbreastBaseWidthRight;
	}

	public JTextField getPlannedbreastBaseWidthLeft() {
		return plannedbreastBaseWidthLeft;
	}

	public JTextField getMedialPitchRight() {
		return medialPitchRight;
	}

	public JTextField getMedialPitchLeft() {
		return medialPitchLeft;
	}

	public JTextField getLateralPitchRight() {
		return lateralPitchRight;
	}

	public JTextField getLateralPitchLeft() {
		return lateralPitchLeft;
	}

	public JTextField getAvrgPitchRight() {
		return avrgPitchRight;
	}

	public JTextField getAvrgPitchLeft() {
		return avrgPitchLeft;
	}

	public JTextField getImplantBaseWidthRight() {
		return implantBaseWidthRight;
	}

	public JTextField getImplantBaseWidthLeft() {
		return implantBaseWidthLeft;
	}

	public JRadioButton getRdbtnDesiredOutcomeLow() {
		return rdbtnDesiredOutcomeLow;
	}

	public JRadioButton getRdbtnDesiredOutcomeModerate() {
		return rdbtnDesiredOutcomeModerate;
	}

	public JRadioButton getRdbtnDesiredOutcomeModeratePlus() {
		return rdbtnDesiredOutcomeModeratePlus;
	}

	public JRadioButton getRdbtnDesiredOutcomeHigh() {
		return rdbtnDesiredOutcomeHigh;
	}

	public JRadioButton getRdbtnDesiredOutcomeUltraHigh() {
		return rdbtnDesiredOutcomeUltraHigh;
	}

	public JRadioButton getRoundedGranuler() {
		return roundedGranuler;
	}

	public JRadioButton getRoundedSmooth() {
		return roundedSmooth;
	}

	public JTable getFoundImplantsTable() {
		return foundImplantsTableRight;
	}

	public JTable getFoundImplantsTableLeft() {
		return foundImplantsTableLeft;
	}
}
