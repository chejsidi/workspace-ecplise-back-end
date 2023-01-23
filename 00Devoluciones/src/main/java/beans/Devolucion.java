/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.Date;

public class Devolucion {
    private int idPrestamo;
    private Date fecha;
    private int idLibro;  
    private String tituloLibro;
    private int dias;
    public Devolucion(int idPrestamo, Date fecha, int idLibro, String titulo) {
    	this.idPrestamo = idPrestamo;
        this.fecha = fecha;
        this.idLibro = idLibro;  
        tituloLibro = titulo;
        dias = modificarFecha(fecha);
    }
    
    public int getDias() {
		return dias;
	}

	public void setDias(int dias) {
		this.dias = dias;
	}

	public int getIdPrestamo() {
		return idPrestamo;
	}

	public void setIdPrestamo(int idPrestamo) {
		this.idPrestamo = idPrestamo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
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

	private int modificarFecha(Date fecha) {
		// La fecha actual
		Date fechaactual = new Date(System.currentTimeMillis());
		int milisecondsByDay = 86400000;
		int dias = (int) ((fechaactual.getTime()-fecha.getTime()) / milisecondsByDay);
		return dias;
	}
}
