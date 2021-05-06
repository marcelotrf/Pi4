<%-- 
    Document   : cadastrarUsuario
    Created on : 18 de abr de 2021, 18:48:16
    Author     : marce
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Primeiro Cadastro</h1>
        <h1>Cadastro</h1>
        <form action="CadastrarComprador"method="POST">
            <p>Nome</p>
            <input name="nome"/><br/>
            <p>Email</p>
            <input name="email"/><br/>
            <p>CPF</p>
            <input name="cpf"/><br/>
            <p>Senha</p>
            <input name="senha"/><br/>

            <button type="submit">Enviar</button>
        </form>
    </body>
</html>
