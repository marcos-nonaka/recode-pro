import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PromocoesDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Promocoes promocao) {

		// Os ? são os parâmetros que nós vamos adicionar na base de dados

		String sql = "INSERT INTO promocoes(destino,data_ida,horario_ida,data_volta,horario_volta,cia_aerea,hotel,observacoes,valor,valor_promocional,id_admin)" + " VALUES(?,?,?,?,?,?,?,?,?,?,?)";

		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adiciona o valor do primeiro parâmetro da sql
			pstm.setString(1, promocao.getDestino());

			// Adiciona o valor do segundo parâmetro da sql
			pstm.setString(2, promocao.getData_ida());

			// Adiciona o valor do terceiro parâmetro da sql
			pstm.setString(3, promocao.getHorario_ida());

			// Adiciona o valor do quarto parâmetro da sql
			pstm.setString(4, promocao.getData_volta());

			// Adiciona o valor do quinto parâmetro da sql
			pstm.setString(5, promocao.getHorario_volta());

			// Adiciona o valor do sexto parâmetro da sql
			pstm.setString(6, promocao.getCia_aerea());

			// Adiciona o valor do sétimo parâmetro da sql
			pstm.setString(7, promocao.getHotel());

			// Adiciona o valor do oitavo parâmetro da sql
			pstm.setString(8, promocao.getObservacoes());

			// Adiciona o valor do nôno parâmetro da sql
			pstm.setDouble(9, promocao.getValor());

			// Adiciona o valor do décimo parâmetro da sql
			pstm.setDouble(10, promocao.getValor_promocional());

			// Adiciona o valor do décimo primeiro parâmetro da sql
			pstm.setInt(11, promocao.getId_admin());
			
			// Executa a sql para inserção dos dados
			pstm.execute();

			System.out.println("Pacote promocional adicionado com sucesso!");
		} catch (Exception e) {
			System.out.println("ID DE ADMINISTRADOR nao encontrado no banco de dados ou caractere invalido!");
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

	public List<Promocoes> getPromocoes() {

		String sql = "SELECT * FROM promocoes";

		List<Promocoes> promocoes = new ArrayList<Promocoes>();

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			// Enquanto existir dados no banco de dados, faça
			while (rset.next()) {

				Promocoes promocao = new Promocoes();

				// Recupera o id no banco e atribui ele ao objeto
				promocao.setId_promocao(rset.getInt("id_promocao"));

				// Recupera o id do administrador no banco e atribui ele ao objeto
				promocao.setId_admin(rset.getInt("id_admin"));

				// Recupera o destino no banco e atribui ele ao objeto
				promocao.setDestino(rset.getString("destino"));

				// Recupera a data de ida no banco e atribui ela ao objeto
				promocao.setData_ida(rset.getString("data_ida"));

				// Recupera o horário de ida no banco e atribui ele ao objeto
				promocao.setHorario_ida(rset.getString("horario_ida"));

				// Recupera a data de volta no banco e atribui ela ao objeto
				promocao.setData_volta(rset.getString("data_volta"));

				// Recupera o horário de volta no banco e atribui ele ao objeto
				promocao.setHorario_volta(rset.getString("horario_volta"));

				// Recupera a cia aérea no banco e atribui ela ao objeto
				promocao.setCia_aerea(rset.getString("cia_aerea"));

				// Recupera o hotel no banco e atribui ele ao objeto
				promocao.setHotel(rset.getString("hotel"));

				// Recupera as observações no banco e atribui elas ao objeto
				promocao.setObservacoes(rset.getString("observacoes"));
				
				// Recupera o valor no banco e atribui ele ao objeto
				promocao.setValor(rset.getDouble("valor"));

				// Recupera o valor promocional no banco e atribui ele ao objeto
				promocao.setValor_promocional(rset.getDouble("valor_promocional"));

				// Adiciona o pacote promocional recuperado a lista de promoções
				promocoes.add(promocao);
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
		if (promocoes.size() == 0) {
			System.out.println("Nao ha promocoes cadastradas no banco de dados!");
		}
		return promocoes;
	}

	public void update(Promocoes promocao) {

		boolean consulta = false;

		for (Promocoes p : getPromocoes()) {
			if (p.getId_promocao() == promocao.getId_promocao()) {
				consulta = true;
			}
		}

		if (consulta) {

			String sql = "UPDATE promocoes SET destino = ?, data_ida = ?, horario_ida = ?, data_volta = ?, horario_volta = ?, cia_aerea = ?, hotel = ?, observacoes = ?, valor = ?, valor_promocional = ?" + " WHERE id_promocao = ?";

			try {
				// Cria uma conexão com o banco
				conn = Conexao.createConnectionToMySQL();

				// Cria um PreparedStatment, classe usada para executar a query
				pstm = conn.prepareStatement(sql);

				// Adiciona o valor do primeiro parâmetro da sql
				pstm.setString(1, promocao.getDestino());

				// Adiciona o valor do segundo parâmetro da sql
				pstm.setString(2, promocao.getData_ida());

				// Adiciona o valor do terceiro parâmetro da sql
				pstm.setString(3, promocao.getHorario_ida());

				// Adiciona o valor do quarto parâmetro da sql
				pstm.setString(4, promocao.getData_volta());

				// Adiciona o valor do quinto parâmetro da sql
				pstm.setString(5, promocao.getHorario_volta());

				// Adiciona o valor do sexto parâmetro da sql
				pstm.setString(6, promocao.getCia_aerea());

				// Adiciona o valor do sétimo parâmetro da sql
				pstm.setString(7, promocao.getHotel());

				// Adiciona o valor do oitavo parâmetro da sql
				pstm.setString(8, promocao.getObservacoes());

				// Adiciona o valor do nôno parâmetro da sql
				pstm.setDouble(9, promocao.getValor());

				// Adiciona o valor do décimo parâmetro da sql
				pstm.setDouble(10, promocao.getValor_promocional());

				// Adiciona o valor do décimo primeiro parâmetro da sql
				pstm.setInt(11, promocao.getId_promocao());

				// Executa a sql para inserção dos dados
				pstm.execute();

				System.out.println("Pacote promocional atualizado com sucesso!");

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

	public void removeById(int id_promocao) {

		boolean consulta = false;

		for (Promocoes p : getPromocoes()) {
			if (p.getId_promocao() == id_promocao) {
				consulta = true;
			}
		}

		if (consulta) {

			String sql = "DELETE FROM promocoes WHERE id_promocao = ?";

			try {
				conn = Conexao.createConnectionToMySQL(); // cria a conexao

				pstm = conn.prepareStatement(sql); // passa comando sql para o objeto pstm

				pstm.setInt(1, id_promocao); // seta o id no comando sql

				pstm.execute(); // executa o comando sql que está no objeto pstm

				System.out.println("Promocao excluida com sucesso!");

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