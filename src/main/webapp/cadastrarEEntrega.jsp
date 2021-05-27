<%-- 
    Document   : cadastrarEEntrega
    Created on : 28 de abr de 2021, 16:27:20
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
        <h1>Cadastro novo endereço</h1>
        CEP: <input type="text" id="cep">
        <!--onlick serve para executar a funcao no script-->
        <button onclick="endereco()">Obter endereço</button><br/><br/>

        <form action="CadastrarEEntrega" method="POST">    
            <input type="email" name="email" value="${email}" hidden/><br/>
            <!--            <p>Nome</p>
                        <input name="nome"/><br/>
                        <p>Email</p>
                        <input type="email" name="email"/><br/>
                        <p>Senha</p>
                        <input type="password" name="senha"/><br/> -->
            <label>Cpf: </label>
            <input name="cpf" value="${cpf}"/><br/>
            <!--talvez nao precise-->
            <!--            <p>endereco</p>
                        <input name="endereco"/><br/>-->
            <!--comentar de teste-->
            <!--<form action="CepServlet" method="POST">-->
            <p>Endereço de Faturamento </p>
            <!--            CEP: <input type="text" id="cep"><br/>-->
            Logradouro: <input type="text" id="logradouro" name="logradouro" >
            Número: <input type="text" id="numeroL" name="numeroL">
            <br/>
            Bairo: <input type="text" id="logradouro2" name="bairro" readonly="true" >
            <!--<button type="submit">Enviar</button>-->    
            <!--</form>-->
            <!--CEP: <input type="text" id="cep">-->
            <!--onlick serve para executar a funcao no script-->
            <!--<button onclick="endereco()">Obter endereço</button>-->

            <!--Logradouro: <input type="text" id="logradouro" name="texto" disabled>-->
            <!--com disable nao funciona pegar dados-->
            Complemento: <input type="text" id="logradouro4" name="texto2" disabled><br/>
            <!--Bairo: <input type="text" id="logradouro2" name="texto3" disabled>-->
            <!--Localidade: <input type="text" id="logradouro5" name="cidade" disabled><br/>-->
            Cep: <input type="text" id="cep" name="cep"><br/>   
            Localidade: <input type="text" id="logradouro5" name="cidade" ><br/>
            UF: <input type="text" id="logradouro6" name="uf" ><br/>

            <button type="submit">Cadastrar Endereço para Entrega </button><br/><br/>
            <!--lembrar de levar o nome do produto-->
            <!--            <a href="CadastrarImagens.jsp?nome=dolar{produto.nome}" class="btn btn-primary">Cadastrar oficial</a>-->
            <!--teste-->

            <!--            <a href="CadastrarImagem?nome=dolar{nome}">Cadastrar ir Imagens correto dolar{nome}</a><br/><br/>-->
            <!--<a href="CadastrarImagem?nome=dolar{nome}" class="btn btn-primary"></a>Cadastrar ir Imagens correto dolar{nome}<br/><br/>-->

            <!--<a href="CadastrarImagem?nome=dolar{produto.nome} class="btn btn-primary">Imagem teste</a>-->
            <!--fim teste-->

        </form>
        <!--testar botao fora do form-->
        <!--<button onclick="endereco()">Obter endereço via CEP</button><br/><br/>-->
        <!--<button type="submit">Cadastrar Endereço de Entrega</button><br/><br/>-->
        <!--<a href="cadastrarEEntrega.jsp" class="btn btn-primary">Cadastrar Endereço de Entrega</a><br/>-->

        <a href="index.jsp">Voltar</a>

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
