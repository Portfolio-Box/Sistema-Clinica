package ar.com.clinicamedica.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class TurnTableModel extends AbstractTableModel{
	private static final long serialVersionUID = 1L;
	private List<Turn> turn;
	private static String[] COLUMNAS = { "Id", "Dni", "Nombre", "Apellido", "Fecha","Hora","Consultorio","Medico"};

	public TurnTableModel (List<Turn> turn) {
		super();
		this.turn = turn;
	}

	public TurnTableModel () {

	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return turn.size();
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

		Turn t = this.turn.get(rowIndex);
		switch (columnIndex) {
		case 0:
			retorno = String.valueOf(t.getId());
			break;
		case 1:
			retorno = String.valueOf(t.getDni());
			break;
		case 2:
			retorno = t.getName();
			break;
		case 3:
			retorno = t.getSecondName();
			break;
		case 4:
			retorno = t.getFecha();
			break;
		case 5:
			retorno = t.getHora();
			break;
		case 6:
			retorno = String.valueOf(t.getConsultorio());
			break;
		case 7:
			retorno = t.getMedico();	
			break;

		}
		return retorno;
	}

	public void update(List<Turn> turn) {
		this.turn = turn;
		fireTableDataChanged();
	}

	@Override
	public String getColumnName(int index) {
		return COLUMNAS[index];
	}

	public Turn getInRow(int row) {
		return turn.get(row);

	}


}
