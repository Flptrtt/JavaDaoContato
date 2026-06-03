package apps;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import dao.ContatoDao;
import model.Contato;

public class TestaDaoJOptionPane {

	public static void main(String[] args) {
		
		Contato contato = new Contato();
		contato.setNome(JOptionPane.showInputDialog("Insira seu nome:"));
		contato.setEmail(JOptionPane.showInputDialog("Insira seu Email:"));
		contato.setEndereco(JOptionPane.showInputDialog("Insira seu Endereço:"));
		
		
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
