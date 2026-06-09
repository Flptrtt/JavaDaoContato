package apps;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import dao.ContatoDao;
import model.Contato;

public class MenuProgram {

	public static void main(String[] args) {

		try {

			
			Contato contato = new Contato();
			Scanner sc = new Scanner(System.in);
			int opcao = 0;

			do {
				ContatoDao dao = new ContatoDao();// tem que instanciar dentro do loop por causa da conexão que é fechada nos metodos 
				System.out.println("\nEscolha uma opção: \n1-Inserir contato\n2-Listar contatos\n3-Listar por inicial"
						+ "\n4-Buscar por id\n5-Atualizar contato\n6-Remover contato\n7-Sair");

				opcao = sc.nextInt();
				sc.nextLine(); 

				switch (opcao) {

				case 1:
					System.out.print("Insira seu nome: ");
					contato.setNome(sc.nextLine());

					System.out.print("Insira seu email: ");
					contato.setEmail(sc.nextLine());

					System.out.print("Insira seu endereço: ");
					contato.setEndereco(sc.nextLine());

					try {
						dao.adiciona(contato);
						System.out.println("gravação feita com sucesso");
					} catch (SQLException e) {
						System.out.println("Falha na gravação do registro.");
					}
					break;

				case 2:
					try {
						List<Contato> contatos = dao.getLista();

						for (Contato cont : contatos) {
							System.out.println("Nome: " + cont.getNome() + " | Email: " + cont.getEmail()
									+ " | Endereco: " + cont.getEndereco() + " | ");
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
					break;

				case 3:

					try {
						System.out.println("Digite a inicial: ");

						List<Contato> contatos = dao.consultaInicial(sc.next().charAt(0));

						for (Contato cont : contatos) {
							System.out.println("Nome: " + cont.getNome() + " | Email: " + cont.getEmail()
									+ " | Endereco: " + cont.getEndereco() + " | ");
						}

						sc.nextLine(); 

					} catch (SQLException e) {
						e.printStackTrace();
					}
					break;

				
				case 4:
				    try {
				        System.out.println("Digite o id: ");

				        contato = dao.buscarId(sc.nextLong());
				        sc.nextLine();

				        if (contato == null) {
				            System.out.println("Contato não encontrado.");
				        } else {
				            System.out.println("ID: " + contato.getId()+ " | Nome: " + contato.getNome()+ " | Email: " + contato.getEmail()+ " | Endereco: " + contato.getEndereco()+ " | ");
				        }

				    } catch (SQLException e) {
				        e.printStackTrace();
				    }
				    break;

				case 5:
					System.out.println("Digite o id: ");
					contato.setId(sc.nextLong());
					
					
					contato = dao.buscarId(contato.getId());
					sc.nextLine(); 
					if (contato == null) {
			            System.out.println("Contato não encontrado.");
			        } else {
			            System.out.println("ID: " + contato.getId()+ " | Nome: " + contato.getNome()+ " | Email: " + contato.getEmail()+ " | Endereco: " + contato.getEndereco()+ " | ");
			        }
					
					ContatoDao daoatualiza = new ContatoDao();

					System.out.println("Entre com novo nome: ");
					contato.setNome(sc.nextLine());

					System.out.println("Entre com novo email: ");
					contato.setEmail(sc.nextLine());

					System.out.println("Entre com novo endereco: ");
					contato.setEndereco(sc.nextLine());

					daoatualiza.atualizar(contato);
					System.out.println("Informações atualizadas com sucesso");
					break;

				case 6:
					System.out.println("Digite o id: ");
					contato.setId(sc.nextLong());
					sc.nextLine(); 

					int linhasResultado = dao.excluir(contato);
					
					if (linhasResultado > 0) {
				        System.out.println("Excluído com sucesso.");
				    } else {
				        System.out.println("Contato não encontrado.");
				    }


					break;

				case 7:
					System.out.println("Encerrando programa...");
					break;

				default:
					System.out.println("Não existe essa opção, tem que ser de 1 a 7");
					break;
				}

			} while (opcao != 7);

			sc.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}