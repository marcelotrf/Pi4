<%-- 
    Document   : index
    Created on : 8 de mar de 2021, 14:20:32
    Author     : marce
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu</title>
    </head>
    <body>
        <h1>Menu</h1>
        <!--redirecionar para o servelet assim mostra na tela-->
        <a href="ListarProduto">Listar Produtos</a><br/>
        <a href="cadastrarProduto.jsp">Cadastrar Produto</a><br/>
        <a href="login.jsp">Login</a>
        <a href="PaginaPrincipal">PaginaPrincipal</a>
        
         
            <a href="CadastrarImagem?nome=${nome}">Cadastrar ir Imagens correto ${nome}</a><br/><br/>
            <!--<a href="CadastrarImagem?nome=${produto.nome}">Imagem teste</a>-->
            
    </body>
</html>
