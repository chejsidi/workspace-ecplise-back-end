package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException; 

import beans.Alumno; 
import conex.ConexPoolBD;

public class AlumnosDao { 
	
	public static Alumno getAlumno(String dni) { 
		Alumno alumno = null;
		try {
			Connection con= ConexPoolBD.getDataSource().getConnection();
			String sql="SELECT * FROM alumno WHERE dni = ?";
			PreparedStatement st = con.prepareStatement(sql);
    		st.setString(1, dni); 
			ResultSet rs= st.executeQuery();
			
			
			while(rs.next()) {
				alumno = new Alumno(rs.getString("dni"), rs.getString("apellidos"),rs.getString("nombre"),rs.getString("telefono"),rs.getString("email"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return alumno;
	}
}
