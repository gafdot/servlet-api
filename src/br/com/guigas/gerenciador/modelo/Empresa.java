package br.com.guigas.gerenciador.modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Empresa {

	private Integer id;
	private String nome;
	private LocalDate dataAbertura;

	public Empresa(String nome, LocalDate dataAbertura) {
		this.nome = nome;
		this.dataAbertura = dataAbertura;
	}

	public String getDataAbertura() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return formatter.format(dataAbertura);
	}

	public void setDataAbertura(LocalDate dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
