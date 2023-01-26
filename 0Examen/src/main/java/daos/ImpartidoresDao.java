package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException; 

import beans.Impartidor;
import conex.ConexPoolBD;

public class ImpartidoresDao { 
	
	public static Impartidor getImpartidor(int idImpartidor) { 
		Impartidor impartidor = null; 
		try {
			Connection con= ConexPoolBD.getDataSource().getConnection();
			String sql="SELECT * FROM impartidor WHERE id = ?";
			PreparedStatement st = con.prepareStatement(sql);
    		st.setInt(1, idImpartidor); 
			ResultSet rs= st.executeQuery();
			
			
			while(rs.next()) {
				impartidor = new Impartidor(rs.getInt("id"), rs.getString("apellido"),rs.getString("nombre"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return impartidor;
	}
}
