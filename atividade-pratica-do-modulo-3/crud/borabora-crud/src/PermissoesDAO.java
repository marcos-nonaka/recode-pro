import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PermissoesDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Permissoes permissao) {

		// Os ? são os parâmetros que nós vamos adicionar na base de dados

		String sql = "INSERT INTO permissoes(tipo)" + " VALUES(?)";

		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adiciona o valor do primeiro parâmetro da sql
			pstm.setString(1, permissao.getTipo());

			// Executa a sql para inserção dos dados
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			// Fecha as conexões
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public List<Permissoes> getPermissoes() {

		String sql = "SELECT * FROM permissoes";

		List<Permissoes> permissoes = new ArrayList<Permissoes>();

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			// Enquanto existir dados no banco de dados, faça
			while (rset.next()) {

				Permissoes permissao = new Permissoes();

				// Recupera o id no banco e atribui ele ao objeto
				permissao.setId_permissao(rset.getInt("id_permissao"));

				// Recupera o tipo no banco e atribui ele ao objeto
				permissao.setTipo(rset.getString("tipo"));

				// Adiciona a permissão recuperada a lista de permissões
				permissoes.add(permissao);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (permissoes.size() == 0) {
			System.out.println("Nao ha permissoes cadastradas no banco de dados!");
		}
		return permissoes;
	}

	public void update(Permissoes permissao) {

		boolean consulta = false;

		for (Permissoes p : getPermissoes()) {
			if (p.getId_permissao() == permissao.getId_permissao()) {
				consulta = true;
			}
		}

		if (consulta) {

			String sql = "UPDATE permissoes SET tipo = ?" + " WHERE id_permissao = ?";

			try {
				// Cria uma conexão com o banco
				conn = Conexao.createConnectionToMySQL();

				// Cria um PreparedStatment, classe usada para executar a query
				pstm = conn.prepareStatement(sql);

				// Adiciona o valor do primeiro parâmetro da sql
				pstm.setString(1, permissao.getTipo());

				// Adiciona o valor do segundo parâmetro da sql
				pstm.setInt(2, permissao.getId_permissao());

				// Executa a sql para inserção dos dados
				pstm.execute();

				System.out.println("Permissao atualizada com sucesso!");

			} catch (Exception e) {
				e.printStackTrace();
			} finally {

				// Fecha as conexões
				try {
					if (pstm != null) {
						pstm.close();
					}
					if (conn != null) {
						conn.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} else {
			System.out.println("ID nao encontrado no banco de dados!");
		}
	}

	public void removeById(int id_permissao) {

		boolean consulta = false;

		for (Permissoes p : getPermissoes()) {
			if (p.getId_permissao() == id_permissao) {
				consulta = true;
			}
		}

		if (consulta) {

			String sql = "DELETE FROM permissoes WHERE id_permissao = ?";

			try {
				conn = Conexao.createConnectionToMySQL(); // cria a conexao

				pstm = conn.prepareStatement(sql); // passa comando sql para o objeto pstm

				pstm.setInt(1, id_permissao); // seta o id no comando sql

				pstm.execute(); // executa o comando sql que está no objeto pstm

				System.out.println("Permissao excluida com sucesso!");

			} catch (Exception e) {
				e.printStackTrace();
			} finally {

				try {
					if (pstm != null) {
						pstm.close();
					}
					if (conn != null) {
						conn.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} else {
			System.out.println("ID nao encontrado no banco de dados!");
		}
	}
}