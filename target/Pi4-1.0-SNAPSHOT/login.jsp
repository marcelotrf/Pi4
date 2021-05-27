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
            <!--teste caso precise nao ser email-->
            <!--            <p>Nome do Produto</p>
                        <input name="nome"/><br/>-->
            <p>Email</p>
            <input type="email" name="email"/><br/>
            <p>Senha</p>
            <input type="password" name="senha"/><br/>   <br/>          
            <!--<button type="submit">Cancelar</button>-->
            <button type="submit">Logar</button><br/> 
        </form>
        <br/> 
        <a href="cadastrarUsuario.jsp" class="btn btn-primary">Cadastrar</a> <br/> <br/> 
        <a href="PaginaPrincipal" class="btn btn-primary" style="margin-top: 100px;">voltar para pagina principal</a><br/> <br/> 
        
    </body>
</html>
