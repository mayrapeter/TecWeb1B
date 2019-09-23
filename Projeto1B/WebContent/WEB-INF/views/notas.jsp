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

<style>
.cadastrinho {
	border-radius: 5px;
	background-color: lightblue;
	text-align: center;
	width: 400px;
	position: sticky;
	padding-bottom: 50px;
}

body {
  font-family: "Verdana", Times, Sans-serif;
}

.listinha {
	border-radius: 5px;
	background-color: lightgrey;
	width: 300px;
	margin-bottom: 10px;
	margin-top: 5px;
	margin-left: 5px;
	display: block;
} 

.nota {
	font-size: 17px;
	text-align: left;
}

.autor {
	font-size: 10px;
}

   
</style>

<body>

	<div class="cadastrinho">
		<h3>Cadastrar nova nota</h3>
		<form action="AdicionarNota" method="post"> 
			<input type="hidden" name="id_autor"  value="<%=session.getAttribute("id")%>"> 
	        <input type="hidden" name="autor" value="<%=session.getAttribute("nome")%>"> 
			Nota: <input type="text" name="conteudo"> 
			<input type="submit" name="cadastro">
			<br>
		</form>
	</div>	
	
	<div class="notas">
		<% NotasDAO dao = new NotasDAO();
 			List<Notas> notas = dao.getLista();
 			for (Notas nota : notas ) { %>
 			<div class="listinha">
	 			<article class="conteudo"><%=nota.getConteudo()%></article>
				<footer class="autor">Autor: <%=nota.getAutor()%></footer>
				<footer class="autor">ID: <%=nota.getId_autor()%></footer>	
				<form action="ApagarNota" method="post"> 
					<input type="hidden" name="id_autor"  value="<%=nota.getId_autor()%>"> 
			        <input type="hidden" name="autor" value="<%=nota.getAutor()%>"> 
					<input type="hidden" name="conteudo" value="<%=nota.getConteudo()%>"> 
					<input type="submit" name="apagar" value="Apagar">
				</form>
				
				<form action="AlterarNota" method="post"> 
					<input type="hidden" name="id_autor"  value="<%=nota.getId_autor()%>"> 
					
			        <input type="hidden" name="autor" value="<%=nota.getAutor()%>">  
					
					<input type="hidden" name="conteudo" value="<%=nota.getConteudo()%>"> 
				
					<input type="submit" name="alterar" value="Alterar">
				</form>
				
			
			</div>
			<% } %>
	
	</div>
		
		
	</body>
</html>