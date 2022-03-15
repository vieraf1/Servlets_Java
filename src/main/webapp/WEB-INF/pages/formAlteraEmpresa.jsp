<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<c:url value="/entrada" var="servlet" />
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
 		<title>Cadastro de empresas</title>
	</head>
	<body>
		<form action="${servlet}" method="post">
			
			Nome: <input type="text" name="nome" value="${empresa.nome}"/>
			<br/>
			Data de Abertura: <input type="text" name="data" value="<f:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>"/>
			<input type="hidden" name="id" value="${empresa.id}"/>
			<input type="hidden" name="acao" value="AlteraEmpresa"/>
			<input type="submit"/>
		</form>
	</body>
</html>