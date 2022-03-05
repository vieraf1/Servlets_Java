package br.com.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
		String dataAberturaParametro = request.getParameter("data");
		
		SimpleDateFormat sdt = new SimpleDateFormat("dd/MM/yyyy");
		Date dataAbertura;
		try {
			dataAbertura = sdt.parse(dataAberturaParametro);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		Empresa empresa = new Empresa(null, nome, dataAbertura);
		
		Banco banco = new Banco();
		banco.adicionar(empresa);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/listarEmpresas");
		request.setAttribute("nomeEmpresa", empresa.getNome());
		dispatcher.forward(request, response);
	}

}
