package my.classes;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	
	private DataSource dataSource;
	
	public ConnectionFactory() throws ClassNotFoundException {
		 Class.forName("com.mysql.jdbc.Driver");
		ComboPooledDataSource pool = new ComboPooledDataSource();
		pool.setJdbcUrl("jdbc:mysql://localhost:3300/legacy_java_project?useTimezone=true&serverTimezone=UTC");
		pool.setUser("root");
		pool.setPassword("root");
		
		this.dataSource = pool;
	}
	
	public Connection retrieveConnection() throws SQLException {
		
		return this.dataSource.getConnection();
		
	}
	
}
