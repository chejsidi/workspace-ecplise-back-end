package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Actividad;
import beans.Impartidor;
import conex.ConexPoolBD;

public class ActividadesDao { 
	
	public static ArrayList<Actividad> getActividades(String dni) { 
		ArrayList<Actividad> actividades = new ArrayList<Actividad>(); 
		try {
			Connection con= ConexPoolBD.getDataSource().getConnection();
			String sql="SELECT actividad.*,impartidor.id AS idImp, impartidor.nombre AS nomImp, impartidor.apellido AS apeImp FROM actividad,participa,impartidor WHERE actividad.id = participa.actividad_id AND actividad.impartidor_id = impartidor.id AND participa.alumno_dni = ?";
			PreparedStatement st = con.prepareStatement(sql);
    		st.setString(1, dni); 
			ResultSet rs= st.executeQuery();
			
			
			while(rs.next()) { 
				Impartidor imp = new Impartidor(rs.getInt("idImp"), rs.getString("nomImp"), rs.getString("apeImp"));
				Actividad act = new Actividad(rs.getInt("id"), imp, rs.getString("nombre"),rs.getDouble("coste_mensual"), rs.getInt("capacidad")); 
				actividades.add(act);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return actividades;
	}
	public static ArrayList<Actividad> getNoParticipaActividades(String dni) { 
		ArrayList<Actividad> actividades = new ArrayList<Actividad>(); 
		try {
			Connection con= ConexPoolBD.getDataSource().getConnection();
			String sql="SELECT DISTINCT actividad.*,impartidor.id AS idImp, impartidor.nombre AS nomImp, impartidor.apellido AS apeImp FROM actividad,participa,impartidor WHERE actividad.id = participa.actividad_id AND actividad.impartidor_id = impartidor.id AND actividad.capacidad > 0 AND participa.alumno_dni != ?";
			PreparedStatement st = con.prepareStatement(sql);
    		st.setString(1, dni); 
			ResultSet rs= st.executeQuery();
			
			
			while(rs.next()) { 
				Impartidor imp = new Impartidor(rs.getInt("idImp"), rs.getString("nomImp"), rs.getString("apeImp"));
				Actividad act = new Actividad(rs.getInt("id"), imp, rs.getString("nombre"),rs.getDouble("coste_mensual"), rs.getInt("capacidad")); 
				actividades.add(act);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return actividades;
	}
	public static ArrayList<Actividad> getActividadesImpartidas(Impartidor imp) {
		ArrayList<Actividad> actividades = new ArrayList<Actividad>(); 
		try {
			Connection con= ConexPoolBD.getDataSource().getConnection();
			String sql="SELECT * FROM actividad WHERE impartidor_id = ?";
			PreparedStatement st = con.prepareStatement(sql);
    		st.setInt(1, imp.getId()); 
			ResultSet rs= st.executeQuery();
			
			
			while(rs.next()) {  
				Actividad act = new Actividad(rs.getInt("id"), imp, rs.getString("nombre"),rs.getDouble("coste_mensual"), rs.getInt("capacidad")); 
				actividades.add(act);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return actividades;
	} 
}
