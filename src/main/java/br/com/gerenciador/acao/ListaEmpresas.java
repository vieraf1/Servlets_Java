package br.com.gerenciador.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.domain.Banco;
import br.com.gerenciador.domain.Empresa;

public class ListaEmpresas {

		public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			Banco banco = new Banco();
			List<Empresa> empresas = banco.getEmpresas();
			
			req.setAttribute("empresas", empresas);
			
			return "forward:/pages/listarEmpresas.jsp";
		}
	
}
