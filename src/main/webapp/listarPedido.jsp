<%-- 
    Document   : listarPedido
    Created on : 26 de mai de 2021, 13:16:14
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
            <th>Numero Pedido</th>
            <th>Valor Total</th>
            <th>Status</th>
            <!--            <th>Qtd Estrela</th>
                        <th>Qtd Estoque</th>-->
<!--            <th>Preço</th>
            <th>Status</th>-->
            <!--<th>Status2</th>-->
        </thead>
        <tbody>
        <c:forEach var="pedido" items="${listaPedidos}">
            <tr>                        
                <td>${pedido.numeroOrdem}</td>
                <td>${pedido.valorTotal}</td>                
                <td>${pedido.statusOrdem}</td>
                <td>${produto.qtdEstrela}</td>
                <td>${produto.qtdEstoque}</td>
                <td>${produto.preco}</td>
                <td>${produto.status}</td>
                <!--<td>dolar aqui{produto.statusAlt}</td>-->
<!--                <td>
                    <label>Alterar Status </label>
                    <select name="status">
                        <option value="valor1" selected>${pedido.statusOrdem}</option>
                        <option value="Ativo" >Aguardando pagamento</option>
                        <option value="Inativo">Pagamento rejeitado</option>  
                        <option value="Inativo">Pagamento com sucesso</option>  
                        <option value="Inativo">Aguardando retirada</option>  
                        <option value="Inativo">Em trânsito</option>  
                        <option value="Inativo">Entregue</option>  
                        <option value="Itivo">Inativo2</option>  
                    </select>  
                </td>-->
 
                <td><a href="AlterarStatusPedido?numeroOrdem=${pedido.numeroOrdem}">Alterar Status</a></td>
                <!--<td><a href="CadastrarImagem?nome=${produto.nome}">Imagem teste</a></td>-->
                <!--<td><a href="ExcluirProduto?nome"dolar aqui{produto.nome}">Excluir</a></td>--> 
                <!--<td><a href="AtivarProduto?nome=${produto.nome}">Ativar ou Reativar</a></td>--> 

            </tr>
        </c:forEach>   

    </tbody>
</table>
<br/>
<a href="indexEstoquista.jsp">Voltar</a>
</body>
</html>
