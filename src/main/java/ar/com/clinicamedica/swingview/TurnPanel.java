package ar.com.clinicamedica.swingview;

import static javax.swing.BorderFactory.createTitledBorder;
import static javax.swing.border.TitledBorder.TOP;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableRowSorter;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import ar.com.clinicamedica.controller.ReceptionOperationsController;
import ar.com.clinicamedica.daos.TurnDAO;
import ar.com.clinicamedica.model.PatientTableModel;
import ar.com.clinicamedica.model.TurnTableModel;
import ar.com.clinicamedica.values.Fonts;

public class TurnPanel extends JPanel {
	private JTable table;
	private PatientTableModel patientTablemodel;
	private JTable table2;
	private TurnTableModel turnTableModel;
	private TableRowSorter<PatientTableModel> sorter;
	private JTextField filterText;
	private JScrollPane scrollPane;
	private JTextField name;
	private JTextField secondName;
	private JTextField dni;
	private JDateChooser date;
	private ReceptionOperationsController controller;
	private JButton accept;
	private String[] Medicos;
	private JComboBox<String> m ;
	private String[] consultorios ;
	private JComboBox<String> c1 ;
	private String[] hora;
	private JComboBox<String> hr ;
	private String comboConsultorio;
	private String comboMedico;
	private String hrs;

	private static final long serialVersionUID = 1L;

	public TurnPanel(ReceptionOperationsController controller) {
		this.controller = controller;
		this.patientTablemodel = controller.updatePatientDao();
		this.turnTableModel = controller.updateTurnDao();
		
		setLayout(new BorderLayout());
		add(createTurnTable(), BorderLayout.WEST);
		add(createPatientTable(), BorderLayout.CENTER);
		add(new FilterPanel(sorter,filterText),BorderLayout.NORTH);
		initComboBox();
		add(createForm(), BorderLayout.SOUTH);
		initlistener();
		

	}
	private void initComboBox() {
		Medicos = new String[] { "Fernando Corinaldesi", "Elias chanampa", "Jona Ponce", "Juan Perez",
				"Pedro Pepito", "Ariel Mesa", "Jorge Lopez" };
		m = new JComboBox<String>(Medicos);
		consultorios = new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
		c1 = new JComboBox<String>(consultorios);
		hora = new String[] { "08:00:00", "08:30:00", "09:00:00", "09:30:00", "10:00:00"
				, "10:30:00", "11:00:00", "11:30:00", "12:00:00", "12:30:00","13:00:00",
				"13:30:00","14:00:00","14:30:00","15:00:00","15:30:00","16:00:00","16:30:00",
				"17:00:00","17:30:00" };		
		hr = new JComboBox<String>(hora);
		
	}
	
	private JScrollPane createTurnTable() {
		table2 = new JTable(turnTableModel);
		JScrollPane pane = new JScrollPane(table2);
		pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		pane.setBorder(createTitledBorder(null, "LISTA DE TURNOS", TitledBorder.CENTER, TOP));
		return pane;
	}

	private JScrollPane createPatientTable() {
		table = new JTable(patientTablemodel);
		sorter = new TableRowSorter<PatientTableModel>(patientTablemodel);
		table.setRowSorter(sorter);
		scrollPane = new JScrollPane(table);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		table.addMouseListener(new MouseAdapter() {// listener para obtener los datos de las filas y columnas
			@Override
			public void mouseClicked(MouseEvent e) {
				int col = table.convertRowIndexToModel(table.getSelectedRow());
				dni.setText(table.getModel().getValueAt(col, 0).toString());
				name.setText(table.getModel().getValueAt(col, 1).toString());
				secondName.setText(table.getModel().getValueAt(col, 2).toString());
				//repaint();
			}
		
		});
		scrollPane.setBorder(createTitledBorder(null, "LISTA DE PACIENTES", TitledBorder.CENTER, TOP));
		return scrollPane;
	}
	

	private JPanel createForm() {
		JPanel pane = new JPanel();
		date = new JDateChooser();
		date.getDateEditor().setEnabled(false);
		((JTextFieldDateEditor)date.getDateEditor())
		.setDisabledTextColor(Color.darkGray);
	
		name = new JTextField(12);
		name.setEditable(false);;
		secondName = new JTextField(12);
		secondName.setEditable(false);
		dni = new JTextField(12);
		dni.setEditable(false);

		JLabel nameLabel = new JLabel("NOMBRE");
		JLabel secondNameLabel = new JLabel("APELLIDO");
		JLabel dniLabel = new JLabel("DNI");
		JLabel consultorio = new JLabel("CONSULTORIO");
		JLabel medico = new JLabel("MEDICO");
		JLabel fecha = new JLabel("FECHA");
		JLabel hora = new JLabel("HORA");

		nameLabel.setFont(Fonts.F);
		secondNameLabel.setFont(Fonts.F);
		dniLabel.setFont(Fonts.F);
		consultorio.setFont(Fonts.F);
		medico.setFont(Fonts.F);
		fecha.setFont(Fonts.F);
		hora.setFont(Fonts.F);

		nameLabel.setForeground(new Color(0, 122, 244));
		secondNameLabel.setForeground(new Color(0, 122, 244));
		dniLabel.setForeground(new Color(0, 122, 244));
		consultorio.setForeground(new Color(0, 122, 244));
		medico.setForeground(new Color(0, 122, 244));
		fecha.setForeground(new Color(0, 122, 244));
		hora.setForeground(new Color(0, 122, 244));

		pane.add(nameLabel);
		pane.add(name);
		pane.add(secondNameLabel);
		pane.add(secondName);
		pane.add(dniLabel);
		pane.add(dni);
		pane.add(consultorio);
		pane.add(c1);
		pane.add(fecha);
		pane.add(date);
		pane.add(medico);
		pane.add(m);
		pane.add(hora);
		pane.add(hr);

		accept = new JButton("ACEPTAR");
		accept.setFont(Fonts.F);
		accept.setForeground(Color.white);
		accept.setBackground(new Color(0, 122, 244));
		accept.setLayout(new FlowLayout());
		pane.add(accept);
		pane.setBorder(createTitledBorder(null, "ASIGNAR TURNO", TitledBorder.CENTER, TOP));
		pane.setLayout(new GridLayout(4, 4, 0, 0));

		return pane;
	}

	private void initlistener() {

		accept.addActionListener((event) -> {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String fecha=(String) sdf.format(date.getDate());
			comboConsultorio = c1.getItemAt(c1.getSelectedIndex());
			comboMedico = m.getItemAt(m.getSelectedIndex());
			hrs = hr.getItemAt(hr.getSelectedIndex());
			controller.RegisterTurn(dni.getText(), name.getText(), secondName.getText(),fecha,hrs,comboConsultorio, comboMedico);
			updateDao();
			clean();
			

		});
	}


	public void updateDao() {
		turnTableModel.update(new TurnDAO().getTurn());
		repaint();
	}

	public void clean() {
		dni.setText("");
		secondName.setText("");
		name.setText("");
	}

}
