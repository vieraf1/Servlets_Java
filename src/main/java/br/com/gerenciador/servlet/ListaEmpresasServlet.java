package br.com.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.domain.Empresa;


@WebServlet("/listarEmpresas")
public class ListaEmpresasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("Testando listaEmpresas");
		
		Banco banco = new Banco();
		List<Empresa> empresas = banco.getEmpresas();
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println(" <body>");
		out.println("  <ul>");
		
		for(Empresa empresa : empresas) {
			out.println("   <li>");
			out.println("    " + empresa.getNome());
			out.println("   </li>");
		}
		
		out.println("  </ul>");
		out.println(" </body>");
		out.println("</html>");
	}


}
