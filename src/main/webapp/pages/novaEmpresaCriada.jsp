<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Gerenciador de Empresa</title>
	</head>
	<body>
		<c:if test="${not empty nomeEmpresa}">
			Empresa ${nomeEmpresa} cadastrada com sucesso!
		</c:if>
		
		<c:if test="${empty nomeEmpresa}">
			Nome da Empresa não informado!
		</c:if>
	</body>
</html>