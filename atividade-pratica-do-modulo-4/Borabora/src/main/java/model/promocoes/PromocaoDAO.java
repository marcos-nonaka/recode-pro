package model.promocoes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Conexao;

public class PromocaoDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Promocao promocao) {

		// Os ? são os parâmetros que nós vamos adicionar na base de dados

		String sql = "INSERT INTO promocao(destino,data_ida,horario_ida,data_volta,horario_volta,cia_aerea,hotel,observacoes,valor,valor_promocional)" + " VALUES(?,?,?,?,?,?,?,?,?,?)";

		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adiciona o valor do primeiro parâmetro da sql
			pstm.setString(1, promocao.getDestino());
			// Adicionar o valor do segundo parâmetro da sql
			pstm.setString(2, promocao.getData_ida());
			// Adiciona o valor do terceiro parâmetro da sql
			pstm.setString(3, promocao.getHorario_ida());
			pstm.setString(4, promocao.getData_volta());
			pstm.setString(5, promocao.getHorario_volta());
			pstm.setString(6, promocao.getCia_aerea());
			pstm.setString(7, promocao.getHotel());
			pstm.setString(8, promocao.getObservacoes());
			pstm.setDouble(9, promocao.getValor());
			pstm.setDouble(10, promocao.getValor_promocional());

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

		String sql = "DELETE FROM promocao WHERE id = ?";

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

	public void update(Promocao promocao) {

		String sql = "UPDATE promocao SET destino = ?, data_ida = ?, horario_ida = ?, data_volta = ?, horario_volta = ?, cia_aerea = ?, hotel = ?, observacoes = ?, valor = ?, valor_promocional = ?" + " WHERE id = ?";

		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adiciona o valor do primeiro parâmetro da sql
			pstm.setString(1, promocao.getDestino());
			// Adicionar o valor do segundo parâmetro da sql
			pstm.setString(2, promocao.getData_ida());
			// Adiciona o valor do terceiro parâmetro da sql
			pstm.setString(3, promocao.getHorario_ida());
			pstm.setString(4, promocao.getData_volta());
			pstm.setString(5, promocao.getHorario_volta());
			pstm.setString(6, promocao.getCia_aerea());
			pstm.setString(7, promocao.getHotel());
			pstm.setString(8, promocao.getObservacoes());
			pstm.setDouble(9, promocao.getValor());
			pstm.setDouble(10, promocao.getValor_promocional());

			pstm.setInt(11, promocao.getId());

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

	public List<Promocao> getPromocoes() {

		String sql = "SELECT * FROM promocao";

		List<Promocao> promocoes = new ArrayList<Promocao>();

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			// Enquanto existir dados no banco de dados, faça
			while (rset.next()) {

				Promocao promocao = new Promocao();

				// Recupera o id do banco e atribui ele ao objeto
				promocao.setId(rset.getInt("id"));

				// Recupera o destino do banco e atribui ele ao objeto
				promocao.setDestino(rset.getString("destino"));
				
				// Recupera a data de ida do banco e atribui ele ao objeto
				String data_ida = rset.getString("data_ida");
				String data_idaF = data_ida.substring(8, 10) + "/" + data_ida.substring(5, 7) + "/" + data_ida.substring(0, 4);
				promocao.setData_ida(data_idaF);

				promocao.setHorario_ida(rset.getString("horario_ida"));
				String data_volta = rset.getString("data_volta");
				String data_voltaF = data_volta.substring(8, 10) + "/" + data_volta.substring(5, 7) + "/" + data_volta.substring(0, 4);
				promocao.setData_volta(data_voltaF);
				promocao.setHorario_volta(rset.getString("horario_volta"));
				promocao.setCia_aerea(rset.getString("cia_aerea"));
				promocao.setHotel(rset.getString("hotel"));
				promocao.setObservacoes(rset.getString("observacoes"));
				promocao.setValor(rset.getDouble("valor"));
				promocao.setValor_promocional(rset.getDouble("valor_promocional"));
				
				// Adiciono o destino recuperado, a lista de contatos
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
		return promocoes;
	}
	public Promocao getPromocaoById(int id) {

		String sql = "SELECT * FROM promocao WHERE id = ?";

		Promocao promocao = new Promocao();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL(); // cria a conexao

			pstm = conn.prepareStatement(sql); // passa comando sql para o objeto pstm

			pstm.setInt(1, id); // seta o id no comando sql

			rset = pstm.executeQuery(); // executa o comando sql que está no objeto pstm

			rset.next();
			
			// Recupera o destino do banco e atribui ele ao objeto
			promocao.setDestino(rset.getString("destino"));

			// Recupera a data de ida do banco e atribui ele ao objeto
			promocao.setData_ida(rset.getString("data_ida"));

			promocao.setHorario_ida(rset.getString("horario_ida"));
			promocao.setData_volta(rset.getString("data_volta"));
			promocao.setHorario_volta(rset.getString("horario_volta"));
			promocao.setCia_aerea(rset.getString("cia_aerea"));
			promocao.setHotel(rset.getString("hotel"));
			promocao.setObservacoes(rset.getString("observacoes"));
			promocao.setValor(rset.getDouble("valor"));
			promocao.setValor_promocional(rset.getDouble("valor_promocional"));

			// Recupera o id do banco e atribui ele ao objeto
			promocao.setId(rset.getInt("id"));
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
		return promocao;
	}
}