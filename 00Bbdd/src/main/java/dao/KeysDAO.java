package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


import conex.DBConex;

public class KeysDAO {
	private DBConex gestorBDXml = new DBConex(); 
	
	public int siguienteId(String table) {
		int id = 0;
		 try{                  		         
			 	Connection con = gestorBDXml.getDataSource().getConnection(); 
	        	String sql = "SELECT MAX(id) FROM "+ table;
	        	Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery(sql);            
	            if(rs.next()) {
	            	id = rs.getInt("id") + 1;
	            }else {
	            	id = 1;
	            }
	            rs.close();
	            st.close();
	         }
	         catch (Exception e)  {
	             System.err.println("Error en KeysDAO: " + e);
	         }
		 return id;
	}
}
