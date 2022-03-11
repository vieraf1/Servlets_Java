package br.com.gerenciador.servlet;

import java.io.IOException;

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
    	
    	if(acao.equals("listarEmpresas")) {
    		ListaEmpresas listaEmpresas = new ListaEmpresas();
    		listaEmpresas.executa(req, resp);
    	}
    	
    	if(acao.equals("removeEmpresa")) {
    		RemoveEmpresa removeEmpresa = new RemoveEmpresa();
    		removeEmpresa.executa(req, resp);
    	}
    	
    	if(acao.equals("mostraEmpresa")) {
    		MostraEmpresa mostraEmpresa = new MostraEmpresa();
    		mostraEmpresa.executa(req, resp);
    	}
    	
    	if(acao.equals("alteraEmpresa")) {
    		AlteraEmpresa alteraEmpresa = new AlteraEmpresa();
    		alteraEmpresa.executa(req, resp);
    	}
    	
    	if(acao.equals("novaEmpresa")) {
    		NovaEmpresa novaEmpresa = new NovaEmpresa();
    		novaEmpresa.executa(req, resp);
    	}
    }

}
