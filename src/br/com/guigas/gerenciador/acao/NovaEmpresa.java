package br.com.guigas.gerenciador.acao;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.guigas.gerenciador.modelo.BancoSimulado;
import br.com.guigas.gerenciador.modelo.Empresa;

public class NovaEmpresa implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String nome = request.getParameter("nome");
		String data = request.getParameter("data");
		if(data.isEmpty()) {
			return "redirect:ListaEmpresas";
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date = LocalDate.parse(data, formatter);
		Empresa empresa = new Empresa(nome, date);

		BancoSimulado banco = new BancoSimulado();
		banco.adiciona(empresa);

		return "redirect:ListaEmpresas";
	}

}
