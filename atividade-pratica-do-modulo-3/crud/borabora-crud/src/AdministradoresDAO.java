import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AdministradoresDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Administradores administrador) {

		// Os ? são os parâmetros que nós vamos adicionar na base de dados

		String sql = "INSERT INTO administradores(nome,email,senha,id_permissao)" + " VALUES(?,?,?,?)";

		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adiciona o valor do primeiro parâmetro da sql
			pstm.setString(1, administrador.getNome());

			// Adiciona o valor do segundo parâmetro da sql
			pstm.setString(2, administrador.getEmail());

			// Adiciona o valor do terceiro parâmetro da sql
			pstm.setString(3, administrador.getSenha());

			// Adiciona o valor do quarto parâmetro da sql
			pstm.setInt(4, administrador.getId_permissao());
			
			// Executa a sql para inserção dos dados
			pstm.execute();

			System.out.println("Administrador adicionado com sucesso!");
		} catch (Exception e) {
			System.out.println("ID de permissao nao encontrado no banco de dados ou caractere invalido!");
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

	public List<Administradores> getAdministradores() {

		String sql = "SELECT * FROM administradores";

		List<Administradores> administradores = new ArrayList<Administradores>();

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			// Enquanto existir dados no banco de dados, faça
			while (rset.next()) {

				Administradores administrador = new Administradores();

				// Recupera o id no banco e atribui ele ao objeto
				administrador.setId_admin(rset.getInt("id_admin"));

				// Recupera o id da permissão no banco e atribui ele ao objeto
				administrador.setId_permissao(rset.getInt("id_permissao"));

				// Recupera o nome no banco e atribui ele ao objeto
				administrador.setNome(rset.getString("nome"));

				// Recupera o e-mail no banco e atribui ele ao objeto
				administrador.setEmail(rset.getString("email"));

				// Recupera a senha no banco e atribui ela ao objeto
				administrador.setSenha(rset.getString("senha"));

				// Adiciona o administrador recuperado a lista de administradores
				administradores.add(administrador);
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
		if (administradores.size() == 0) {
			System.out.println("Nao ha administradores cadastrados no banco de dados!");
		}
		return administradores;
	}

	public void update(Administradores administrador) {

		boolean consulta = false;

		for (Administradores a : getAdministradores()) {
			if (a.getId_admin() == administrador.getId_admin()) {
				consulta = true;
			}
		}

		if (consulta) {

			String sql = "UPDATE administradores SET nome = ?, email = ?, senha = ?" + " WHERE id_admin = ?";

			try {
				// Cria uma conexão com o banco
				conn = Conexao.createConnectionToMySQL();

				// Cria um PreparedStatment, classe usada para executar a query
				pstm = conn.prepareStatement(sql);

				// Adiciona o valor do primeiro parâmetro da sql
				pstm.setString(1, administrador.getNome());

				// Adiciona o valor do segundo parâmetro da sql
				pstm.setString(2, administrador.getEmail());

				// Adiciona o valor do terceiro parâmetro da sql
				pstm.setString(3, administrador.getSenha());

				// Adiciona o valor do quarto parâmetro da sql
				pstm.setInt(4, administrador.getId_admin());

				// Executa a sql para inserção dos dados
				pstm.execute();

				System.out.println("Administrador atualizado com sucesso!");

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

	public void removeById(int id_admin) {

		boolean consulta = false;

		for (Administradores a : getAdministradores()) {
			if (a.getId_admin() == id_admin) {
				consulta = true;
			}
		}

		if (consulta) {

			String sql = "DELETE FROM administradores WHERE id_admin = ?";

			try {
				conn = Conexao.createConnectionToMySQL(); // cria a conexao

				pstm = conn.prepareStatement(sql); // passa comando sql para o objeto pstm

				pstm.setInt(1, id_admin); // seta o id no comando sql

				pstm.execute(); // executa o comando sql que está no objeto pstm

				System.out.println("Administrador excluido com sucesso!");

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