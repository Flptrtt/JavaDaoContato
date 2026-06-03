package apps;

import java.sql.SQLException;
import java.util.Scanner;

import dao.ContatoDao;
import model.Contato;

public class TestaDaoBuscarId {

	public static void main(String[] args) {
		
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Digite o id: ");
			ContatoDao dao = new ContatoDao();
			Contato contato = dao.buscarId(sc.nextLong());
			System.out.println("ID: "+contato.getId()+"\nNome: "+contato.getNome()+"\nEmail: "+contato.getEmail()+"\nEndereco: "+contato.getEndereco()+"\n");
			sc.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
