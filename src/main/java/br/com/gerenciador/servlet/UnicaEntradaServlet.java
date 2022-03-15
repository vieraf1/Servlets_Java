package br.com.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.acao.Acao;

@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
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
