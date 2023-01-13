/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

public class Devolucion {
    private int idPrestamo;
    private String fecha;
    private int idLibro;  
    private String tituloLibro;
    public Devolucion(int idPrestamo, String fecha, int idLibro, String tituloLibro) {
    	this.idPrestamo = idPrestamo;
        this.fecha = fecha;
        this.idLibro = idLibro; 
        this.tituloLibro = tituloLibro;
    }
    
    public int getIdPrestamo() {
		return idPrestamo;
	}

	public void setIdPrestamo(int idPrestamo) {
		this.idPrestamo = idPrestamo;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}
	
	public String getTituloLibro() {
		return tituloLibro;
	}

	public void setTituloLibro(String tituloLibro) {
		this.tituloLibro = tituloLibro;
	}

	public Devolucion() {
    }

   
}
