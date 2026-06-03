package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javadb.ConnectionFactory;
import model.Contato;

public class ContatoDao {
	private Connection con;
	
	public ContatoDao() throws SQLException {
		this.con = ConnectionFactory.getConnection();
		
	}
	
	
	public void adiciona(Contato contato) throws SQLException {
		String query = "insert into contatos (nome, email, endereco) values (?,?,?)";
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setString(1, contato.getNome());
		stmt.setString(2, contato.getEmail());
		stmt.setString(3, contato.getEndereco());
		stmt.execute();
		stmt.close();
		con.close();
	}
	
	public List<Contato> getLista() throws SQLException {
		String query = "select*from contatos;";
		PreparedStatement stmt = con.prepareStatement(query);
		ResultSet rset = stmt.executeQuery(); 
		List<Contato> contatos = new ArrayList<Contato>();
		while (rset.next()) {
			Contato contato = new Contato();
			contato.setNome(rset.getString("nome"));
			contato.setEmail(rset.getString("email"));
			contato.setEndereco(rset.getString("endereco"));
			contatos.add(contato);
		}
		rset.close();
		stmt.close();
		con.close();
		
		return contatos;
		
	}
	public List<Contato> consultaInicial(char inicial) throws SQLException{
		String query = "select*from contatos where nome like '"+inicial+"%'";
		PreparedStatement stmt = con.prepareStatement(query);
		ResultSet rset = stmt.executeQuery(); 
		List<Contato> resultado = new ArrayList<Contato>();
		while (rset.next()) {
			Contato contato = new Contato();
			contato.setNome(rset.getString("nome"));
			contato.setEmail(rset.getString("email"));
			contato.setEndereco(rset.getString("endereco"));
			resultado.add(contato);
		}
		rset.close();
		stmt.close();
		con.close();
		return resultado;
		
	}
	
	public Contato buscarId(Long idBusca) throws SQLException {
		String query = "select * from contatos where id = ?";
		Contato contato = new Contato();
		PreparedStatement stmt = con.prepareStatement(query);
		
		stmt.setLong(1,idBusca);
		ResultSet rset = stmt.executeQuery();
		if (rset.next()) {
	        contato.setId(rset.getLong("id"));
	        contato.setNome(rset.getString("nome"));
	        contato.setEmail(rset.getString("email"));
	        contato.setEndereco(rset.getString("endereco"));
	        
			rset.close();
			stmt.close();
			con.close();
			return contato ;
	    }
		rset.close();
		stmt.close();
		con.close();
		return null ;
	}
	
	public void atualizar(Contato contato) throws SQLException {
		String query = "update contatos set nome=?, email=?, endereco=? where id=?";
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setString(1, contato.getNome());
		stmt.setString(2, contato.getEmail());
		stmt.setString(3, contato.getEndereco());
		stmt.setLong(4, contato.getId());
		stmt.execute();
		stmt.close();
		con.close();	
	}
	
	
	public void excluir(Contato contato) throws SQLException {
		String query = "delete from contatos where id=?";
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setLong(1, contato.getId());
		stmt.execute();
		stmt.close();
		con.close();
	}
	
	
}
