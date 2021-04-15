package br.com.guigas.gerenciador.acao;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.guigas.gerenciador.modelo.BancoSimulado;
import br.com.guigas.gerenciador.modelo.Empresa;

public class AlteraEmpresa implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String nome = request.getParameter("nome");

		String data = request.getParameter("data");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date = LocalDate.parse(data, formatter);

		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);

		BancoSimulado banco = new BancoSimulado();

		Empresa empresa = banco.buscaEmpresaPeloId(id);
		empresa.setNome(nome);
		empresa.setDataAbertura(date);
		
		return "redirect:ListaEmpresas";
	}
}
