package ar.com.clinicamedica.validations;

import ar.com.clinicamedica.model.Patient;

public class PatientValidation {

	public void validation(Patient patient) {
		
		    validateDNI(patient);
		    validateName(patient);
		    validateSecondName(patient);
		    validateDirection(patient);
		    validatePlace(patient);
	}

	public boolean validateDNI(Patient patientpatient) {
		return false;
		
	}

    public boolean validateName(Patient patientpatient) {
		return false;
		
	}

    public boolean validateSecondName(Patient patientpatient) {
		return false;
	
    }

    public boolean validateDirection(Patient patientpatient) {
		return false;
	
    }
    public boolean validatePlace(Patient patientpatient) {
		return false;
    	
    }

}
