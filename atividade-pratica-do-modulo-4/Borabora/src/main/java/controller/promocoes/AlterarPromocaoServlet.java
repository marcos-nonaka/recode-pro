package controller.promocoes;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.promocoes.Promocao;
import model.promocoes.PromocaoDAO;

@WebServlet("/editar-promocao")
public class AlterarPromocaoServlet extends HttpServlet {


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idPromocao = Integer.parseInt(req.getParameter("id"));
		PromocaoDAO pdao = new PromocaoDAO();
		Promocao promocaoSelecionada = pdao.getPromocaoById(idPromocao);

		req.setAttribute("promocao", promocaoSelecionada);
	
		RequestDispatcher rd = req.getRequestDispatcher("./views/promocoes/alterarPromocao.jsp");

        rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Promocao promocaoAlterada = new Promocao();		
		promocaoAlterada.setDestino(req.getParameter("destino"));
		promocaoAlterada.setData_ida(req.getParameter("data_ida"));
		promocaoAlterada.setHorario_ida(req.getParameter("horario_ida"));
		promocaoAlterada.setData_volta(req.getParameter("data_volta"));
		promocaoAlterada.setHorario_volta(req.getParameter("horario_volta"));
		promocaoAlterada.setCia_aerea(req.getParameter("cia_aerea"));
		promocaoAlterada.setHotel(req.getParameter("hotel"));
		promocaoAlterada.setObservacoes(req.getParameter("observacoes"));
		promocaoAlterada.setValor(Double.parseDouble(req.getParameter("valor")));
		promocaoAlterada.setValor_promocional(Double.parseDouble(req.getParameter("valor_promocional")));
		promocaoAlterada.setId(Integer.parseInt(req.getParameter("id")));
		
		PromocaoDAO pd = new PromocaoDAO();
		pd.update(promocaoAlterada);	
		resp.sendRedirect("cadastro-promocao");
	}
}