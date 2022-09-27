package controller.promocoes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.promocoes.Promocao;
import model.promocoes.PromocaoDAO;


@WebServlet("/inserir-promocao")
public class InserirPromocaoServlet extends HttpServlet {


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// recebendo os dados do formulario via parametro
		String destino = request.getParameter("destino");
		String data_ida = request.getParameter("data_ida");
		String horario_ida = request.getParameter("horario_ida");
		String data_volta = request.getParameter("data_volta");
		String horario_volta = request.getParameter("horario_volta");
		String cia_aerea = request.getParameter("cia_aerea");
		String hotel = request.getParameter("hotel");
		String observacoes = request.getParameter("observacoes");
		double valor = Double.parseDouble(request.getParameter("valor"));
		double valor_promocional = Double.parseDouble(request.getParameter("valor_promocional"));
		
		
		// criando o objeto promocao 
		Promocao objPromocao =  new Promocao();
		
		// guardando os dados do formulario no objeto
		objPromocao.setDestino(destino);
		objPromocao.setData_ida(data_ida);
		objPromocao.setHorario_ida(horario_ida);
		objPromocao.setData_volta(data_volta);
		objPromocao.setHorario_volta(horario_volta);
		objPromocao.setCia_aerea(cia_aerea);
		objPromocao.setHotel(hotel);
		objPromocao.setObservacoes(observacoes);
		objPromocao.setValor(valor);
		objPromocao.setValor_promocional(valor_promocional);
		
		// criando um objeto DAO para enviar o objeto Promocao para o banco de dados
		// usando o método save da classe PromocaoDAO
		PromocaoDAO pdao = new PromocaoDAO();		
		pdao.save(objPromocao);
		
		// Redirecionando o usuario para a pagina inicial do crud de destinos.
		response.sendRedirect("cadastro-promocao");	
		
	}

}