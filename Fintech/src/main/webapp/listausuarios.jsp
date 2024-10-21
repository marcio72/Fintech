<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri ="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>

<link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Catamaran:wght@300&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
  <link rel="stylesheet" href="assets/css/styles.css">
  <link rel="stylesheet" href="assets/css/bootstrap.css">
<meta charset="ISO-8859-1">
<title>Lista Usuarios</title>

</head>

<body>
<div class="my-4 px-4"  >
            <h2>Lista de Usuarios</h2>
            <table id="resumo" class="table table-striped">
                <thead class="table-success">
                    <tr id="cabecalho">
                        <th class="Codigo">I.D.</th>
                        <th class="Nome">Nome</th>
                        <th class="Sobrenome">Sobrenome</th>
                        <th class="Telefone">Telefone</th>  
                  <!-- <th class="Cpf">C.P.F.</th>  -->
                  <!--  <th class="Apelido">Apelido</th> -->           
                        <th class="Email">Email</th>
                 <!--   <th class="RG">RG</th> -->
                        
                    </tr>
                </thead>
                
                <tbody class="historico"> 
                <c:forEach items="${listaUsuario}" var="lista"> 
                <tr>
                	<td>${lista.codPess} </td>
                	<td>${lista.nomUsuario} </td>
                	<td>${lista.sobreNome}</td>
                	<td>${lista.email} </td>
                <!-- <td>${lista.pre} </td>-->
                <!--  <td>${lista.telef}</td> -->
                	<td>${lista.cpf} </td>
               <!--<td>${lista.rg} </td> -->
               
                	<td> <a href="EditarCadastro?id=${lista.codPess}" class="btn btn-primary">Editar </a></td>
                	<td> <a href="" class="btn btn-danger">Excluir </a></td>
                	
                	
                </tr> 
                </c:forEach>          
                </tbody>
            </table>
        <a href="NovoUsuario">Cadastro de Usuario</a> 
        </div>

</body>

</html>