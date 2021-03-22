<%-- 
    Document   : inativarReativar
    Created on : 10 de mar de 2021, 20:44:27
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
        <h1>Tela Inativar Reativar ${produto.nome}</h1>
        <form action="AlterarProduto" method="POST">
            <p>Nome</p>
            <input name="nome" value="${produto.nome}" readonly="true"/><br/>
            <p>NomeExtenso</p>
            <input name="nomeExtenso" value="${produto.nomeExtenso}" readonly="true"/><br/>
            <p>qtdEstoque</p>
            <input name="qtdEstoque" value="${produto.qtdEstoque}" readonly="true"/><br/>            
            <!--alternativa para mosrtar cpf original,colocar $ e retirar tru em cima-->
             <!--<input name="cpfOriginal" value="{cliente.cpf}" hiden="true"/><br/>-->            
            <label>Status </label>
             <select name="status">                 
                 <option value="${produto.status}" selected>${produto.status}</option>                
             </select>
            
             <br/>
            <button type="submit">${produto.statusAlt}</button>
        </form>
    </body>
</html>
