import java.util.Scanner;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Cadastro {

	static int idUpdate = 0;
	static int idDelete = 0;
	static int counter = 0;

	public static void main(String[] args) throws SQLException {
		boolean running = true;
		ConnectionFactory con = new ConnectionFactory();
		System.out.println("Bem vindo \n");

		while (running) {
			System.out.println("1 - Cadastrar produtos");
			System.out.println("2 - Atualizar primeiro produto");
			System.out.println("3 - Apagar segundo produto cadastrado");
			System.out.println("0 - Finalizar \n");
			System.out.println("O que deseja fazer?");
			String choiceMade = new Scanner(System.in).nextLine();
			switch (choiceMade) {
			case "1":
				try (Connection connection = con.recuperarConexao()) {
					connection.setAutoCommit(false);
					counter = 0;
					idDelete = 0;
					idUpdate = 0;

					try (PreparedStatement stm = connection.prepareStatement(
							"INSERT INTO PRODUTO (nome, descricao, quantidade, preco) VALUES (?, ?, ?, ?);",
							Statement.RETURN_GENERATED_KEYS)) {

						adicionarVariavel("Liquidificador", "45 polegadas", 2, 300, stm);
						adicionarVariavel("AirFryer", "Fritadeira sem oleo", 5, 500, stm);
						adicionarVariavel("Samsung A20", "Celular Samsung A20", 10, 1000, stm);

						connection.commit();
						System.out.println("Produtos inseridos com sucesso \n");
					}

					catch (Exception e) {
						System.out.println("Houve um problema no envio de dados");
						e.printStackTrace();
					}
				}
				break;
			case "2":
				if (idUpdate == 0) {
					System.out.println(
							"Nenhum produto foi adicionado para que seja atualizado, antes adicione atraves do comando 1");
					break;
				} else {
					try (Connection connection = con.recuperarConexao()) {
	
						try (PreparedStatement stm = connection.prepareStatement(
								"UPDATE PRODUTO SET nome = 'Furadeira', descricao = 'Furadeira Impacto Black', quantidade = 10, preco = 200  WHERE ID = ?;", Statement.RETURN_GENERATED_KEYS)) {
							stm.setInt(1, idUpdate);
							stm.execute();
							System.out.println("Produto atualizado com sucesso \n");
						}
	
						catch (Exception e) {
							System.out.println("Houve um problema na atualização de dados");
							e.printStackTrace();
						}
					}
				}
				break;
			case "3":
				if (idDelete == 0) {
					System.out.println(
							"Nenhum produto foi adicionado para que seja deletado, antes adicione atraves do comando 1");
					break;
				} else {
					try (Connection connection = con.recuperarConexao()) {

						try (PreparedStatement stm = connection.prepareStatement("DELETE FROM PRODUTO WHERE ID = ?;")) {
							stm.setInt(1, idDelete);
							stm.execute();

							Integer linhasModificadas = stm.getUpdateCount();
							if (linhasModificadas != 0) {
								System.out.println("Produto excluido com sucesso");
							} else {
								System.out.println(
										"Parece que voce ja excluiu este produto, cadastre mais com o comando 1");
							}
						} catch (Exception e) {
							System.out.println("Houve um problema no apagar de dados");
							e.printStackTrace();
						}
					}
				}
				break;
			case "0":
				System.out.println("Encerrando...");
				running = false;
				break;
			}
			System.out.println("");
		}

	}

	private static void adicionarVariavel(String nome, String descricao, int quantidade, double preco,
			PreparedStatement stm) throws SQLException {
		stm.setString(1, nome);
		stm.setString(2, descricao);
		stm.setInt(3, quantidade);
		stm.setDouble(4, preco);
		stm.execute();

		ResultSet rst = stm.getGeneratedKeys();

		while (rst.next()) {
			counter++;
			Integer id = rst.getInt(1);
			
			if (counter == 1) {
				idUpdate = id;
				System.out.println(idUpdate);
			}
			if (counter == 2) {
				idDelete = id;
			}

		}
	}
}
