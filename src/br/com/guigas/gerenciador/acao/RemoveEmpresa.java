package br.com.guigas.gerenciador.acao;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.guigas.gerenciador.modelo.BancoSimulado;

public class RemoveEmpresa implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);

		BancoSimulado banco = new BancoSimulado();

		banco.removeEmpresa(id);

		return "redirect:ListaEmpresas";
	}
}
