package ar.com.clinicamedica.swingadmin;

import static java.awt.BorderLayout.NORTH;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ar.com.clinicamedica.controller.AdminOperationsController;
import ar.com.clinicamedica.swingcustom.LoadBackground;
import ar.com.clinicamedica.swingcustom.MyTitleBar;
import ar.com.clinicamedica.swingcustom.SideButton;
import ar.com.clinicamedica.swingview.AboutView;

public class MainAdminView extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MyTitleBar titleView;
	private SideButton homeButton;
	private SideButton gestionButton;
	private LoadBackground BackGroundcontainer;
	private SideButton aboutButton;
	private SideButton exitButton;
	private JPanel cardPanel;
	private CardLayout cardLayout;
	private AdminOperationsController controller;

	public MainAdminView(AdminOperationsController controller) {
		this.controller=controller;
		setSize(1000, 700);
		titleView = new MyTitleBar(this,"admin");
		getContentPane().add(titleView, NORTH);
		getContentPane().add(createSidePanel(), BorderLayout.WEST);
		getContentPane().add(createCenter(), BorderLayout.CENTER);
		initListener();
		
		setUndecorated(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// TODO Auto-generated constructor stub
	}
	
	public void initListener() {

		gestionButton.addActionListener((e) -> {
			cardLayout.show(cardPanel, "gestion");

		});
		aboutButton.addActionListener((e) -> {
			cardLayout.show(cardPanel, "about");
		});
		homeButton.addActionListener((e) -> {
			cardLayout.show(cardPanel, "background");
		});
		
		exitButton.addActionListener((e) -> {
			dispose();
		});

	}
	private JPanel createCenter() {

		BackGroundcontainer = new LoadBackground("/images/adminfondo.png");

		cardPanel = new JPanel();
		cardPanel.setLayout(new CardLayout());
		cardPanel.add(BackGroundcontainer, "background");
		cardPanel.add(new AboutView("admin"), "about");

		cardLayout = (CardLayout) cardPanel.getLayout();
		return cardPanel;

	}

	private JPanel createSidePanel() {
		JPanel pane = new JPanel();
		pane.setLayout(new GridLayout(10, 1, 0, 0));
		pane.setBorder(new EmptyBorder(0, 0, 0, 0));
		homeButton = new SideButton("Inicio", "/images/home.png");
		gestionButton = new SideButton("Reportes", "/images/newUser.png");
		aboutButton = new SideButton("Acerca", "/images/about.png");
		exitButton = new SideButton("Salir", "/images/exit.png");
		pane.add(homeButton);
		pane.add(gestionButton);
		pane.add(aboutButton);
		pane.add(exitButton);
		pane.setBackground(new Color(0,0,0));
		return pane;
	}

	public void setVisible() {
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
