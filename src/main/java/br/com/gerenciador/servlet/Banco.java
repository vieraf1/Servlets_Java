package br.com.gerenciador.servlet;

import java.util.ArrayList;
import java.util.List;

import br.com.gerenciador.domain.Empresa;

public class Banco {

	private static List<Empresa> empresas = new ArrayList<>();
	
	static {
		empresas.add(new Empresa(1, "Google"));
		empresas.add(new Empresa(2, "Facebook"));
	}
	
	public void adicionar(Empresa empresa) {
		empresas.add(empresa);
	}
	
	public List<Empresa> getEmpresas() {
		return empresas;
	}

}
