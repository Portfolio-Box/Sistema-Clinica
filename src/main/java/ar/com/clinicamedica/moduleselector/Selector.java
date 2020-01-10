package ar.com.clinicamedica.moduleselector;

import ar.com.clinicamedica.controller.AdminController;
import ar.com.clinicamedica.controller.AdminOperationsController;
import ar.com.clinicamedica.controller.MedicController;
import ar.com.clinicamedica.controller.MedicOperationsController;
import ar.com.clinicamedica.controller.ReceptionController;
import ar.com.clinicamedica.controller.ReceptionOperationsController;
import ar.com.clinicamedica.swingadmin.MainAdminView;
import ar.com.clinicamedica.swingmedicview.MainMedicView;
import ar.com.clinicamedica.swingview.MainRecepcionistView;

public class Selector implements SelectorOperations{

	
	@Override
	public void selectRecepcionistMain() {
		// TODO Auto-generated method stub
		ReceptionOperationsController controller = new ReceptionController();
		MainRecepcionistView mainview = new MainRecepcionistView(controller);
		mainview.setVisible();
	}

	@Override
	public void selectMedicMain() {
		// TODO Auto-generated method stub
		MedicOperationsController controller = new MedicController();
		MainMedicView mainview = new MainMedicView(controller);
		mainview.setVisible();
	}

	@Override
	public void selectAdminMain() {
		// TODO Auto-generated method stub
		AdminOperationsController controller = new AdminController();
		MainAdminView mainview = new MainAdminView(controller);
		mainview.setVisible();
		
	}

}
