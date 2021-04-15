package br.com.guigas.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.guigas.gerenciador.acao.Acao;

@WebServlet("/entrada")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String acaoParam = request.getParameter("acao");
		String nomeDaAcao = "br.com.guigas.gerenciador.acao." + acaoParam;

		String nome = null;
		try {
			Class<?> classe = Class.forName(nomeDaAcao);
			Acao acao = (Acao) classe.newInstance();
			nome = acao.executa(request, response);
		} catch (IllegalAccessException | InstantiationException | ClassNotFoundException e) {
			throw new ServletException(e);
		}

		String[] split = nome.split(":");
		if(split[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + split[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect("entrada?acao=" + split[1]);
		}
	}

}
