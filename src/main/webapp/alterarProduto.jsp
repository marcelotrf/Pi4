<%-- 
    Document   : alterarProduto
    Created on : 8 de mar de 2021, 15:30:24
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
        <h1>Tela do produto ${produto.nome}</h1>
        <form action="AlterarProduto" method="POST">
            <p>Nome</p>
            <input name="nome" value="${produto.nome}" readonly="true"/><br/>
            <p>NomeExtenso</p>
            <input name="nomeExtenso" value="${produto.nomeExtenso}"/><br/>
            <p>qtdEstoque</p>
            <input name="qtdEstoque" value="${produto.qtdEstoque}"/><br/>            
            <!--alternativa para mosrtar cpf original,colocar $ e retirar tru em cima-->
             <!--<input name="cpfOriginal" value="{cliente.cpf}" hiden="true"/><br/>-->            
            <label>Status </label>
             <select name="status">                 
                 <option value="${produto.status}" selected>${produto.status}</option>                
             </select>
            
            <button type="submit">Enviar</button>
        </form>
        <br/>
        <a href="ListarProduto">Voltar</a>
    </body>
</html>
