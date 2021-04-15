package br.com.guigas.gerenciador.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BancoSimulado {

	private static List<Empresa> lista = new ArrayList<Empresa>();
	private static List<Usuario> listaDeUsuario = new ArrayList<Usuario>();
	private static Integer chaveSequencial = 1;

	static {
		Empresa empresa = new Empresa("Alura", LocalDate.of(2020, 12, 31));
		empresa.setId(chaveSequencial++);
		Empresa empresa2 = new Empresa("Google", LocalDate.of(2020, 12, 31));
		empresa2.setId(chaveSequencial++);
		lista.add(empresa);
		lista.add(empresa2);
		
		Usuario usuario = new Usuario("Jonas", "12");
		Usuario usuario2 = new Usuario("Abigail", "12");
		
		listaDeUsuario.add(usuario2);
		listaDeUsuario.add(usuario);
	}

	public void adiciona(Empresa empresa) {
		empresa.setId(chaveSequencial++);
		BancoSimulado.lista.add(empresa);
	}

	public List<Empresa> getEmpresas() {
		return BancoSimulado.lista;
	}

	public static Integer getChaveSequencial() {
		return chaveSequencial;
	}

	public void removeEmpresa(Integer id) {
		Iterator<Empresa> it = lista.iterator();

		while (it.hasNext()) {
			Empresa emp = it.next();
			if (emp.getId() == id) {
				it.remove();
				break;
			}
		}
	}

	public Empresa buscaEmpresaPeloId(Integer id) {
		Iterator<Empresa> it = lista.iterator();
		while (it.hasNext()) {
			Empresa emp = it.next();
			if (emp.getId() == id) {
				return emp;
			}
		}
		return null;
	}
	
	public Usuario existeUsuario(String login, String senha) {
		for(Usuario usuario : listaDeUsuario) {
			if(usuario.equals(new Usuario(login, senha))) {
				return usuario;
			}
		}
		return null;
	}
}
