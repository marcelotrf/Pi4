<%-- 
    Document   : login
    Created on : 23 de mar de 2021, 18:47:14
    Author     : marce
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="LoginUsuario"method="POST">           
            <p>Nome do Produto</p>
            <input name="nome"/><br/>
            <p>Nome Extenso0</p>
            <input name="senha"/><br/>            
            <button type="submit">Cancelar</button>
            <button type="submit">Cadastrar ir Imagens</button>
        </form>
    </body>
</html>
