package ar.com.clinicamedica.swingview;

import static java.awt.BorderLayout.NORTH;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ar.com.clinicamedica.controller.ReceptionOperationsController;
import ar.com.clinicamedica.swingcustom.LoadBackground;
import ar.com.clinicamedica.swingcustom.MyTitleBar;
import ar.com.clinicamedica.swingcustom.SideButton;

public class MainRecepcionistView extends JFrame {

	private SideButton homeButton;
	private SideButton patientButton;
	private SideButton turnButton;
	private SideButton aboutButton;
	private SideButton exitButton;
	private MyTitleBar titleView;
	private static final long serialVersionUID = 1L;
	private LoadBackground BackGroundcontainer;
	private ReceptionOperationsController controller;
	private JPanel cardPanel;
	private CardLayout cardLayout;

	public MainRecepcionistView(ReceptionOperationsController controller) {
		this.controller = controller;
		setSize(1000, 700);
		titleView = new MyTitleBar(this, "main");
		getContentPane().add(titleView, NORTH);
		getContentPane().add(createSidePanel(), BorderLayout.WEST);
		getContentPane().add(createCenter(), BorderLayout.CENTER);
		initListener();
		setUndecorated(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void initListener() {

		patientButton.addActionListener((e) -> {
			cardLayout.show(cardPanel, "patient");

		});

		aboutButton.addActionListener((e) -> {
			cardLayout.show(cardPanel, "about");
		});
		homeButton.addActionListener((e) -> {
			cardLayout.show(cardPanel, "background");
		});
		turnButton.addActionListener((e) -> {
			cardLayout.show(cardPanel, "turno");
		});

		exitButton.addActionListener((e) -> {
			dispose();
		});

	}

	private JPanel createCenter() {

		BackGroundcontainer = new LoadBackground("/images/background3.jpg");

		cardPanel = new JPanel();
		cardPanel.setLayout(new CardLayout());
		cardPanel.add(BackGroundcontainer, "background");
		cardPanel.add(new PatientPanel(controller), "patient");
		cardPanel.add(new TurnPanel(controller), "turno");
		cardPanel.add(new AboutView("main"), "about");

		cardLayout = (CardLayout) cardPanel.getLayout();
		return cardPanel;

	}

	private JPanel createSidePanel() {
		JPanel pane = new JPanel();
		pane.setLayout(new GridLayout(10, 1, 0, 0));
		pane.setBorder(new EmptyBorder(0, 0, 0, 0));
		homeButton = new SideButton("Inicio", "/images/home.png");
		patientButton = new SideButton("Pacientes", "/images/newUser.png");
		turnButton = new SideButton("Turnos", "/images/turnotrans.png");
		aboutButton = new SideButton("Acerca", "/images/about.png");
		exitButton = new SideButton("Salir", "/images/exit.png");
		pane.add(homeButton);
		pane.add(patientButton);
		pane.add(turnButton);
		pane.add(aboutButton);
		pane.add(exitButton);
		pane.setBackground(new Color(0, 128, 255));
		return pane;
	}
	/*
	 * private JPanel createFooterPane() { JPanel pane = new JPanel();
	 * pane.setPreferredSize(new Dimension(900, 30)); pane.setBackground(new
	 * Color(91, 91, 255)); return pane; }
	 */
	public void setVisible() {
		setLocationRelativeTo(null);
		setVisible(true);
	}



}
