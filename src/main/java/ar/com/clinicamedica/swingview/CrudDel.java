package ar.com.clinicamedica.swingview;

import static javax.swing.BorderFactory.createTitledBorder;
import static javax.swing.border.TitledBorder.TOP;

import javax.swing.border.TitledBorder;

import ar.com.clinicamedica.controller.ReceptionOperationsController;

public class CrudDel extends CrudPanel {

	private static final long serialVersionUID = 1L;
	private ReceptionOperationsController controller;
	private PatientPanel patientpanel;
	

	public CrudDel(ReceptionOperationsController controller,PatientPanel patientpanel) {
		super();
		this.patientpanel=patientpanel;
        this.controller=controller;
        setBorder(createTitledBorder(null,"BORRAR", TitledBorder.CENTER, TOP));
		initlistener();
		
		this.dni.setEditable(false);
		this.name.setEditable(false);
		this.secondName.setEditable(false);
		this.direccion.setEditable(false); 
		this.localidad.setEditable(false); 


	}


	@Override
	public void initlistener() {
		this.accept.addActionListener((event) -> {
			controller.deletePatient(dni.getText());
			patientpanel.updateDao();
			clean();

		});
		// TODO Auto-generated method stub
		
	}


	@Override
	public void addtext() {
		// TODO Auto-generated method stub
		name.setText(patientpanel.name);
		secondName.setText(patientpanel.secondName);
		dni.setText(patientpanel.dni);
		direccion.setText(patientpanel.direction);
		localidad.setText(patientpanel.place);
		repaint();
		
	}
	
}
