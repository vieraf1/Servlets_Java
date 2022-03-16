package br.com.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.domain.Banco;
import br.com.gerenciador.domain.Usuario;

public class Login implements Acao {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Banco banco = new Banco();
		
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");
		
		System.out.println("Logando: " + login);
		
		Usuario usuario = banco.validarUsuario(login, senha);
		
		if(usuario != null) {
			System.out.println("usuario existe");
			return "redirect:entrada?acao=ListaEmpresas";
		}
		
		return "redirect:entrada?acao=LoginForm";
	}

}
