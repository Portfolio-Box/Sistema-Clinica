package ar.com.clinicamedica.controller;

import ar.com.clinicamedica.model.PatientTableModel;
import ar.com.clinicamedica.model.TurnTableModel;

public interface ReceptionOperationsController {
	public void registerPatient(String name, String secondName, String direction, String place, String dni);
	public void updatePatient(String name, String secondName, String direction, String place, String dni);
	public void deletePatient(String dni);
    public void RegisterTurn(String dni,String name,String secondName,String fecha,String hora,String consultorio
			  ,String medico);
	 
	public PatientTableModel updatePatientDao();
	public TurnTableModel updateTurnDao();
}
