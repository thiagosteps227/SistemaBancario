<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sistema Bancario</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body style="background-color: tomato; height:100%; width:100%;">
	
	<div style="height: 100%; width: 100%; float: center; text-align: center">
		<h1 style="text-align:center; color: black">Cadastro de Usuário:</h1>
		
		<form action="<%= request.getContextPath() %>/register" method="post">
	
			Nome: <input type="text" name = "nome" placeholder="Escreva seu nome aqui"
			style="margin: 5px;"><br>
		
			Tipo de Pessoa(Física ou Jurídica) : <input type="text" name="tipoPessoa" 
			placeholder="PF ou PJ"><br>
		
			Número do Documento: <input type="text" name="numDoc" 
			placeholder="CPF/CNPJ somente números" maxlength=14; style="margin: 5px;"><br>
			
			Score: <input type="text" name="score"
			 style="margin: 5px;"><br>
			 
			Agência: <input type="text" name="agencia"
			style="margin: 5px;"><br>
			
			
		<input type="submit" value="Cadastrar!" >
	
		</form>
		
		<form action="<%= request.getContextPath() %>/register" method="get">
			
			<input type="hidden" name="formType" value="usuario">
			<input type="submit" value="Ver Usuários cadastrados" style="margin: 5px;" >
	
		</form>
		
		<form action="<%= request.getContextPath() %>/register" method="get">
			<input type="hidden" name="formType" value="conta">
			
			<input type="submit" value="Ver Contas" style="margin: 5px;" >
	
		</form>
		
		
	</div>
		
	
</body>
</html>
