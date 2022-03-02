<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 	pageEncoding="ISO-8859-1" %>
<%@ page import="java.util.List, br.com.gerenciador.domain.Empresa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Gerenciador de Empresa</title>
	</head>
	<body>
		Lista de Empresas: <br/>
		
		<ul>
			<c:forEach items="${empresas}" var="empresa">
				<li>${empresa.nome}</li>
			</c:forEach>
		</ul>
	</body>
</html>