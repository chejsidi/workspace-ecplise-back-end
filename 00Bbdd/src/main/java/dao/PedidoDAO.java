package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import beans.Item;
import beans.LineaPedido;
import beans.Pedido;
import conex.DBConex;

public class PedidoDAO {
	private DBConex gestorBDXml = new DBConex(); 
	
	public ArrayList<Item> todosItems() {
		ArrayList<Item> result = new ArrayList<Item>(); 
		try{                  		         
		 	Connection con = gestorBDXml.getDataSource().getConnection(); 
        	String sql = "SELECT * FROM items";
        	Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);            
            while(rs.next()) { 
            	Item i = new Item(rs.getInt("id"), rs.getString("nombre"), rs.getInt("precio"));
            	result.add(i);
            }
            rs.close();
            st.close();
            con.close();
         }
         catch (Exception e)  {
             System.err.println("Error en todosItems: " + e);
         }
		return result;
	}
	
	public Item buscaItemPorId(int iditem) {
		Item i = null;
		try{                  		         
		 	Connection con = gestorBDXml.getDataSource().getConnection(); 
        	String sql = "SELECT * FROM items WHERE id = " + iditem;
        	Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);            
            if(rs.next()) { 
            	i = new Item(rs.getInt("id"), rs.getString("nombre"), rs.getInt("precio"));
            }
            rs.close();
            st.close();
            con.close();
         }
         catch (Exception e)  {
             System.err.println("Error en buscaItemPorId: " + e);
         }
		return i;
	}
	
	public void guardaPedido(Pedido p) {
		 int n = 0; 
			try{                  		         
			 	Connection con = gestorBDXml.getDataSource().getConnection(); 
			 	String sql ="INSERT INTO pedidos (id,total,fecha,idcliente) VALUES( ? , ?,  ? ,?)";
				PreparedStatement ps = con.prepareStatement (sql);   // Se precompila la consulta

				ps.setInt(1, p.getId());
				ps.setDouble(2, p.getTotal());
				ps.setDate(3, new java.sql.Date(p.getFechaPedido().getTime()));
				ps.setInt(4, p.getCliente().getId()); 
				n = ps.executeUpdate();   		
				ps.close();
				con.close();
	         }
	         catch (Exception e)  {
	             System.err.println("Error en guardaPedido: " + e);
	         } 
	}
	public void guardaLineaPedido (LineaPedido l) {
		 int n = 0; 
			try{                  		         
			 	Connection con = gestorBDXml.getDataSource().getConnection(); 
			 	String sql ="INSERT INTO lineaspedido (id,cantidad,idpedido,iditem) VALUES( ? , ?,  ? ,?)";
				PreparedStatement ps = con.prepareStatement (sql);   // Se precompila la consulta

				ps.setInt(1, l.getId());
				ps.setInt(2, l.getCantidad());
				ps.setInt(3, l.getPedido().getId());
				ps.setInt(4, l.getItem().getId()); 
				n = ps.executeUpdate();   		
				ps.close();
				con.close();
	         }
	         catch (Exception e)  {
	             System.err.println("Error en guardaLineaPedido: " + e);
	         } 
	}
}
