package my.classes;
import java.sql.Connection;
import java.sql.SQLException;

public class TestConnection {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		ConnectionFactory pool = new ConnectionFactory();
		Connection connection = pool.retrieveConnection();
		
		System.out.println("working");
		
		connection.close();
		
	}
}
