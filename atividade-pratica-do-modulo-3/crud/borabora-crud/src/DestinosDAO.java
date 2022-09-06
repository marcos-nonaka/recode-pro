import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DestinosDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Destinos destino) {

		// Os ? são os parâmetros que nós vamos adicionar na base de dados

		String sql = "INSERT INTO destinos(destino,data_ida,horario_ida,data_volta,horario_volta,cia_aerea,hotel,observacoes,valor,id_admin)" + " VALUES(?,?,?,?,?,?,?,?,?,?)";

		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adiciona o valor do primeiro parâmetro da sql
			pstm.setString(1, destino.getDestino());

			// Adiciona o valor do segundo parâmetro da sql
			pstm.setString(2, destino.getData_ida());

			// Adiciona o valor do terceiro parâmetro da sql
			pstm.setString(3, destino.getHorario_ida());

			// Adiciona o valor do quarto parâmetro da sql
			pstm.setString(4, destino.getData_volta());

			// Adiciona o valor do quinto parâmetro da sql
			pstm.setString(5, destino.getHorario_volta());

			// Adiciona o valor do sexto parâmetro da sql
			pstm.setString(6, destino.getCia_aerea());

			// Adiciona o valor do sétimo parâmetro da sql
			pstm.setString(7, destino.getHotel());

			// Adiciona o valor do oitavo parâmetro da sql
			pstm.setString(8, destino.getObservacoes());

			// Adiciona o valor do nôno parâmetro da sql
			pstm.setDouble(9, destino.getValor());

			// Adiciona o valor do décimo parâmetro da sql
			pstm.setInt(10, destino.getId_admin());
			
			// Executa a sql para inserção dos dados
			pstm.execute();

			System.out.println("Destino adicionado com sucesso!");
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

	public List<Destinos> getDestinos() {

		String sql = "SELECT * FROM destinos";

		List<Destinos> destinos = new ArrayList<Destinos>();

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			// Enquanto existir dados no banco de dados, faça
			while (rset.next()) {

				Destinos destino = new Destinos();

				// Recupera o id no banco e atribui ele ao objeto
				destino.setId_destino(rset.getInt("id_destino"));

				// Recupera o id do administrador no banco e atribui ele ao objeto
				destino.setId_admin(rset.getInt("id_admin"));

				// Recupera o destino no banco e atribui ele ao objeto
				destino.setDestino(rset.getString("destino"));

				// Recupera a data de ida no banco e atribui ela ao objeto
				destino.setData_ida(rset.getString("data_ida"));

				// Recupera o horário de ida no banco e atribui ele ao objeto
				destino.setHorario_ida(rset.getString("horario_ida"));

				// Recupera a data de volta no banco e atribui ela ao objeto
				destino.setData_volta(rset.getString("data_volta"));

				// Recupera o horário de volta no banco e atribui ele ao objeto
				destino.setHorario_volta(rset.getString("horario_volta"));

				// Recupera a cia aérea no banco e atribui ela ao objeto
				destino.setCia_aerea(rset.getString("cia_aerea"));

				// Recupera o hotel no banco e atribui ele ao objeto
				destino.setHotel(rset.getString("hotel"));

				// Recupera as observações no banco e atribui elas ao objeto
				destino.setObservacoes(rset.getString("observacoes"));
				
				// Recupera o valor no banco e atribui ele ao objeto
				destino.setValor(rset.getDouble("valor"));

				// Adiciona o destino recuperado a lista de destinos
				destinos.add(destino);
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
		if (destinos.size() == 0) {
			System.out.println("Nao ha destinos cadastrados no banco de dados!");
		}
		return destinos;
	}

	public void update(Destinos destino) {

		boolean consulta = false;

		for (Destinos d : getDestinos()) {
			if (d.getId_destino() == destino.getId_destino()) {
				consulta = true;
			}
		}

		if (consulta) {

			String sql = "UPDATE destinos SET destino = ?, data_ida = ?, horario_ida = ?, data_volta = ?, horario_volta = ?, cia_aerea = ?, hotel = ?, observacoes = ?, valor = ?" + " WHERE id_destino = ?";

			try {
				// Cria uma conexão com o banco
				conn = Conexao.createConnectionToMySQL();

				// Cria um PreparedStatment, classe usada para executar a query
				pstm = conn.prepareStatement(sql);

				// Adiciona o valor do primeiro parâmetro da sql
				pstm.setString(1, destino.getDestino());

				// Adiciona o valor do segundo parâmetro da sql
				pstm.setString(2, destino.getData_ida());

				// Adiciona o valor do terceiro parâmetro da sql
				pstm.setString(3, destino.getHorario_ida());

				// Adiciona o valor do quarto parâmetro da sql
				pstm.setString(4, destino.getData_volta());

				// Adiciona o valor do quinto parâmetro da sql
				pstm.setString(5, destino.getHorario_volta());

				// Adiciona o valor do sexto parâmetro da sql
				pstm.setString(6, destino.getCia_aerea());

				// Adiciona o valor do sétimo parâmetro da sql
				pstm.setString(7, destino.getHotel());

				// Adiciona o valor do oitavo parâmetro da sql
				pstm.setString(8, destino.getObservacoes());

				// Adiciona o valor do nôno parâmetro da sql
				pstm.setDouble(9, destino.getValor());

				// Adiciona o valor do décimo parâmetro da sql
				pstm.setInt(10, destino.getId_destino());

				// Executa a sql para inserção dos dados
				pstm.execute();

				System.out.println("Destino atualizado com sucesso!");

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

	public void removeById(int id_destino) {

		boolean consulta = false;

		for (Destinos d : getDestinos()) {
			if (d.getId_destino() == id_destino) {
				consulta = true;
			}
		}

		if (consulta) {

			String sql = "DELETE FROM destinos WHERE id_destino = ?";

			try {
				conn = Conexao.createConnectionToMySQL(); // cria a conexao

				pstm = conn.prepareStatement(sql); // passa comando sql para o objeto pstm

				pstm.setInt(1, id_destino); // seta o id no comando sql

				pstm.execute(); // executa o comando sql que está no objeto pstm

				System.out.println("Destino excluido com sucesso!");

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