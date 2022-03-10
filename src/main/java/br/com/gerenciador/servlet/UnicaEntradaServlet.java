package br.com.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.acao.ListaEmpresas;

@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	String acao = req.getParameter("acao");
    	
    	if(acao.equals("listarEmpresas")) {
    		System.out.println("listando empresas");
    		
    		ListaEmpresas listaEmpresas = new ListaEmpresas();
    		listaEmpresas.executa(req, resp);
    	}
    	
    	if(acao.equals("removeEmpresas")) {
    		System.out.println("remove empresa");
    	}
    	
    	if(acao.equals("novaEmpresas")) {
    		System.out.println("nova empresa");
    	}
    	
    	if(acao.equals("alteraEmpresas")) {
    		System.out.println("altera empresa");
    	}
    }

}
