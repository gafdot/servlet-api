<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url value="/entrada" var="linkNovaEmpresa"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nova Empresa</title>
</head>
<body>
	<c:import url="logout-parcial.jsp"/>
	<form action="${linkNovaEmpresa}" method="post">
		Nome: <input type="text" name="nome">
		Data: <input type="text" name="data"> <input type="submit">
		<input type="hidden" name="acao" value="NovaEmpresa"/>
	</form>
</body>
</html>