package apps;

import java.sql.SQLException;

import dao.ContatoDao;
import model.Contato;

public class TestaDaoInsere {

	
	//view
	public static void main(String[] args) {
		Contato contato = new Contato();
		contato.setNome("Filipe");
		contato.setEmail("filipe@filipe.com");
		contato.setEndereco("Av. Brasil, 1001");
		
		try {
			ContatoDao dao = new ContatoDao();
			dao.adiciona(contato);
			System.out.println("Gravação realizada com sucesso");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
