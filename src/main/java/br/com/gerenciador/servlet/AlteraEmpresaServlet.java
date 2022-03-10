package br.com.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.domain.Banco;
import br.com.gerenciador.domain.Empresa;

@WebServlet("/alteraEmpresa")
public class AlteraEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Banco banco = new Banco();
		
		Integer id = Integer.valueOf(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String dataAberturaParametro = request.getParameter("data");
		
		SimpleDateFormat sdt = new SimpleDateFormat("dd/MM/yyyy");
		Date dataAbertura;
		try {
			dataAbertura = sdt.parse(dataAberturaParametro);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		Empresa emp = banco.getEmpresaById(id);
		emp.setNome(nome);
		emp.setDataAbertura(dataAbertura);
		
		response.sendRedirect("listarEmpresas");
	}

}
