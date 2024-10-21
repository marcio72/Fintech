<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Cadastro Usuario</title>


<link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Catamaran:wght@300&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
  <link rel="stylesheet" href="assets/css/styles.css">
  <link rel="stylesheet" href="assets/css/bootstrap.css">
</head>
<body>
<h1> Cadastro de Usuario</h1>



<form class="dados" id="dados" method="post" action="NovoUsuario">
            <div class="row mb-3  px-4">

                <div class="col-md-12 my-3">
                    <label for="nome" class="form-label">Nome</label>
                    <input type="text" class="form-control" id="descricao" name="nome" placeholder="ex: Joao"
                        >
                </div>

                <div class="col-md-4  my-3">
                    <label for="sobrenome" class="form-label">Sobrenome</label>
                    <input type="text" class="form-control" id="sobrenome" name="valor"
                        placeholder="ex.: Junqueira" >
                </div>

                <div class="col-md-4  my-3">
                    <label for="email" class="form-label">E-mail</label>
                    <input type="email" class="form-control" id="email" name="email"
                     placeholder="ex.: joaojunqueira@fintech.com">
                </div>

                <div class="col-md-4  my-3">
                    <label for="dataCadastro" class="form-label">Telefone</label>
                    <input type="text" class="form-control" id="telefone" name="telefone">
                </div>
                
                </div>
            </div>
            <div class="d-flex justify-content-end mt-3  px-4">
                <button type="submit" class="btn btn-primary">Confirmar</button> 
                <a href="#" class="btn btn-success">Retorna</a></button>
                
            </div>
        </form>

</body>
</html>