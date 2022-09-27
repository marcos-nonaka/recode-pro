package controller.destinos;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.destinos.Destino;
import model.destinos.DestinoDAO;

@WebServlet("/editar-destino")
public class AlterarDestinoServlet extends HttpServlet {


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idDestino = Integer.parseInt(req.getParameter("id"));
		DestinoDAO ddao = new DestinoDAO();
		Destino destinoSelecionado = ddao.getDestinoById(idDestino);

		req.setAttribute("destino", destinoSelecionado);
	
		RequestDispatcher rd = req.getRequestDispatcher("./views/destinos/alterarDestino.jsp");

        rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Destino destinoAlterado = new Destino();		
		destinoAlterado.setDestino(req.getParameter("destino"));
		destinoAlterado.setData_ida(req.getParameter("data_ida"));
		destinoAlterado.setHorario_ida(req.getParameter("horario_ida"));
		destinoAlterado.setData_volta(req.getParameter("data_volta"));
		destinoAlterado.setHorario_volta(req.getParameter("horario_volta"));
		destinoAlterado.setCia_aerea(req.getParameter("cia_aerea"));
		destinoAlterado.setHotel(req.getParameter("hotel"));
		destinoAlterado.setObservacoes(req.getParameter("observacoes"));
		destinoAlterado.setValor(Double.parseDouble(req.getParameter("valor")));
		destinoAlterado.setId(Integer.parseInt(req.getParameter("id")));
		
		DestinoDAO dd = new DestinoDAO();
		dd.update(destinoAlterado);	
		resp.sendRedirect("cadastro-destino");
	}
}