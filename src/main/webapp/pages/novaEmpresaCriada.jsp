<%
 String nomeEmpresa = (String)request.getAttribute("nomeEmpresa");
%>

<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Gerenciador de Empresa</title>
	</head>
	<body>
		Empresa <%= nomeEmpresa %> cadastrada com sucesso!
	</body>
</html>