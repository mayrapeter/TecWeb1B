package mvc.controller;


import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mvc.model.*;

@Controller
public class NotasController {
	@RequestMapping("AdicionarNota")
	public String addNota(Notas nota) throws SQLException {
		NotasDAO dao = new NotasDAO();
		dao.addNota(nota);
		return "notas";
		}

	@RequestMapping("ApagarNota")
	public String apagarNota(Notas nota) throws SQLException {
		NotasDAO dao = new NotasDAO();
		dao.apagarNota(nota);
		return "notas";
		}
	
	@RequestMapping("AlterarNota")
	public String vaiParaAlterar(@RequestParam (name = "id_autor") String id_autor, @RequestParam (name = "autor") String autor, @RequestParam (name = "conteudo") String conteudo, HttpSession session) throws SQLException {
		session.setAttribute("id_autor", id_autor);
		session.setAttribute("autor", autor);
		session.setAttribute("conteudo", conteudo);
		return "alterar";
		}

	@RequestMapping("AlterarNotaAgora")
	public String alterarNota(@RequestParam (name = "nova_nota") String nova_nota, HttpSession session) throws SQLException {
		NotasDAO dao = new NotasDAO();
		String id_autor_string = (String)session.getAttribute("id_autor"); 
		System.out.println(id_autor_string);
		int id_autor = Integer.valueOf(id_autor_string);
		String autor = (String)session.getAttribute("autor");
		String conteudo = (String)session.getAttribute("conteudo");
		dao.alterarNota(id_autor, autor, conteudo, nova_nota) ;
		return "notas";
		}
	
}	


