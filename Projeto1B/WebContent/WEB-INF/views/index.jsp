<!DOCTYPE html>
<html>
<head>
<link rel = "stylesheet"
   type = "text/css"
   href = "entrando.css" />
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<style>
body {
  background-color: lightblue;
  text-align: center;
  font-family: "Verdana", Times, Sans-serif;
}
   
</style>

<body>
		<h3>Bem vindo ao Projeto1!</h3>
		<div>
			<form action="Login" method="post">
				Usuário: <input type="text" name="nome"> 
				<br>
				Senha:   <input type="password" name="senha"> 
				<br>
				<input type="submit" name="login">
			</form>
		</div>
		<form action="IrParaCadastro">
				Ainda não é cadastrado? Cadastre-se!
				<br>
				<input type="submit" name="cadastrar">
			</form>	
	</body>
</html>