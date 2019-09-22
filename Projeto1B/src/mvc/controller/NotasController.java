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
	public String vaiParaAlterar(@RequestParam (name = "id_autor") String id_autor, @RequestParam (name = "nome_autor") String nome_autor, @RequestParam (name = "nota") String nota, HttpSession session) throws SQLException {
		session.setAttribute("id_autor", id_autor);
		session.setAttribute("nome_autor", nome_autor);
		session.setAttribute("nota", nota);
		return "alterar";
		}

	@RequestMapping("AlterarNotaAgora")
	public String alterarNota(@RequestParam (name = "nova_nota") String nova_nota, HttpSession session) throws SQLException {
		NotasDAO dao = new NotasDAO();
		int id_autor = (int)session.getAttribute("id_autor"); 
		String nome_autor = (String)session.getAttribute("nome_autor");
		String nota = (String)session.getAttribute("nota");
		dao.alterarNota(id_autor, nome_autor, nota, nova_nota) ;
		return "notas";
		}
	
}	


