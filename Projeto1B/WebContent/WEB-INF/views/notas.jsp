<!DOCTYPE html>
<%@ page import="java.util.*,mvc.model.*, mvc.controller.*" %>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page import=" javax.servlet.http.HttpSession"%>

<html>
<head>
<link rel = "stylesheet"
   type = "text/css"
   href = "notas.css" />
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="cadastrinho">
		<h3>Cadastrar nova nota</h3>
		<form action="AdicionarNota" method="post"> 
			<input type="hidden" name="id"  value="<%=session.getAttribute("id")%>"> 
	        <input type="hidden" name="nome" value="<%=session.getAttribute("nome")%>"> 
			Nota: <input type="text" name="nota"> 
			<input type="submit" name="cadastro">
			<br>
		</form>
	</div>	
	
	<div class="notas">
		<% NotasDAO dao = new NotasDAO();
 			List<Notas> notas = dao.getLista();
 			for (Notas nota : notas ) { %>
 			<div class="listinha">
	 			<article class="nota"><%=nota.getNota()%></article>
				<footer class="autor">Autor: <%=nota.getAutor()%></footer>
				<footer class="autor">ID: <%=nota.getIdAutor()%></footer>	
				<form action="ApagarNota" method="post"> 
					<input type="hidden" name="id_autor"  value="<%=nota.getIdAutor()%>"> 
			        <input type="hidden" name="nome_autor" value="<%=nota.getAutor()%>"> 
					<input type="hidden" name="nota" value="<%=nota.getNota()%>"> 
					<input type="submit" name="apagar" value="Apagar">
				</form>
				
				<form action="AlterarNota" method="post"> 
					<input type="hidden" name="id_autor"  value="<%=nota.getIdAutor()%>"> 
					
			        <input type="hidden" name="nome_autor" value="<%=nota.getAutor()%>">  
					
					<input type="hidden" name="nota" value="<%=nota.getNota()%>"> 
				
					<input type="submit" name="alterar" value="Alterar">
				</form>
				
			
			</div>
			<% } %>
	
	</div>
		
		
	</body>
</html>