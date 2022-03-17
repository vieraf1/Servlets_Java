package br.com.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.gerenciador.domain.Banco;
import br.com.gerenciador.domain.Usuario;

public class Login implements Acao {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Banco banco = new Banco();
		
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");
		
		Usuario usuario = banco.validarUsuario(login, senha);
		
		if(usuario != null) {
			HttpSession sessao = req.getSession();
			sessao.setAttribute("usuarioLogado", usuario);
			return "redirect:entrada?acao=ListaEmpresas";
		}
		
		return "redirect:entrada?acao=LoginForm";
	}

}
