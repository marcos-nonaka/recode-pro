package controller.destinos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.destinos.Destino;
import model.destinos.DestinoDAO;

@WebServlet("/cadastro-destino")
public class ListaDestinosServlet extends HttpServlet {


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Destino> listaDestinos = new ArrayList<Destino>();
		DestinoDAO ddao = new DestinoDAO();		
		listaDestinos = ddao.getDestinos();		
		req.setAttribute("listaDestinos", listaDestinos);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("views/destinos/crud-destinos.jsp");
		dispatcher.forward(req, resp);
	}

}
