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

public class NovaEmpresa {

	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nome");
		String dataAberturaParametro = req.getParameter("data");
		
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
		
		return "redirect:entrada?acao=listarEmpresas";
	}
	
}
