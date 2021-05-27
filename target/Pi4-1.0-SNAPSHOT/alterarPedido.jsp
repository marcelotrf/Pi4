<%-- 
    Document   : alterarPedido
    Created on : 26 de mai de 2021, 12:09:38
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
        <h1>Alterar Status da Ordem</h1>

        <table>
            <thead>            
            <th>Valor Total</th>
            <th>Status</th>            
        </thead>
        <tbody>
            <c:forEach var="pedido" items="${listaOrdem}">
                <tr>                        
                    <td>${pedido.valorTotal}</td>                
                    <td>${pedido.statusOrdem}</td>
                </tr>
            </c:forEach>   

        </tbody>
    </table>
    <br/>

    <form action="AlterarStatusPedido" method="POST">
        <label>Alterar Status da ordem ${numeroOrdem} </label>
        <select name="statusOrdem">
            <option value="valor1" selected>${statusOrdem}</option>
            <option value="Aguardando pagamento" >Aguardando pagamento</option>
            <option value="Pagamento rejeitado">Pagamento rejeitado</option>  
            <option value="Pagamento com sucesso">Pagamento com sucesso</option>  
            <option value="Aguardando retirada">Aguardando retirada</option>  
            <option value="Em trânsito">Em trânsito</option>  
            <option value="Entregue">Entregue</option>  
            <!--<option value="Itivo">Inativo2</option>-->  
        </select> 
            <!--pegar valor do numero da ordem-->
            <input type="text" name="numeroOrdem" value="${numeroOrdem}" hidden/><br/>
            <button type="submit">Alterar</button>  
    </form>
    <a href="indexEstoquista.jsp">Voltar</a>

</body>
</html>
