
package jdb.factory;

/**
 * @author Paula Acosta
 */
import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.sql.SQLException;
import javax.sql.DataSource;


public class ConnectionFactory {
    
    private static final String URL = "jdbc:mysql://localhost:3308/hotelalurabd";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    
    
    
    
    public DataSource dataSource;
    
   public ConnectionFactory() {
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setJdbcUrl(URL);
		comboPooledDataSource.setUser(USERNAME);
		comboPooledDataSource.setPassword(PASSWORD);

		this.dataSource = comboPooledDataSource;
                
                
	}
    
    
    	public java.sql.Connection recuperarConexion() {
		try {
			return this.dataSource.getConnection();
		} catch (SQLException e) {
			throw new ConnectionException("ERROR AL ESTABLECER CONEXION",e);
		}
	}
    
    
    
}
