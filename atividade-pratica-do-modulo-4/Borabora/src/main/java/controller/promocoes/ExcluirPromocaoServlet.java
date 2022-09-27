package controller.promocoes;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.promocoes.PromocaoDAO;

@WebServlet("/excluir-promocao")
public class ExcluirPromocaoServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idPromocao = Integer.parseInt(req.getParameter("id"));

		PromocaoDAO pdao = new PromocaoDAO();

		pdao.removeById(idPromocao);

		resp.sendRedirect("cadastro-promocao");
	}

}