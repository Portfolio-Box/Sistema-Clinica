package ar.com.clinicamedica.controller;

import ar.com.clinicamedica.moduleselector.Selector;
import ar.com.clinicamedica.moduleselector.SelectorOperations;
import ar.com.clinicamedica.swingview.LoginViewOperations;
import ar.com.clinicamedica.validations.LoginValidation;

public class LoginController implements LoginOperationsController {
	
	private LoginViewOperations login;

	public LoginController(LoginViewOperations login) {
		this.login = login;
		this.login.setController(this);
	}

	public void startView() {
		// TODO Auto-generated method stub
		login.startView();
	}

	@Override
	public void checkCredentials(String user, String pass) {
        SelectorOperations selector=new Selector();
        LoginValidation validation=new LoginValidation();
        
        if(validation.adminVal(user, pass)){
        	selector.selectAdminMain();
        	login.close();
        }
        else if(validation.recepVal(user, pass)) {
        	selector.selectRecepcionistMain();
        	login.close();
        }
        else if(validation.medVal(user, pass)) {
        	selector.selectMedicMain();
        	login.close();
        }
        else {
        	login.showError("login incorrecto");
        }
        	
	}

	

}
