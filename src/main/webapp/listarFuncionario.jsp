<%-- 
    Document   : listarFuncionario
    Created on : 27 de abr de 2021, 16:48:06
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
        <h1>Lista de Funcionários</h1>
        (nome,senha,tipo,email,status);

        <table>
            <thead>
            <th>Nome</th>
            <th>tipo</th>
            <th>email</th>
            <!--so 3 por enquanto-->
<!--            <th>Qtd Estoque</th>
            <th>Preço</th>
            <th>Status</th>-->
            <!--<th>Status2</th>-->
        </thead>
        <tbody>
            <!--alterar var e items-->
            <c:forEach var="funcionario" items="${listaFuncionarios}">
                <tr>                        
                    <td>${funcionario.nome}</td>
                    <td>${funcionario.tipo}</td>
                    <td>${funcionario.email}</td>                    
                    <!--<td>dolar aqui{produto.statusAlt}</td>-->

                    <!--tentar fazer sem esse interrogacao-->
                    <!--apenas teste para jsp criar servlet-->
                    <td><a href="AlterarFuncionario?nome=${funcionario.nome}">Alterar</a></td>
                    <!--<td><a href="CadastrarImagem?nome=dolar{produto.nome}">Imagem teste</a></td>-->
                    <!--<td><a href="ExcluirProduto?nome"dolar aqui{produto.nome}">Excluir</a></td>--> 
                    <!--primeiro parametro via get usar ? segundo em diante usar &-->
                    <td><a href="AtivarFuncionario?email=${funcionario.email}&nome=${funcionario.nome}">Ativar ou Reativar</a></td> 
                    

                </tr>
            </c:forEach>   

        </tbody>
    </table>
    <br/>
    <a href="indexAdministrador.jsp">Voltar</a>
</body>
</html>
