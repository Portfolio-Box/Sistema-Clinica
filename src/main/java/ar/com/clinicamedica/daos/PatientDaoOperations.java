package ar.com.clinicamedica.daos;

import java.util.ArrayList;

import ar.com.clinicamedica.model.Patient;

public interface PatientDaoOperations {
	public void insertPatient(Patient p);
	public void UpdatePatient(Patient a);
	public void deletePatient(String dni);
	public ArrayList<Patient> getPatients();

}
