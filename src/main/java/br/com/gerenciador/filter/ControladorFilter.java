package br.com.gerenciador.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.acao.Acao;

//@WebFilter("/entrada")
public class ControladorFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		String paramAcao = req.getParameter("acao");
    	
    	String nomeClasse = "br.com.gerenciador.acao." + paramAcao;
    	String nome;
    	try {
    		Class classe = Class.forName(nomeClasse);
			Acao acao = (Acao) classe.newInstance();
			nome = acao.executa(req, resp);	
		} catch (Exception e) {
			throw new ServletException(e);
		}
    	
    	if(nome.contains("forward:")) {
    		RequestDispatcher rd = req.getRequestDispatcher("WEB-INF" + nome.replace("forward:", ""));
    		rd.forward(req, resp);
    	} else {
    		resp.sendRedirect(nome.replace("redirect:", ""));
    	}
	}

}
