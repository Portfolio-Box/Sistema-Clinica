package ar.com.clinicamedica.daos;

import static java.lang.Integer.valueOf;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ar.com.clinicamedica.dbconection.DbConection;
import ar.com.clinicamedica.model.Patient;

public class PatientDAO implements PatientDaoOperations{
	
	@Override
	public void insertPatient(Patient p) {
		
		String insertpatient = "INSERT INTO PACIENTE (DNI,NOMBRE,APELLIDO,DIRECCION,LOCALIDAD) values(?,?,?,?,?) ";
		Connection con = DbConection.getConection();
		try {
			con.setAutoCommit(false);
			PreparedStatement ps = con.prepareStatement(insertpatient);
			ps.setInt(1, p.getDni());
			ps.setString(2, p.getName());
			ps.setString(3, p.getSecondName());
			ps.setString(4, p.getDirection());
			ps.setString(5, p.getPlace());
			ps.executeUpdate();
		
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
	}
	@Override
	public void UpdatePatient(Patient a) {
		String updatepatient = "UPDATE PACIENTE SET NOMBRE=?,APELLIDO=?,DIRECCION=?,LOCALIDAD=? WHERE DNI=?";
		Connection con = DbConection.getConection();
		try {
			PreparedStatement ps = con.prepareStatement(updatepatient);
			ps.setString(1, a.getName());
			ps.setString(2, a.getSecondName());
			ps.setString(3, a.getDirection());
			ps.setString(4, a.getPlace());
			ps.setInt(5, a.getDni());
			ps.executeUpdate();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		
	}
	@Override
	public void deletePatient(String dni) {
		String deletepatient = "DELETE FROM PACIENTE WHERE DNI=?";
		Connection connection = DbConection.getConection();
		try (PreparedStatement st = connection.prepareStatement(deletepatient)) {
			st.setInt(1, valueOf(dni));
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public ArrayList<Patient> getPatients() {
		String patientlist = "SELECT P.DNI,P.NOMBRE,P.APELLIDO,P.DIRECCION,P.LOCALIDAD FROM PACIENTE P ";
		ArrayList<Patient> patient = new ArrayList<Patient>();
		try {
			Connection con = DbConection.getConection();
			PreparedStatement ps = con.prepareStatement(patientlist);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Patient p = new Patient(rs.getInt("DNI"), rs.getString("NOMBRE"), rs.getString("APELLIDO"),
				rs.getString("DIRECCION"), rs.getString("LOCALIDAD"));
				patient.add(p);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return patient;
	}

}
