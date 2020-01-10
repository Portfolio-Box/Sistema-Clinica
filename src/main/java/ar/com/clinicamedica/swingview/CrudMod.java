package ar.com.clinicamedica.swingview;

import static javax.swing.BorderFactory.createTitledBorder;
import static javax.swing.border.TitledBorder.TOP;

import javax.swing.border.TitledBorder;

import ar.com.clinicamedica.controller.ReceptionOperationsController;

public class CrudMod extends CrudPanel {

	private static final long serialVersionUID = 1L;
	private ReceptionOperationsController controller;
	private PatientPanel patientpanel;

	public CrudMod(ReceptionOperationsController controller, PatientPanel patientpanel) {
		super();
		this.patientpanel = patientpanel;
		this.controller = controller;
		setBorder(createTitledBorder(null, "MODIFICAR", TitledBorder.CENTER, TOP));
		initlistener();

	}

	@Override
	public void initlistener() {
		this.accept.addActionListener((event) -> {
			controller.updatePatient(name.getText(), secondName.getText(), direccion.getText(), localidad.getText(),
					dni.getText());
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
