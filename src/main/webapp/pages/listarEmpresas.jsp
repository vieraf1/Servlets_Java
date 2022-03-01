<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 	pageEncoding="ISO-8859-1" %>
<%@ page import="java.util.List, br.com.gerenciador.domain.Empresa" %>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Gerenciador de Empresa</title>
	</head>
	<body>
		Lista de Empresas: <br/>
		<ul>
		<% 
			for(Empresa empresa : (List<Empresa>)request.getAttribute("empresas")) {
		%>
			<li><%= empresa.getNome()%></li>
		<%
			}
		%>
		</ul>
	</body>
</html>