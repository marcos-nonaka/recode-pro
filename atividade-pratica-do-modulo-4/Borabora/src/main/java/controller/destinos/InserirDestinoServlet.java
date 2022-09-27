package controller.destinos;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.destinos.Destino;
import model.destinos.DestinoDAO;


@WebServlet("/inserir-destino")
public class InserirDestinoServlet extends HttpServlet {


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
		
		
		// criando o objeto destino 
		Destino objDestino =  new Destino();
		
		// guardando os dados do formulario no objeto
		objDestino.setDestino(destino);
		objDestino.setData_ida(data_ida);
		objDestino.setHorario_ida(horario_ida);
		objDestino.setData_volta(data_volta);
		objDestino.setHorario_volta(horario_volta);
		objDestino.setCia_aerea(cia_aerea);
		objDestino.setHotel(hotel);
		objDestino.setObservacoes(observacoes);
		objDestino.setValor(valor);
		
		// criando um objeto DAO para enviar o objeto Destino para o banco de dados
		// usando o método save da classe DestinoDAO
		DestinoDAO ddao = new DestinoDAO();		
		ddao.save(objDestino);
		
		// Redirecionando o usuario para a pagina inicial do crud de destinos.
		response.sendRedirect("cadastro-destino");	
		
	}

}