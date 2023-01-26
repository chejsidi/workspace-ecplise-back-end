package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;


import conex.ConexPoolBD;

public class ParticipaDao { 
	
	public static void participar(String dni, int idAct, String fecha) { 
		int n = 0;  
		try{                  		         
		 	Connection con = ConexPoolBD.getDataSource().getConnection();
		 	String sql ="INSERT INTO participa VALUES( ? , ?, ?)";
			PreparedStatement ps = con.prepareStatement (sql);   // Se precompila la consulta
			Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(fecha); 
			ps.setInt(1, idAct);
			ps.setString(2, dni);
			ps.setDate(3, (java.sql.Date) date1); 
			n = ps.executeUpdate();   		
			ps.close();
			con.close();
         }
         catch (Exception e)  {
             System.err.println("Error en participa: " + e);
         } 
	}
}
