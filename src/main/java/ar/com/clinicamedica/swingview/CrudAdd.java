package ar.com.clinicamedica.swingview;

import static javax.swing.BorderFactory.createTitledBorder;
import static javax.swing.border.TitledBorder.TOP;

import javax.swing.border.TitledBorder;

import ar.com.clinicamedica.controller.ReceptionOperationsController;

public class CrudAdd extends CrudPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ReceptionOperationsController controller;
	private PatientPanel patientpanel;
			
	public CrudAdd(ReceptionOperationsController controller,PatientPanel patientpanel) {
		super();
		this.patientpanel=patientpanel;
        this.controller=controller;
        setBorder(createTitledBorder(null, "AGREGAR", TitledBorder.CENTER, TOP));
        initlistener();
		
		}

	@Override
	public void initlistener() {
		accept.addActionListener((event) -> {
			controller.registerPatient(name.getText(), secondName.getText(), direccion.getText(), localidad.getText(),
					dni.getText());
					clean();
					patientpanel.updateDao();

		});
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addtext() {
		// TODO Auto-generated method stub
		
	}
	

}
