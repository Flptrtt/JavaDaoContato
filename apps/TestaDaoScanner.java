package apps;

import java.sql.SQLException;
import java.util.Scanner;

import dao.ContatoDao;
import model.Contato;

public class TestaDaoScanner {

	public static void main(String[] args) {
		
		
		Contato contato = new Contato();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Insira seu nome: ");
		contato.setNome(sc.nextLine());
		System.out.println("Insira seu email: ");
		contato.setEmail(sc.nextLine());
		System.out.println("Insira seu endereço: ");
		contato.setEndereco(sc.nextLine());
		sc.close();
		
		try {
			ContatoDao dao = new ContatoDao();
			dao.adiciona(contato);
			System.out.println("gravação feita com sucesso");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
