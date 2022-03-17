<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 	pageEncoding="ISO-8859-1" %>
<%@ page import="java.util.List, br.com.gerenciador.domain.Empresa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Gerenciador de Empresa</title>
	</head>
	<body>
		<c:if test="${not empty usuarioLogado.login}">
			Usuario Logado: ${usuarioLogado.login}
			<br/>
			<br/>
		</c:if>
	
		<c:if test="${not empty nomeEmpresa}">
			Empresa ${nomeEmpresa} cadastrada com sucesso!
			<br/>
			<br/>
		</c:if>
		
		Lista de Empresas: <br/>
		
		<ul>
			<c:forEach items="${empresas}" var="empresa">
				<li>${empresa.nome} - 
				    <f:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>
				    <a href="/gerenciador/entrada?acao=MostraEmpresa&id=${empresa.id}">editar</a>
				    <a href="/gerenciador/entrada?acao=RemoveEmpresa&id=${empresa.id}">remover</a>
				</li>
			</c:forEach>
		</ul>
	</body>
</html>