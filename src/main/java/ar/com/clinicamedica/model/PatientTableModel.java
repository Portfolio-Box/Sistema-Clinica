package ar.com.clinicamedica.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class PatientTableModel extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	private List<Patient> patient;
	private static String[] COLUMNAS = { "Dni", "Nombre", "Apellido", "Direccion", "Localidad" };

	public PatientTableModel(List<Patient> patient) {
		super();
		this.patient = patient;
	}

	public PatientTableModel() {

	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return patient.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return COLUMNAS.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		Object retorno = null;

		Patient p = this.patient.get(rowIndex);
		switch (columnIndex) {
		case 0:
			retorno = String.valueOf(p.getDni());
			break;
		case 1:
			retorno = p.getName();
			break;
		case 2:
			retorno = p.getSecondName();
			break;
		case 3:
			retorno = p.getDirection();
			break;
		case 4:
			retorno = p.getPlace();
			break;

		}
		return retorno;
	}

	public void update(List<Patient> patient) {
		this.patient = patient;
		fireTableDataChanged();
	}

	@Override
	public String getColumnName(int index) {
		return COLUMNAS[index];
	}

	public Patient getInRow(int row) {
		return patient.get(row);

	}

}
