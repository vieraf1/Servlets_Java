package br.com.gerenciador.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/entrada")
public class AutorizacaoFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String paramAcao = request.getParameter("acao");
    	
    	HttpSession sessao = ((HttpServletRequest)request).getSession();
    	boolean usuarioNaoAutenticado = (sessao.getAttribute("usuarioLogado") == null);
		boolean eAcaoLogin = paramAcao.equals("LoginForm") || paramAcao.equals("Login");
    	
    	if(!eAcaoLogin && usuarioNaoAutenticado) {
    		((HttpServletResponse)response).sendRedirect("entrada?acao=LoginForm");
			return;
		}
			
		chain.doFilter(request, response);
	}

}
