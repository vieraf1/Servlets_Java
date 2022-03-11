package br.com.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.domain.Banco;
import br.com.gerenciador.domain.Empresa;

public class AlteraEmpresa {
	
	public void executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Banco banco = new Banco();
		
		Integer id = Integer.valueOf(req.getParameter("id"));
		String nome = req.getParameter("nome");
		String dataAberturaParametro = req.getParameter("data");
		
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
		
		resp.sendRedirect("entrada?acao=listarEmpresas");
	}

}
