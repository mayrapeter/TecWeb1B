<!DOCTYPE html>
<%@ page import="java.util.*,mvc.controller.*, mvc.model.*" %>
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
		<h3>Alterar nota</h3>
		<form action="AlterarNotaAgora" method="post"> 
			Nota: <input type="text" name="nova_nota" value="<%=session.getAttribute("conteudo")%>"> 
			<br>
			<input type="submit" name="alterar" value="Alterar">
		</form>
	</div>	
	
		
		
	</body>
</html>