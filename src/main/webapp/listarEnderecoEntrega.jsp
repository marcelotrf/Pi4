<%-- 
    Document   : listarEnderecoEntrega
    Created on : 25 de mai de 2021, 07:37:23
    Author     : marce
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Endereços de Entrega</title>
    </head>
    <body>
        <p>Endereço de Entrega ${comprador.email} </p>
    <c:forEach var="enderecoE" items="${listaEnderecoE}">
        <form action="ListarEnderecoEntrega" method="POST">   
<!--            <p>Endereço de Entrega </p>-->
            <!--dolar{enderecoE.logradouro}-->
            Cep: <input type="text" id="" name="cep" value="${enderecoE.cep}" ><br/> 
            Logradouro: <input type="text" id="logradouro" name="logradouro" value="${enderecoE.logradouro}" >
            Número: <input type="text" id="numeroL" name="numeroL" value="${enderecoE.numeroL}">
            <br/>            
            Bairo: <input type="text" id="logradouro2" name="texto3" readonly="true" value="${enderecoE.bairro}"><br/>           

            Localidade: <input type="text" id="logradouro5" name="texto4" disabled value="${enderecoE.cidade}"><br/>
            UF: <input type="text" id="logradouro6" name="texto5" disabled value="${enderecoE.uf}"><br/>
            <button type="submit" class="btn btn-outline-danger border-dark btn-sm">Escolher Endereço Entrega</button>
            <br/> 
            <br/>            
            <!--dolar{enderecoE.uf}-->
            <input type="email" name="email" value="${comprador.email}" hidden/><br/>
            <!--<a href="AlterarProduto?nome=dolar{produto.nome}">Escolher Endereço Entrega</a>-->
            
        </form>
    </c:forEach>
        <a href="PaginaPrincipal" class="btn btn-primary" style="margin-top: 100px;">voltar para pagina principal</a>
</body>
</html>
