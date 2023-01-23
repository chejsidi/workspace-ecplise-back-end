package conex;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.sql.DataSource;

public class DBConex {
	private DataSource ds;
	
	public DBConex () { 
		try {
			InitialContext ctx = new InitialContext();
			Context env = (Context) ctx.lookup("java:comp/env");
			// nombre del recurso en el context.xml
			ds = (DataSource) env.lookup("jdbc/poolTiendaDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
	}
	public DataSource getDataSource() throws ServletException {
		DBConex conex = new DBConex();
		return conex.ds;
	}
}
