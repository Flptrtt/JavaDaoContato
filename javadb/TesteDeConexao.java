package javadb;

import java.sql.Connection;
import java.sql.SQLException;

public class TesteDeConexao {

	public static void main(String[] args) {
		try {
			Connection con = ConnectionFactory.getConnection();
			System.out.println("Conectou");
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
