package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import beans.Cliente;
import conex.DBConex;

public class ClienteDAO {
	private DBConex gestorBDXml = new DBConex(); 
	
	public Cliente buscaCliente(String nombre, String password) { 
		Cliente c = null;
		 try{                  		         
			 	Connection con = gestorBDXml.getDataSource().getConnection(); 
	        	String sql = "SELECT * FROM clientes WHERE nombre = '" + nombre + "' AND password = '"+ password +"'";
	        	Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery(sql);            
	            if(rs.next()) { 
	            	c = new Cliente(rs.getInt("id"), rs.getString("nombre"), rs.getString("password"), rs.getString("domicilio"), rs.getInt("codigopostal"), rs.getInt("telefono"), rs.getString("email"));
	            }
	            rs.close();
	            st.close();
	            con.close();
	         }
	         catch (Exception e)  {
	             System.err.println("Error en buscaCliente(Nombre, password): " + e);
	         }
		 return c;
	}
	public int contClientes() { 
		int c = 0;
		 try{                  		         
			 	Connection con = gestorBDXml.getDataSource().getConnection(); 
	        	String sql = "SELECT COUNT(*) FROM clientes";
	        	Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery(sql);            
	            if(rs.next()) { 
	            	c = rs.getInt("COUNT(*)");
	            }
	            rs.close();
	            st.close();
	            con.close();
	         }
	         catch (Exception e)  {
	             System.err.println("Error en contClientes(): " + e);
	         }
		 return c;
	}
	public boolean buscaCliente(String nombre) {
		boolean todobn = false;
		try{                  		         
		 	Connection con = gestorBDXml.getDataSource().getConnection(); 
        	String sql = "SELECT * FROM clientes WHERE nombre = " + nombre;
        	Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);            
            if(rs.next()) { 
            	todobn = true;
            }
            rs.close();
            st.close();
            con.close();
         }
         catch (Exception e)  {
             System.err.println("Error en buscaCliente(Nombre): " + e);
         }
		return todobn;
	}
	
	public boolean guardarCliente(Cliente c) {
		int n = 0; 
		try{                  		         
		 	Connection con = gestorBDXml.getDataSource().getConnection(); 
		 	String sql ="INSERT INTO clientes (id,nombre,password,domicilio,codigopostal,telefono,email) VALUES( ? , ?,  ? ,? , ?,  ?,  ?)";
			PreparedStatement ps = con.prepareStatement (sql);   // Se precompila la consulta

			ps.setInt(1, c.getId());
			ps.setString(2, c.getNombre());
			ps.setString(3, c.getPsswd());
			ps.setString(4, c.getDomicilio());
			ps.setInt(5, c.getCp());
			ps.setInt(6, c.getTelefono());
			ps.setString(7, c.getEmail());
			n = ps.executeUpdate();   		
			ps.close();
			con.close();
         }
         catch (Exception e)  {
             System.err.println("Error en guardarCliente: " + e);
         }
		if (n > 0) {
			return true;
		}else {
			return false;
		}
	}
	public boolean actualizarCliente(Cliente c) {
		String sql = "UPDATE clientes SET nombre = " + c.getNombre() +", password = "+ c.getPsswd() +", domicilio = "+ c.getDomicilio() +", codigopostal = "+ c.getCp() +", telefono = "+ c.getTelefono() +", email = "+ c.getEmail() +" WHERE id = " + c.getId();
		int result = 0;
		try{                  		         
		 	Connection con = gestorBDXml.getDataSource().getConnection();
		 	Statement pstm = con.createStatement();
			result = pstm.executeUpdate(sql);
         }
         catch (Exception e)  {
             System.err.println("Error en actualizarCliente: " + e);
         }
		if (result > 0) {
			return true;
		}else 
			return false;
	}
	
}
