package br.com.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.domain.Empresa;

@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("acessando servlet novaEmpresa");
		
		String nome = request.getParameter("nome");
		Empresa empresa = new Empresa(null, nome);
		
		Banco banco = new Banco();
		banco.adicionar(empresa);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/novaEmpresaCriada.jsp");
		request.setAttribute("nomeEmpresa", empresa.getNome());
		dispatcher.forward(request, response);
	}

}
