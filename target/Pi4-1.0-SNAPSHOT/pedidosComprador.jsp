<%-- 
    Document   : pedidosComprador
    Created on : 26 de mai de 2021, 15:30:02
    Author     : marce
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Meus Pedidos ${nome}</h1>

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
                <!--nome eh o email do comprapdor usado para retornar depois-->
                <!--<td><a href="VisualizarDetalhesPedido?numeroOrdem=${pedido.numeroOrdem}">Visualizar Pedido</a></td>-->                
                <td><a href="VisualizarDetalhesPedido?numeroOrdem=${pedido.numeroOrdem}&email=${nome}">Visualizar Pedido</a></td>            

            </tr>
        </c:forEach>   

    </tbody>
</table>
<br/>
<a href="RetornarPPLogado?nome=${nome}">Voltar</a>
</body>
</html>
