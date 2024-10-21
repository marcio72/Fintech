<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.text.NumberFormat" %>
<%@ page import="java.util.Locale" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>

<link href="https://fonts.googleapis.com/css2?family=Catamaran:wght@300&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
        <link rel="stylesheet" href="./css/styles.css">

</head>
<body>

    <div class="container1  mt-5">
        <div class="col-md-6"> 
            <h1> Finatech </h1>

            <img src="image/finance-app-isometric.svg"  class="col-md-12 float-md-end mb-6 ms-md-6" alt="">
        </div>
          
    
        <div  class="col-md-6"> 
            <h1 > Conta </h1>

            <form class="dados" id="dados" method="post" action="Login">

                <div class="row align-items-center" >
    
                    <div class="col-md-12 float-md-end mb-6 ms-md-6">
                        <label for="descricao" class="form-label">Email</label>
                        <input type="email" class="form-control" id="email" name="email" placeholder="ex: seuemail@fintech.com"
                            required autofocus>

                    </div>
                    
                        <div class="col-md-8  my-4">
                            <label for="valor" class="form-label">Senha</label>
                            <input type="password" class="form-control" id="valor" name="senha">
                          
                            <button type="submit" class="btn btn-outline-primary btn-sm">Acesso</button> 
                        </div>

                        <a href="Criar Conta Fintech"> Criar Conta Fintech </a>

                </div>
            </form>
        </div>
          
          
        
    </div>
  

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    
    
</body>
</html>