package controller.promocoes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.promocoes.Promocao;
import model.promocoes.PromocaoDAO;

@WebServlet("/cadastro-promocao")
public class ListaPromocoesServlet extends HttpServlet {


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Promocao> listaPromocoes = new ArrayList<Promocao>();
		PromocaoDAO pdao = new PromocaoDAO();		
		listaPromocoes = pdao.getPromocoes();		
		req.setAttribute("listaPromocoes", listaPromocoes);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("views/promocoes/crud-promocoes.jsp");
		dispatcher.forward(req, resp);
	}

}
