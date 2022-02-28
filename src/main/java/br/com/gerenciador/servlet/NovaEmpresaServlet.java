package br.com.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.domain.Empresa;

@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("Testando novaEmpresa");
		
		String nome = request.getParameter("nome");
		Empresa empresa = new Empresa(null, nome);
		
		Banco banco = new Banco();
		banco.adicionar(empresa);
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println(" <body>");
		out.println("  Empresa " + nome + " cadastrada com sucesso!");
		out.println(" </body>");
		out.println("</html>");
	}

}
