package beans;

public class Item {
	private int id, precio;
	private String nombre;
	
	public Item(int id, String nombre, int precio) {
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
	}
	public Item() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
