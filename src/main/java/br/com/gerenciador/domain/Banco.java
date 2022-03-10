package br.com.gerenciador.domain;

import java.util.ArrayList;
import java.util.List;

public class Banco {

	private static List<Empresa> empresas = new ArrayList<>();
	private static Integer idSequencial = 1;
	
	static {
		empresas.add(new Empresa(idSequencial++, "Google"));
		empresas.add(new Empresa(idSequencial++, "Facebook"));
	}
	
	public void adicionar(Empresa empresa) {
		empresa.setId(idSequencial++);
		empresas.add(empresa);
	}
	
	public List<Empresa> getEmpresas() {
		return empresas;
	}
	
	public void remover(Empresa empresa) {
		empresas.remove(empresa);
	}
	
	public void removerById(Integer id) {
		Empresa emp = null;
		
		for(Empresa empresa : empresas) {
			if(empresa.getId().equals(id)) {
				emp = empresa;
			}
		}
		
		if(emp != null) {
			empresas.remove(emp);
		}
	}
	
	public Empresa getEmpresaById(Integer id) {
		for(Empresa empresa : empresas) {
			if(empresa.getId().equals(id)) {
				return empresa;
			}
		}
		return null;
	}

}
