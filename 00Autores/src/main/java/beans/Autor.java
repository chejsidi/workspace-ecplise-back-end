/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.Date;

/**
 *
 * @author Amaia
 */
public class Autor { 
    private String nombre;
    private Date fechanac;
    private String nacionalidad;
    private int id;
    public Autor(String nombre, Date fechanac, String nacionalidad) { 
        this.nombre = nombre;
        this.fechanac = fechanac;
        this.nacionalidad = nacionalidad;
    }
    public Autor(int id, String nombre, Date fechanac, String nacionalidad) { 
    	this.id = id;
        this.nombre = nombre;
        this.fechanac = fechanac;
        this.nacionalidad = nacionalidad;
    }
    public Autor() {
    } 

    public String getNombre() {
        return nombre;
    }

    public Date getFechanac() {
        return fechanac;
    }

    public String getNacionalidad() {
        return nacionalidad;
    } 

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechanac(Date fechanac) {
        this.fechanac = fechanac;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

	public void setIdAutor(int id) {
		this.setId(id);
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
    
}

