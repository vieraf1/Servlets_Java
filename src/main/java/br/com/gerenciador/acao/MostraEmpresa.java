package br.com.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.domain.Banco;
import br.com.gerenciador.domain.Empresa;

public class MostraEmpresa implements Acao {
	
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Banco banco = new Banco();
		Integer id = Integer.valueOf(req.getParameter("id"));
		
		Empresa empresa = banco.getEmpresaById(id);
		
		req.setAttribute("empresa", empresa);
		
		return "forward:/pages/formAlteraEmpresa.jsp";
	}

}
