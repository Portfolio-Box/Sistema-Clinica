package ar.com.clinicamedica.model;

public class Turn {
	
	private int id;
	private int dni;
	private String name;
	private String secondName;
	private String fecha;
	private String hora;
	private int consultorio;
	private String medico;
	

	public Turn(int id,int dni,String name,String secondName,String fecha,String hora,int consultorio,String medico) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.dni=dni;
		this.name=name;
		this.secondName=secondName;
		this.fecha=fecha;
		this.hora=hora;
		this.consultorio=consultorio;
		this.medico=medico;
	}

	public Turn(int dnit, String name2, String secondName2, String fecha2, String hora2, int cont, String medico2) {
		// TODO Auto-generated constructor stub
		this.dni=dnit;
		this.name=name2;
		this.secondName=secondName2;
		this.fecha=fecha2;
		this.hora=hora2;
		this.consultorio=cont;
		this.medico=medico2;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public int getConsultorio() {
		return consultorio;
	}

	public void setConsultorio(int consultorio) {
		this.consultorio = consultorio;
	}

	public String getMedico() {
		return medico;
	}

	public void setMedico(String medico) {
		this.medico = medico;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	


}
