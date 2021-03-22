<%-- 
    Document   : cadastrarProduto
    Created on : 6 de mar de 2021, 10:13:06
    Author     : marce
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Castrar Produto</title>
    </head>
    <body>
        <h1>Cadastro de Produto</h1>
        <form action="CadastrarProduto"method="POST">           
            <p>Nome do Produto</p>
            <input name="nome"/><br/>
            <p>Nome Extenso</p>
            <input name="nomeExtenso"/><br/>
            <p>Qtd Estrelas</p>
            <input name="qtdEstrela"/><br/>
            <br/>
            <label>Status </label>
            <select name="status">
                <option value="valor1" selected>Status</option>
                <option value="Ativo" >Ativo</option>
                <option value="Inativo">Inativo</option>  
                <!--<option value="Itivo">Inativo2</option>-->  
            </select>            
            <p>Qtd Estoque</p>
            <input name="qtdEstoque"/><br/>
            <p>Preço</p>
            <input name="preco"/><br/>
            <br/>
            <button type="submit">Cancelar</button>
            <button type="submit">Cadastrar ir Imagens</button>
        </form>
    </body>
</html>
