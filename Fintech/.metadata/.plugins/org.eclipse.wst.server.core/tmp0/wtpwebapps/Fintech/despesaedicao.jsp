<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Receitas</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Catamaran:wght@300&display=swap" rel="stylesheet">

    <!-- link para o BootStrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
        <link rel="stylesheet" href="css/styles.css">
        
</head>

<body>
	<c:if test ="${not empty msg}">
		<div class="alert alert-success">${msg}</div>
	</c:if>
	<c:if test ="${not empty erro}">
		<div class="alert alert-danger">${erro}</div>
	</c:if>
	
    <div class="container px-4">
        <div class="bg-danger p-4 mt-3">
            <h1 class="display-4 text-light">Edicao  Despesas</h1>
        </div>

        <!--  <div class="my-4">
            <h2>Informações Digitadas</h2>
            <table id="resumo" class="table table-hover text-center">
                <thead class="table-dark">
                    <tr id="cabecalho">
                        <th class="descricao">Descrição</th>
                        <th class="valor">Valor</th>
                        <th class="data-cadastro">Data do Cadastro</th>
                        <th class="categoria">Categoria</th>
                    </tr>
                </thead>
                <tbody class="historico">                   
                </tbody>
            </table>
        </div>-->

        <h2 class="mt-4">Descrição da Despesa</h2>
        <form class="dados" id="dados" method="post" action="DespesaAtualizaSevlet">
        
            <div class="row mb-3">

                <div class="col-md-2 my-3">
                    <label for="descricao" class="form-label">Codigo</label>
                    <input type="text"   class="form-control"  id="codigo" name="codigo" value="${despesa.codDesp}">
                </div>
                <div class="col-md-10 my-3">
                    <label for="descricao" class="form-label">Descrição</label>
                    <input type="text"  class="form-control" id="descricao"  name="descricao"  value="${despesa.descDespesa}">
                </div>

                <div class="col-md-4  my-3">
                    <label for="valor" class="form-label">Valor</label>
                    <input type="number" class="form-control" id="valor"  name="valor value="${despesa.valor}>
                </div>

                <div class="col-md-4  my-3">
                    <label for="dataCadastro" class="form-label">Data do Cadastro</label>
                    <input type="text" class="form-control" id="dataCadastro"  name="dataCadastro" value="${despesa.dataFin}"pattern="\d{2}/\d{2}/\d{4}" >
                     <!-- pattern="\d{2}/\d{2}/\d{4}" -->
                </div>

               <div class="col-md-4  my-3">
                  <!--   <label for="descricao" class="form-label">Descrição</label>
                    <input type="text" class="form-control" id="categoria" name="categoria"> -->
                   
                      <label for="id-categoria" class="form-label">Categoria</label>
                      <select id="id-categoria" name="categoria" class="form-select" >
                        
                        <option value="0">Selecione</option>
                        
                        <c:forEach items="${categorias}" var="c">
                        	<option value="${c.codCateg}"> ${c.descCateg}</option> 
                        </c:forEach>
                        
                    </select>
                </div>
            </div>
            <div class="d-flex justify-content-end mt-3">
                <button type="submit" class="btn btn-success"> Atualizar </button> 
                <a href="DespesaListaServlet?acao=listar" class="btn btn-dark"> Retorna a lista </a>
                
            </div>
        </form>
    </div>
    <script src="/js/app.js"></script>
</body>

</html>