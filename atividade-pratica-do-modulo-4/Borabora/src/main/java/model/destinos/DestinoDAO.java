package model.destinos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Conexao;

public class DestinoDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Destino destino) {

		// Os ? são os parâmetros que nós vamos adicionar na base de dados

		String sql = "INSERT INTO destino(destino,data_ida,horario_ida,data_volta,horario_volta,cia_aerea,hotel,observacoes,valor)" + " VALUES(?,?,?,?,?,?,?,?,?)";

		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adiciona o valor do primeiro parâmetro da sql
			pstm.setString(1, destino.getDestino());
			// Adicionar o valor do segundo parâmetro da sql
			pstm.setString(2, destino.getData_ida());
			// Adiciona o valor do terceiro parâmetro da sql
			pstm.setString(3, destino.getHorario_ida());
			pstm.setString(4, destino.getData_volta());
			pstm.setString(5, destino.getHorario_volta());
			pstm.setString(6, destino.getCia_aerea());
			pstm.setString(7, destino.getHotel());
			pstm.setString(8, destino.getObservacoes());
			pstm.setDouble(9, destino.getValor());

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

	public void removeById(int id) {

		String sql = "DELETE FROM destino WHERE id = ?";

		try {
			conn = Conexao.createConnectionToMySQL(); // cria a conexao

			pstm = conn.prepareStatement(sql); // passa comando sql para o objeto pstm

			pstm.setInt(1, id); // seta o id no comando sql

			pstm.execute(); // executa o comando sql que está no objeto pstm

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
	}

	public void update(Destino destino) {

		String sql = "UPDATE destino SET destino = ?, data_ida = ?, horario_ida = ?, data_volta = ?, horario_volta = ?, cia_aerea = ?, hotel = ?, observacoes = ?, valor = ?" + " WHERE id = ?";

		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adiciona o valor do primeiro parâmetro da sql
			pstm.setString(1, destino.getDestino());
			// Adicionar o valor do segundo parâmetro da sql
			pstm.setString(2, destino.getData_ida());
			// Adiciona o valor do terceiro parâmetro da sql
			pstm.setString(3, destino.getHorario_ida());
			pstm.setString(4, destino.getData_volta());
			pstm.setString(5, destino.getHorario_volta());
			pstm.setString(6, destino.getCia_aerea());
			pstm.setString(7, destino.getHotel());
			pstm.setString(8, destino.getObservacoes());
			pstm.setDouble(9, destino.getValor());

			pstm.setInt(10, destino.getId());

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

	public List<Destino> getDestinos() {

		String sql = "SELECT * FROM destino";

		List<Destino> destinos = new ArrayList<Destino>();

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			// Enquanto existir dados no banco de dados, faça
			while (rset.next()) {

				Destino destino = new Destino();

				// Recupera o id do banco e atribui ele ao objeto
				destino.setId(rset.getInt("id"));

				// Recupera o destino do banco e atribui ele ao objeto
				destino.setDestino(rset.getString("destino"));
				
				// Recupera a data de ida do banco e atribui ele ao objeto
				String data_ida = rset.getString("data_ida");
				String data_idaF = data_ida.substring(8, 10) + "/" + data_ida.substring(5, 7) + "/" + data_ida.substring(0, 4);
				destino.setData_ida(data_idaF);

				destino.setHorario_ida(rset.getString("horario_ida"));
				String data_volta = rset.getString("data_volta");
				String data_voltaF = data_volta.substring(8, 10) + "/" + data_volta.substring(5, 7) + "/" + data_volta.substring(0, 4);
				destino.setData_volta(data_voltaF);
				destino.setHorario_volta(rset.getString("horario_volta"));
				destino.setCia_aerea(rset.getString("cia_aerea"));
				destino.setHotel(rset.getString("hotel"));
				destino.setObservacoes(rset.getString("observacoes"));
				destino.setValor(rset.getDouble("valor"));
				
				// Adiciono o destino recuperado, a lista de contatos
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
		return destinos;
	}
	public Destino getDestinoById(int id) {

		String sql = "SELECT * FROM destino WHERE id = ?";

		Destino destino = new Destino();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL(); // cria a conexao

			pstm = conn.prepareStatement(sql); // passa comando sql para o objeto pstm

			pstm.setInt(1, id); // seta o id no comando sql

			rset = pstm.executeQuery(); // executa o comando sql que está no objeto pstm

			rset.next();
			
			// Recupera o destino do banco e atribui ele ao objeto
			destino.setDestino(rset.getString("destino"));

			// Recupera a data de ida do banco e atribui ele ao objeto
			destino.setData_ida(rset.getString("data_ida"));

			destino.setHorario_ida(rset.getString("horario_ida"));
			destino.setData_volta(rset.getString("data_volta"));
			destino.setHorario_volta(rset.getString("horario_volta"));
			destino.setCia_aerea(rset.getString("cia_aerea"));
			destino.setHotel(rset.getString("hotel"));
			destino.setObservacoes(rset.getString("observacoes"));
			destino.setValor(rset.getDouble("valor"));

			// Recupera o id do banco e atribui ele ao objeto
			destino.setId(rset.getInt("id"));
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
		return destino;
	}
}