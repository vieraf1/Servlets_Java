<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada" var="servlet" />
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
 		<title>Cadastro de empresas</title>
	</head>
	<body>
		<c:import url="logout_parcial.jsp"/>
	
		<form action="${servlet}" method="post">
			
			Nome: <input type="text" name="nome"/>
			<br/>
			Data de Abertura: <input type="text" name="data"/>
			<input type="hidden" name="acao" value="NovaEmpresa"/>
			<input type="submit"/>
		</form>
	</body>
</html>