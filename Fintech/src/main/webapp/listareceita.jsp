<%@ page language ="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Lista Receita</title>


<link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Catamaran:wght@300&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
  <link rel="stylesheet" href="assets/css/styles.css">
  <link rel="stylesheet" href="assets/css/bootstrap.css">
</head>
<body>

<div class="my-8  px-4">
            <h2>Listagem Receita</h2>
            <table id="resumo" class="table table-hover text-center">
                <thead class="table-dark">
                    <tr id="cabecalho">
                    	<th class="I.D. Codigo">I.D.</th>
                        <th class="descricao">Descrição</th>
                        <th class="valor">Valor</th>
                        <th class="data-cadastro">Data do Cadastro</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody class="historico">                   
                </tbody>
                
                <tbody class="historico"> 
                <c:forEach items="${receitas}" var="lrec"> 
                <tr>
                	<td>${lrec.codRec} </td>
                	<td>${lrec.descReceita} </td>
                	<td>${lrec.valor}</td>
                	<td>${lrec.dataFin} </td>
                	<td></td>
                	
                	<td> 
             <!--   	<c:url value="receita" var="link">
                		<c:param name="acao" value="abrir-form-edicao"/>
                		<c:param name="codigo" value="${lrec.codRec}"/>
                	</c:url>
                	<a href="${link}" class="btn btn-primary">Editar </a></td> -->
                	<div class="d-flex justify-content-end mt-3"> 
                			<td> <a href="ReceitaAtualizaServlet?id=${lrec.codRec}" class="btn btn-primary">Editar </a></td>
                			<td> <a href="" class="btn btn-danger">Excluir </a></td>
                	</div>
                	
                </tr> 
                </c:forEach>          
                </tbody>
            </table>
            <a href="menuUsuario.jsp">Menu do Usuario</a> 
        </div>

</body>
</html>