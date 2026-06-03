package javadb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcInsere {
	public static void main(String[] args) {
		try {
			Connection con = ConnectionFactory.getConnection();
			String query = "insert into contatos (nome, email, endereco) values (?,?,?)";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, "Clayton");// a coluna 0 é o id e não vou usar no insert
			stmt.setString(2, "Clayton@clayton.com");
			stmt.setString(3, "Av. Brasil, 1000");
			stmt.execute();
			stmt.close();
			System.out.println("Inserido com sucesso.");
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
