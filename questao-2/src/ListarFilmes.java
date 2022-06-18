import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ListarFilmes {

	public static void main(String[] args) throws SQLException {

		boolean running = true;
		System.out.println("Bem-vindo");
		ConnectionFactory con = new ConnectionFactory();

		while (running) {
			try (Connection connection = con.recuperarConexao()) {
				System.out.println("Como deseja que seus filmes sejam exibidos?");
				System.out.println("Informe quantos filmes quer ver na sua pagina");
				int moviesPPage = new Scanner(System.in).nextInt();
				System.out.println("Qual pagina quer que seja exibida?");
				int page = new Scanner(System.in).nextInt();
				int moviesToShowMax = ((page * moviesPPage) - moviesPPage);
				try (PreparedStatement stm = connection.prepareStatement("SELECT * FROM filmes LIMIT ?, ?;",
						Statement.RETURN_GENERATED_KEYS)) {
					stm.setInt(1, moviesToShowMax);
					stm.setInt(2, moviesPPage);
					stm.execute();
					ResultSet rst = stm.getResultSet();

					while (rst.next()) {
						int id = rst.getInt("ID");
						System.out.println("id: " + id);
						String nome = rst.getString("NOME");
						System.out.println("nome: " + nome);
						String descricao = rst.getString("DESCRICAO");
						System.out.println("descricao: " + descricao);
						int ano = rst.getInt("ANO");
						System.out.println("ano: " + ano + "\n");
					}

				} catch (Exception e) {
					System.out.println("Houve um problema na resolução da expressão SQL");
					e.printStackTrace();

				}
			} catch (Exception e) {
				System.out.println("Houve um problema na conexão com o banco de dados");
				e.printStackTrace();
			}
			
			System.out.println("Quer tentar outra vez?");
			System.out.println("1 - Para executar novamente");
			System.out.println("2 - Para finalizar \n");
			int execAgain = new Scanner(System.in).nextInt();
			if (execAgain == 2) {
				System.out.println("Encerrando...");
				break;
			}
		}
	}
}