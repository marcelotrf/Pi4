<%-- 
    Document   : cadastrarComprador
    Created on : 28 de abr de 2021, 15:51:33
    Author     : marce
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">


        <title>JSP Page</title>
    </head>
    <body>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>

        <h1>Cadastro de Pessoa</h1>
        <!--altear action-->
        <form action="AlterarComprador"method="POST">           
            <p>Nome</p>
            <input name="nome" value="${comprador.nome}"/><br/>

            <p>Email</p>
            <input type="email" name="email" value="${comprador.email}" readonly="true"/><br/>
            <p>Senha</p>
            <input type="password" name="senha"/><br/> 
            <p>Cpf</p>
            <input name="cpf" value="${comprador.cpf}" readonly="true"/><br/>
            <!--talvez nao precise-->
            <!--            <p>endereco</p>
                        <input name="endereco"/><br/>-->
            <!--comentar de teste-->
            <!--<form action="CepServlet" method="POST">-->
            <label>Endereço de Faturamento </label><br/>
            CEP: <input type="text" id="cep" ><br/>
            Logradouro: <input type="text" id="logradouro" name="logradouro" value="${comprador.logradouro}"><br/>
            Bairo: <input type="text" id="logradouro2" name="bairro" readonly="true" value="${comprador.bairro}" >
            <!--<button type="submit">Enviar</button>-->    
            <!--</form>-->
            <!--CEP: <input type="text" id="cep">-->
            <!--onlick serve para executar a funcao no script-->
            <!--<button onclick="endereco()">Obter endereço</button>-->

            <!--Logradouro: <input type="text" id="logradouro" name="texto" disabled>-->
            Complemento: <input type="text" id="logradouro4" name="texto2" disabled><br/>
            <!--Bairo: <input type="text" id="logradouro2" name="texto3" disabled>-->
            Localidade: <input type="text" id="logradouro5" name="cidade" value="${comprador.cidade}" ><br/>
            UF: <input type="text" id="logradouro6" name="uf" value="${comprador.uf}"><br/>

            <button type="submit">Cadastrar Funcionário</button><br/><br/>
            <!--lembrar de levar o nome do produto-->
            <!--            <a href="CadastrarImagens.jsp?nome=dolar{produto.nome}" class="btn btn-primary">Cadastrar oficial</a>-->
            <!--teste-->

            <!--            <a href="CadastrarImagem?nome=dolar{nome}">Cadastrar ir Imagens correto dolar{nome}</a><br/><br/>-->
            <!--<a href="CadastrarImagem?nome=dolar{nome}" class="btn btn-primary"></a>Cadastrar ir Imagens correto dolar{nome}<br/><br/>-->

            <!--<a href="CadastrarImagem?nome=dolar{produto.nome} class="btn btn-primary">Imagem teste</a>-->
            <!--fim teste-->

        </form>
        <!--testar botao fora do form-->
        <button onclick="endereco()">Obter endereço via CEP</button><br/><br/>
        <!--<button type="submit">Cadastrar Endereço de Entrega</button><br/><br/>-->

        <!--inicio teste-->
        <!--<p>Endereço de Entrega </p>-->
        <c:forEach var="enderecoE" items="${listaEnderecoE}">
        <form>   
            <p>Endereço de Entrega </p>
            <!--dolar{enderecoE.logradouro}-->
            Logradouro: <input type="text" id="logradouro" name="logradouro" value="${enderecoE.logradouro}"><br/>            
            Bairo: <input type="text" id="logradouro2" name="texto3" readonly="true" value="${enderecoE.bairro}"><br/>           
            
            Localidade: <input type="text" id="logradouro5" name="texto4" disabled value="${enderecoE.cidade}"><br/>
            UF: <input type="text" id="logradouro6" name="texto5" disabled value="${enderecoE.uf}"><br/>
            <br/> 
            <br/>            
            <!--dolar{enderecoE.uf}-->
        </form>
        </c:forEach>
        

        <!--<a href="cadastrarEEntrega.jsp" class="btn btn-primary">Adicionar Endereço de Entrega</a><br/>-->
        <!--tete-->
        <!--<a href="CadastrarEEntrega?cpf=dolar{comprador.cpf}" class="btn btn-primary">Adicionar Endereço de Entrega</a><br/>-->
        <a href="CadastrarEEntrega?email=${comprador.email}" class="btn btn-primary">Adicionar Endereço de Entrega</a><br/>

        <a href="login.jsp">Tela de Login</a>

        <script language="javascript">

            function endereco() {
                var cep = document.getElementById("cep");
                var Logradouro = document.getElementById("logradouro");
                var Complemento = document.getElementById("logradouro4");
                var Bairo = document.getElementById("logradouro2");
                var Localidade = document.getElementById("logradouro5");
                var UF = document.getElementById("logradouro6");
                var url = "http://viacep.com.br/ws/" + cep.value + "/json/"
                var mensagem = "endereco ta muito invalido";
//                alert(url);
                // utiliza para passar a url ao navegador
                fetch(url, {method: 'GET'})
                        //dentro do then cria uma variavel qualquer nome
                        .then(response => {
                            response.json()
                                    .then(data => {
//                                console.log(data);
                                        Logradouro.value = data.logradouro;
                                        Complemento.value = data.complemento;
                                        Bairo.value = data.bairro;
                                        Localidade.value = data.localidade;
                                        UF.value = data.uf;

                                    })

                        })
                        .catch(err => {
                            Logradouro.value = "";
                            Complemento.value = "";
                            Bairo.value = "";
                            Localidade.value = "";
                            UF.value = "";
//                            pode escrever direto tambem com aspas
                            alert(mensagem);

                        })

            }

        </script>

    </body>
</html>
