<%-- 
    Document   : listarProduto
    Created on : 8 de mar de 2021, 14:23:24
    Author     : marce
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Lista de Produtos</h1>
        
         <table>
            <thead>
            <th>Nome</th>
            <th>NomeExtenso</th>
            <th>Qtd Estrela</th>
            <th>Qtd Estoque</th>
            <th>Preço</th>
            <th>Status</th>
            <!--<th>Status2</th>-->
            </thead>
            <tbody>
                <c:forEach var="produto" items="${listaProdutos}">
                    <tr>                        
                        <td>${produto.nome}</td>
                        <td>${produto.nomeExtenso}</td>
                        <td>${produto.qtdEstrela}</td>
                        <td>${produto.qtdEstoque}</td>
                        <td>${produto.preco}</td>
                        <td>${produto.status}</td>
                        <!--<td>dolar aqui{produto.statusAlt}</td>-->
                        
                        <td><a href="AlterarProduto?nome=${produto.nome}">Alterar</a></td>
                        <td><a href="CadastrarImagem?nome=${produto.nome}">Imagem teste</a></td>
                        <!--<td><a href="ExcluirProduto?nome"dolar aqui{produto.nome}">Excluir</a></td>--> 
                        <td><a href="AtivarProduto?nome=${produto.nome}">Ativar ou Reativar</a></td> 
                                               
                    </tr>
                    </c:forEach>   
                    
            </tbody>
        </table>
        <br/>
        <a href="index.jsp">Voltar</a>
    </body>
</html>
