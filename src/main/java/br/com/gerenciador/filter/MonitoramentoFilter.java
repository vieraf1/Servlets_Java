package br.com.gerenciador.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/entrada")
public class MonitoramentoFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		long antes = System.currentTimeMillis();
		
		chain.doFilter(req, resp);
		
		long depois = System.currentTimeMillis();
		System.out.println("dura��o: " + (depois - antes));
	}
	
}
