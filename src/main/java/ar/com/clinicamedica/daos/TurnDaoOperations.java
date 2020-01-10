package ar.com.clinicamedica.daos;

import java.util.ArrayList;

import ar.com.clinicamedica.model.Turn;

public interface TurnDaoOperations {
	public void insertTurn(Turn t);
	public ArrayList<Turn> getTurn();

}
