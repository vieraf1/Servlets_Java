<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/novaEmpresa" var="servlet" />
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
 		<title>Cadastro de empresas</title>
	</head>
	<body>
		<form action="${servlet}" method="post">
			
			Nome: <input type="text" name="nome"/>
			
			<input type="submit"/>
		</form>
	</body>
</html>