package br.com.gerenciador.acao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.domain.Banco;
import br.com.gerenciador.domain.Empresa;

public class MostraEmpresa {
	
	public void executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Banco banco = new Banco();
		Integer id = Integer.valueOf(req.getParameter("id"));
		
		Empresa empresa = banco.getEmpresaById(id);
		
		req.setAttribute("empresa", empresa);
		RequestDispatcher rd = req.getRequestDispatcher("/pages/formAlteraEmpresa.jsp");
		rd.forward(req, resp);
	}

}
