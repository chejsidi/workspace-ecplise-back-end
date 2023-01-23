package dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

public final class PoolConexionesBasic {    
    private static final BasicDataSource dataSource = new BasicDataSource();

    static {        
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");                       
        dataSource.setUrl("jdbc:mysql://localhost/biblioteca");
        dataSource.setUsername("root");
        dataSource.setPassword("");
  
        //OPCIONAL (si no, se usar�n datos por defecto para el pool)
		// dataSource.setMinIdle(5);
		// dataSource.setMaxIdle(20);
		// dataSource.setMaxOpenPreparedStatements(180);
		// dataSource.setMaxTotal(10);     
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();         
    }    
}
