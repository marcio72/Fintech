<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Editar Cadastro</title>
</head>
<body>



    <form action="?" method="post">
        <%-- Use EL para obter os valores do objeto Usuario --%>
        <%-- Certifique-se de que os nomes dos atributos correspondam aos da sua classe Usuario --%>
        <label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome" value="${usuario.nomUsuario}" >
        <br>
        <br>

        <label for="sobrenome">Sobrenome:</label>
        <input type="text" id="sobrenome" name="sobrenome" value="${usuario.sobreNome}" >
        <br>
        <br>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" value="${usuario.cpf}" >
        <br>
        <br>

        <label for="telefone">Telefone:</label>
        <input type="text" id="telefone" name="telefone" value="${usuario.rg}" >
        <br>
        <br>

        <input type="submit" value="Atualizar">
    </form>
</body>
</html>
