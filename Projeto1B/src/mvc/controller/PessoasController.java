package mvc.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import mvc.model.*;

@Controller
public class PessoasController {
	
	@RequestMapping("IrParaCadastro")
	public String irParaCadastro() {
		return "cadastro";
		
	}
	
	@RequestMapping(value="Register", method=RequestMethod.POST)
	public String register(Pessoas pessoa, @RequestParam (name = "confirmarSenha") String confirmarSenha, HttpSession session) throws SQLException {
		String nome = pessoa.getUsuario();
		String senha = pessoa.getSenha();
		if (senha.equalsIgnoreCase(confirmarSenha)) {
			PessoasDAO dao = new PessoasDAO();
			dao.register(pessoa);
			dao.close();
			int id = dao.getID(pessoa);
	        session.setAttribute("nome",nome); 
	        session.setAttribute("id",id); 
			return "notas";
		} else {
			return "errosenha";
		}
	}
	
	@RequestMapping(value="Login", method=RequestMethod.POST)
	public String login(Pessoas pessoa, HttpSession session) throws SQLException {
		PessoasDAO dao = new PessoasDAO();
		dao.login(pessoa);
		dao.close();
		int id = dao.getID(pessoa);
		String nome = pessoa.getUsuario();
        session.setAttribute("nome",nome); 
        session.setAttribute("id",id);
		return "notas";
	}

}
