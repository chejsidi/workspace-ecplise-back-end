package beans;

public class Cliente {
	private int id, cp, telefono;
	private String nombre, psswd, domicilio, email;  
	
	public Cliente(int id, String nombre, String psswd, String domicilio, int codigopostal, int telefono, String email) {
		this.id = id;
		this.cp = codigopostal;
		this.telefono = telefono;
		this.nombre = nombre;
		this.psswd = psswd;
		this.domicilio = domicilio;
		this.email = email;
	}
	
	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public int getCp() {
		return cp;
	}

	public int getTelefono() {
		return telefono;
	}

	public String getNombre() {
		return nombre;
	}

	public String getPsswd() {
		return psswd;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public String getEmail() {
		return email;
	}
	
	
}
