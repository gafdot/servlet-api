<%@page import="java.util.List"%>
<%@page import="br.com.guigas.gerenciador.modelo.Empresa"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Java Standard Taglib</title>
</head>
<body>
	
	Usuário logado : ${usuarioLogado.login}
	<c:import url="logout-parcial.jsp"/>

	<c:if test="${ not empty empresa }">
		Cadastrando nova empresa ${empresa} com data de abertura ${data }!
	</c:if>
	
	Lista de Empresas: <br />
	<ul>
		<c:forEach items="${listaEmpresas}" var="empresa">
			<li>
				${empresa.nome } - ${empresa.dataAbertura }
				<a href="<c:url value="/entrada?acao=MostraEmpresa&id=${empresa.id }"/>" >editar</a> 
				<a href="<c:url value="/entrada?acao=RemoveEmpresa&id=${empresa.id }"/>" >remover</a> 
			</li>
		</c:forEach>
	</ul>
	<a href="<c:url value="/entrada?acao=NovaEmpresaForm"/>" >Criar nova empresa</a> 
</body>
</html>