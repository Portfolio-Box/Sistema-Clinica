package ar.com.clinicamedica.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ar.com.clinicamedica.dbconection.DbConection;
import ar.com.clinicamedica.model.Turn;

public class TurnDAO implements TurnDaoOperations{
	
	@Override
	public void insertTurn(Turn t) {
		String insertturn = "INSERT INTO TURNO (DNI,NOMBRE,APELLIDO,FECHA,HORA,CONSULTORIO,MEDICO) values(?,?,?,?,?,?,?) ";
		Connection con = DbConection.getConection();
		try {
			PreparedStatement ps = con.prepareStatement(insertturn);
			ps.setInt(1, t.getDni());
			ps.setString(2, t.getName());
			ps.setString(3, t.getSecondName());
			ps.setString(4, t.getFecha());
			ps.setString(5, t.getHora());
			ps.setInt(6, t.getConsultorio());
			ps.setString(7, t.getMedico());
			ps.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}
	@Override
	public ArrayList<Turn> getTurn() {
		String turnlist = "SELECT T.ID, T.DNI, T.NOMBRE, T.APELLIDO,T.FECHA ,T.HORA ,T.CONSULTORIO ,T.MEDICO FROM TURNO T ";
		ArrayList<Turn> turn = new ArrayList<Turn>();
		try {
			Connection con = DbConection.getConection();
			PreparedStatement ps = con.prepareStatement(turnlist);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Turn t = new Turn(rs.getInt("ID"), rs.getInt("DNI"), rs.getString("NOMBRE"), rs.getString("APELLIDO"),
						rs.getDate("FECHA").toString(), rs.getTime("HORA").toString(), rs.getInt("CONSULTORIO"),
						rs.getString("MEDICO"));

				turn.add(t);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return turn;
	}

}
