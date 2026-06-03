package apps;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import dao.ContatoDao;
import model.Contato;

public class TestaDaoConsultaInicial {

	public static void main(String[] args) {
		
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Digite a inicial: ");
			ContatoDao dao = new ContatoDao();
			List<Contato> contatos = dao.consultaInicial(sc.next().charAt(0));
			for (Contato contato : contatos) {
				System.out.println("\nNome: "+contato.getNome()+"\nEmail: "+contato.getEmail()+"\nEndereco: "+contato.getEndereco()+"\n");
			}
			sc.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
