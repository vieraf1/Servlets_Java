package br.com.gerenciador.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.domain.Banco;
import br.com.gerenciador.domain.Empresa;

public class ListaEmpresas {

		public void executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			Banco banco = new Banco();
			List<Empresa> empresas = banco.getEmpresas();
			
			req.setAttribute("empresas", empresas);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("/pages/listarEmpresas.jsp");
			dispatcher.forward(req, resp);
		}
	
}
