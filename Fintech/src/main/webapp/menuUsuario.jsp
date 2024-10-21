<%@ page language ="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.text.NumberFormat" %>
<%@ page import="java.util.Locale" %>

<html lang="pt-BR">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Projeto Fintech</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />

    <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Catamaran:wght@300&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="./css/styles.css">
  </head>

  <body>
 		 
    <div class="container my-3 fixed-top">

      <nav class="navbar navbar-expand-lg bg-dark  text-light" data-bs-theme="dark">

        <div class="container-fluid">
          <a class="navbar-brand" href="#">FINTECH</a>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
              <li class="nav-item">
                <a class="nav-link" aria-current="page" href="#">Principal</a>
              </li>
        
              <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                  Cadastro
                </a>
                <ul class="dropdown-menu">
                  <li><a class="dropdown-item" href="ReceitaServlet" method="get">Receitas</a></li>
                  <li><hr class="dropdown-divider"></li>
                  <li><a class="dropdown-item" href="DespesaServlet" method="get">Despesas</a></li>
                  <li><hr class="dropdown-divider"></li>
                  <li><a class="dropdown-item" href="#">Categorias</a></li>
                </ul>
              </li>

              <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                  Informações
                </a>
                <ul class="dropdown-menu">
                  <li><a class="dropdown-item" href="#">Receitas</a></li>
                  <li><hr class="dropdown-divider"></li>
                  <li><a class="dropdown-item" href="#">Despesas</a></li>
                </ul>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">Planejamentos</a>
              </li>

            </ul>
          </div>
        </div>
      </nav>
    </div>


    <div class="container1">
      <div class="box">
        <div id="sald" class="boxer">
          <h2 class="boxerh2sald" name="boxerh2sald">R$ 50.000,00</h2>
          <h3>Balanço</h3>
          <p>Lorem ipsum dolor sit amet, conse`ctetur adipisicing elit. Numquam, nemo.</p>
          <a href="" class="btn1"> Mais Informações</a>

        </div>
        
      </div>
      <div  class="box">
        <div id="rec" class="boxer">
          <h2 class="boxerh2receita" name="boxerh2receita">R$ 75.000,00</h2>
          <h3>Receitas</h3>
          <p>Todas as Receitas estão divididas por categorias, pressione o botão Mais Informações para visualizar todos os dados.</p>
          <i class="fa-solid fa-caret-down fa-rotate-180" style="color: #3aec09"></i>
          <a href="ReceitaListaServlet" method="get" class="btn1">Mais Informações</a>
        </div>
        <div id="desp" class="boxer">
          <h2 class="boxerh2despesa" name="boxerh2despesa">R$ 25.000,00</h2>
          <h3>Despesas</h3>
          <p>Todas as Despesas estão divididas por categorias, pressione o botão Mais Informações para visualizar todos os dados.</p>
          <a href="DespesaListaServlet" method="get"  method="get" class="btn1">Mais Informações</a>
          <i class="fa-solid fa-caret-down" style="color: #c10606;"></i>
        </div>
      </div>
  </div>

    

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>

  </body>
</html>


