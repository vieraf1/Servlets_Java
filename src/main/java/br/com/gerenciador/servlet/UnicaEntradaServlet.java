package br.com.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.acao.AlteraEmpresa;
import br.com.gerenciador.acao.ListaEmpresas;
import br.com.gerenciador.acao.MostraEmpresa;
import br.com.gerenciador.acao.NovaEmpresa;
import br.com.gerenciador.acao.RemoveEmpresa;

@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	String acao = req.getParameter("acao");
    	String nome = "";
    	
    	if(acao.equals("listarEmpresas")) {
    		ListaEmpresas listaEmpresas = new ListaEmpresas();
    		nome = listaEmpresas.executa(req, resp);
    	}
    	
    	if(acao.equals("removeEmpresa")) {
    		RemoveEmpresa removeEmpresa = new RemoveEmpresa();
    		nome = removeEmpresa.executa(req, resp);
    	}
    	
    	if(acao.equals("mostraEmpresa")) {
    		MostraEmpresa mostraEmpresa = new MostraEmpresa();
    		nome = mostraEmpresa.executa(req, resp);
    	}
    	
    	if(acao.equals("alteraEmpresa")) {
    		AlteraEmpresa alteraEmpresa = new AlteraEmpresa();
    		nome = alteraEmpresa.executa(req, resp);
    	}
    	
    	if(acao.equals("novaEmpresa")) {
    		NovaEmpresa novaEmpresa = new NovaEmpresa();
    		nome = novaEmpresa.executa(req, resp);
    	}
    	
    	if(nome.contains("forward:")) {
    		RequestDispatcher rd = req.getRequestDispatcher(nome.replace("forward:", ""));
    		rd.forward(req, resp);
    	} else {
    		resp.sendRedirect(nome.replace("redirect:", ""));
    	}
    }

}
