<%-- 
    Document   : inativarReativarFu
    Created on : 28 de abr de 2021, 03:07:42
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
        <h1>Tela Inativar Reativar ${nome}</h1>
        <form action="AtivarFuncionario" method="POST">
<!--            <p>Nome</p>
            <input name="nome" value="dolar{nome}" readonly="true"/><br/>-->
<!--            <p>NomeExtenso</p>
            <input name="nomeExtenso" value="${produto.nomeExtenso}" readonly="true"/><br/>-->
<!--            <p>qtdEstoque</p>
            <input name="qtdEstoque" value="${produto.qtdEstoque}" readonly="true"/><br/>            -->
            <!--alternativa para mosrtar cpf original,colocar $ e retirar tru em cima-->
            <!--<input name="cpfOriginal" value="{cliente.cpf}" hiden="true"/><br/>-->  
            <p>Email</p>
            <input type="email" name="email" value="${email}" readonly="true" /><br/> 
            <p>Status</p>
            <input type="text" name="status" value="${status}" readonly="true" /><br/>
            
           

            <br/>
            <button type="submit">${statusAlternado}</button>
            <br/>
            <br/>
            <a href="ListarFuncionario">Voltar</a>
        </form>
    </body>
</html>
