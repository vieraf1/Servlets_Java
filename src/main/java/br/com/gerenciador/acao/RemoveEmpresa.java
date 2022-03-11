package br.com.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.domain.Banco;

public class RemoveEmpresa {
	
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Banco banco = new Banco();
		Integer id = Integer.valueOf(req.getParameter("id"));
		
		banco.removerById(id);
		
		return "redirect:entrada?acao=listarEmpresas";
	}

}
