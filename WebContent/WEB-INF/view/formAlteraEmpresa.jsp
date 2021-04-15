<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:url value="/entrada" var="linkAlteraEmpresa"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:import url="logout-parcial.jsp"/>
	<form action="${linkAlteraEmpresa}" method="post">
		Nome: <input type="text" name="nome" value="${empresa.nome }"/>
		Data: <input type="text" name="data" value="${empresa.dataAbertura }"> <input type="submit"/>
		<input type="hidden" name="id" value="${empresa.id }"/>
		<input type="hidden" name="acao" value="AlteraEmpresa"/>
	</form>
</body>
</html>