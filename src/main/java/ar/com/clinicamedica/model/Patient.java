package ar.com.clinicamedica.model;

public class Patient {
	private String name;
	private String secondName;
	private String direction;
	private String place;
	private int dni;

	public Patient(int dni,String name,String secondName,String direction,String place) {
		// TODO Auto-generated constructor stub
		this.name=name;
		this.secondName=secondName;
		this.dni=dni;
		this.place=place;
		this.direction=direction;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

}
