package br.com.guigas.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.guigas.gerenciador.modelo.BancoSimulado;

public class ListaEmpresas implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BancoSimulado banco = new BancoSimulado();

		request.setAttribute("listaEmpresas", banco.getEmpresas());
		
		return "forward:listaEmpresa.jsp";
	}
}
