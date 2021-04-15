package br.com.guigas.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.guigas.gerenciador.modelo.BancoSimulado;
import br.com.guigas.gerenciador.modelo.Usuario;

public class Login implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String login = request.getParameter("login");
		String senha = request.getParameter("senha");

		BancoSimulado banco = new BancoSimulado();
		if(banco.existeUsuario(login, senha) != null) {
			HttpSession session = request.getSession();
			Usuario usuario = new Usuario(login, senha);
			session.setAttribute("usuarioLogado", usuario);
			return "redirect:ListaEmpresas";
		}
		return "forward:formLogin.jsp";
	}

}
