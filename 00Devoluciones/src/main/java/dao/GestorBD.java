/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList; 
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

import com.mysql.cj.xdevapi.PreparableStatement;

import beans.Devolucion; 


/**
 *
 * @author Amaia
 */
public class GestorBD { 
    public ArrayList<Devolucion> prestamos(){
        ArrayList<Devolucion> devoluciones = new ArrayList<Devolucion>();
        String sql = "SELECT prestamo.id AS prestamoId, prestamo.fecha AS prestamoFecha, prestamo.idlibro, libro.titulo FROM prestamo, libro WHERE prestamo.idlibro = libro.id";
        try {
            Connection con = PoolConexionesBasic.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
            	Devolucion devolucion = new Devolucion(rs.getInt("prestamoId"),rs.getDate("prestamoFecha"),rs.getInt("idLibro"), rs.getString("titulo"));
            	devoluciones.add(devolucion);
            }
            rs.close();
            st.close();
            con.close();
        } catch (SQLException ex) {
            System.err.println("Error en metodo devoluciones: " + ex);
        }
        return devoluciones;
    }
    
    
    
    public void grabarDevolucion(int dev){ 
        String sql = "DELETE FROM prestamo WHERE id = " + dev;
        try (Connection con = PoolConexionesBasic.getConnection();){
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
        
    }
   
}
