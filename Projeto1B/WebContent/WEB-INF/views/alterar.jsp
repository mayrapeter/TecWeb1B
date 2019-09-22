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
<body>
	
	<div class="cadastrinho">
		<h3>Alterar nota</h3>
		<form action="AlterarNotaAgora" method="post"> 
			Nota: <input type="text" name="nova_nota" value="<%=session.getAttribute("nota")%>"> 
			<br>
			<input type="submit" name="alterar" value="Alterar">
		</form>
	</div>	
	
		
		
	</body>
</html>