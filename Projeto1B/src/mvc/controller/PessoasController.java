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
	
	@RequestMapping("/")
	public String login() {
		return "index";
		
	}
	
	@RequestMapping("IrParaCadastro")
	public String irParaCadastro() {
		return "cadastro";
		
	}
	
	@RequestMapping(value="Register", method=RequestMethod.POST)
	public String register(Pessoas pessoa, @RequestParam (name = "confirmarSenha") String confirmarSenha, HttpSession session) throws SQLException {
		String nome = pessoa.getNome();
		String senha = pessoa.getSenha();
		System.out.println(senha);
		if (senha.equalsIgnoreCase(confirmarSenha)) {
			PessoasDAO dao = new PessoasDAO();
			dao.register(pessoa);
			int id = dao.getID(pessoa);
			dao.close();
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
		int id = dao.getID(pessoa);
		dao.close();
		String nome = pessoa.getNome();
        session.setAttribute("nome",nome); 
        session.setAttribute("id",id);
		return "notas";
	}

}
