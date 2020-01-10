package ar.com.clinicamedica.swingview;

import static javax.swing.BorderFactory.createTitledBorder;
import static javax.swing.border.TitledBorder.TOP;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableRowSorter;

import ar.com.clinicamedica.controller.ReceptionOperationsController;
import ar.com.clinicamedica.daos.PatientDAO;
import ar.com.clinicamedica.model.PatientTableModel;

public class PatientPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private PatientTableModel patientTablemodel;
	private CrudPanel add;
	private CrudPanel del;
	private CrudPanel mod;
	public String name;
	public String secondName;
	public String dni;
	public String direction;
	public String place;
	private TableRowSorter<PatientTableModel> sorter;
	private JTextField filterText;
    private JScrollPane scrollPane;

	public PatientPanel(ReceptionOperationsController controller) {
		
		this.patientTablemodel = controller.updatePatientDao();
		add = new CrudAdd(controller, this);
		mod = new CrudMod(controller, this);
		del = new CrudDel(controller, this);
		add(createSouth());
		add(new FilterPanel(sorter,filterText));
		add(add);
		add(mod);
		add(del);
		setLayout(new GridLayout(5,1,0,0));
		setBorder(new EmptyBorder(0, 0,0, 0));
		//setBackground(Color.WHITE);
		
	}
	    
	

	private JScrollPane createSouth() {
		table = new JTable(patientTablemodel);
		sorter = new TableRowSorter<PatientTableModel>(patientTablemodel);
		table.setRowSorter(sorter);
      	scrollPane = new JScrollPane(table);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		table.getTableHeader().setBackground(Color.BLACK);
		table.setGridColor(Color.BLACK);
	
		table.addMouseListener(new MouseAdapter() {// listener para obtener los datos de las filas y columnas

		@Override
			public void mouseClicked(MouseEvent e) {
				int col = table.convertRowIndexToModel(table.getSelectedRow());
				dni = table.getModel().getValueAt(col, 0).toString();
				name = table.getModel().getValueAt(col, 1).toString();
				secondName = table.getModel().getValueAt(col, 2).toString();
				direction = table.getModel().getValueAt(col, 3).toString();
				place = table.getModel().getValueAt(col, 4).toString();
				repaint();
				mod.addtext();
				del.addtext();

			}

		});
		scrollPane.setBorder(createTitledBorder(null, "LISTA DE PACIENTES", TitledBorder.CENTER, TOP));
		
		return scrollPane;
	}

	public void updateDao() {
		patientTablemodel.update(new PatientDAO().getPatients());
		repaint();
	}
	

}
