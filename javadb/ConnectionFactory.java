package javadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost/test","root",""); 
		// ta na porta 3350 pq o xampp tinha dado erro 
		//e o Clayton tentou arrumar mudando a porta
		//e não sei mudar de volta, colocar :3350 depois de localhost quando voltar pra sala normal
	}
}
