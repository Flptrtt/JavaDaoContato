package apps;

import java.sql.SQLException;
import java.util.List;

import dao.ContatoDao;
import model.Contato;

public class TestaDaoGetLista {

	public static void main(String[] args) {
		
		try {
			ContatoDao dao = new ContatoDao();
			List<Contato> contatos = dao.getLista();
			for (Contato contato : contatos) {
				System.out.println("\nNome: "+contato.getNome()+"\nEmail: "+contato.getEmail()+"\nEndereco: "+contato.getEndereco()+"\n");
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
