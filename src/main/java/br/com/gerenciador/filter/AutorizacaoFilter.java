package br.com.gerenciador.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AutorizacaoFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}
	
	@Override
	public void destroy() {}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		String paramAcao = request.getParameter("acao");
		
    	HttpSession sessao = req.getSession();
    	boolean usuarioNaoAutenticado = (sessao.getAttribute("usuarioLogado") == null);
		boolean eAcaoLogin = paramAcao.equals("LoginForm") || paramAcao.equals("Login");
    	
    	if(!eAcaoLogin && usuarioNaoAutenticado) {
    		resp.sendRedirect("entrada?acao=LoginForm");
			return;
		}
			
		chain.doFilter(request, response);
	}
}