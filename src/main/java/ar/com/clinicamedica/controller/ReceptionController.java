package ar.com.clinicamedica.controller;

import ar.com.clinicamedica.daos.PatientDAO;
import ar.com.clinicamedica.daos.PatientDaoOperations;
import ar.com.clinicamedica.daos.TurnDAO;
import ar.com.clinicamedica.daos.TurnDaoOperations;
import ar.com.clinicamedica.model.Patient;
import ar.com.clinicamedica.model.PatientTableModel;
import ar.com.clinicamedica.model.Turn;
import ar.com.clinicamedica.model.TurnTableModel;

public class ReceptionController implements ReceptionOperationsController {
	private PatientTableModel patientTableModel;
	private TurnTableModel turnTableModel;
	private PatientDaoOperations patientdao;
	private TurnDaoOperations turnDao;

	@Override
	public void registerPatient(String name, String secondName, String direction, String place, String dni) {
		int dniP = Integer.parseInt(dni);
		Patient patient = new Patient(dniP, name, secondName, direction, place);
		patientdao = new PatientDAO();
		patientdao.insertPatient(patient);

	}

	@Override
	public void updatePatient(String name, String secondName, String direction, String place, String dni) {

		int dniP = Integer.parseInt(dni);
		Patient patient = new Patient(dniP, name, secondName, direction, place);
		patientdao = new PatientDAO();
		patientdao.UpdatePatient(patient);

	}

	@Override
	public void deletePatient(String dni) {
		patientdao = new PatientDAO();
		patientdao.deletePatient(dni);
	}

	@Override
	public void RegisterTurn(String dni, String name, String secondName, String fecha, String hora, String consultorio,
			String medico) {
		int dnit = Integer.parseInt(dni);
		int cont = Integer.parseInt(consultorio);
		Turn turn = new Turn(dnit, name, secondName, fecha, hora, cont, medico);
		turnDao = new TurnDAO();
		turnDao.insertTurn(turn);

	}

	@Override
	public PatientTableModel updatePatientDao() {
		patientTableModel = new PatientTableModel();
		patientTableModel.update(new PatientDAO().getPatients());
		return patientTableModel;

		// TODO Auto-generated method stub

	}

	@Override
	public TurnTableModel updateTurnDao() {
		turnTableModel = new TurnTableModel();
		turnTableModel.update(new TurnDAO().getTurn());
		return turnTableModel;
		// TODO Auto-generated method stub

	}

}
