package ar.com.clinicamedica.swingview;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import ar.com.clinicamedica.values.Fonts;

public abstract class CrudPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JTextField name;
	public JTextField secondName;
	public JTextField dni;
	public JTextField direccion;
	public JTextField localidad;
	public JLabel title;
	public JPanel titlecontainer;
	public JLabel nameLabel;
	public JLabel secondNameLabel;
	public JLabel dniLabel;
	public JLabel localidadLabel;
	public JLabel direccionLabel;
	public JButton accept;

	public CrudPanel() {
		setLayout(new BorderLayout());
		add(createFields(), BorderLayout.CENTER);
		add(createButtons(), BorderLayout.SOUTH);
		// TODO Auto-generated constructor stub
	}
	public abstract void initlistener();
	
	public JPanel createFields() {

		JPanel pane = new JPanel();
		name = new JTextField(12);
		secondName = new JTextField(12);
		dni = new JTextField(12);
		direccion = new JTextField(12);
		localidad = new JTextField(12);
		
		nameLabel = new JLabel("NOMBRE");
		secondNameLabel = new JLabel("APELLIDO");
		dniLabel = new JLabel("DNI");
		direccionLabel = new JLabel("DIRECCION");
		localidadLabel = new JLabel("LOCALIDAD");

		nameLabel.setFont(Fonts.F);
		secondNameLabel.setFont(Fonts.F);
		dniLabel.setFont(Fonts.F);
		direccionLabel.setFont(Fonts.F);
		localidadLabel.setFont(Fonts.F);

		nameLabel.setForeground(new Color(0, 122, 244));
		secondNameLabel.setForeground(new Color(0, 122, 244));
		direccionLabel.setForeground(new Color(0, 122, 244));
		localidadLabel.setForeground(new Color(0, 122, 244));
		dniLabel.setForeground(new Color(0, 122, 244));

		pane.add(nameLabel);
		pane.add(secondNameLabel);
		pane.add(dniLabel);
		pane.add(direccionLabel);
		pane.add(localidadLabel);

		pane.add(name);
		pane.add(secondName);
		pane.add(dni);
		pane.add(direccion);
		pane.add(localidad);
		pane.setLayout(new GridLayout(2, 5, 0, 0));
		pane.setBorder(new EmptyBorder(0, 0, 0, 0));
	
		return pane;

	}

	public JPanel createButtons() {

		JPanel pane = new JPanel();
		accept = new JButton("ACEPTAR");
		accept.setFont(Fonts.F);
		accept.setForeground(Color.white);
		accept.setBackground(new Color(0, 122, 244));
		pane.add(accept);

		return pane;
	}
	public void clean() {
		dni.setText("");
		secondName.setText("");
		name.setText("");
		direccion.setText("");
		localidad.setText("");

	}
	public abstract void addtext();

}
