<%-- 
    Document   : carrinhoLogado
    Created on : 12 de mai de 2021, 07:39:18
    Author     : marce
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w==" crossorigin="anonymous" />
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">

        <title>JSP Page</title>
    </head>
    <body>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>

        
        <div class="row">
            <div class="col-md-12"><br>
                <!--<h1>Hello World!</h1>-->
                <div class="d-flex justify-content-between">

                    <div class="w-50 p-3" class="d-flex justify-content-betweent"><input type="text" class="form-control" placeholder="Search"></div>
                    <nav class="navbar navbar-expand-lg navbar-light bg-light">
                        <!--<a class="navbar-brand" href="#">Navbar</a>-->
                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse" id="navbarNavDropdown">
                            <ul class="navbar-nav">
                                <!--                            <li class="nav-item active">
                                                                <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                                                            </li>-->
                                <!--                            <li class="nav-item">
                                                                <a class="nav-link" href="#">Features</a>
                                                            </li>-->
                                <!--                            <li class="nav-item">
                                                                <a class="nav-link" href="#">Pricing</a>
                                                            </li>-->
                                <li class="nav-item dropdown">
                                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        ${email}
                                    </a>
                                    <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                                        <!--<a class="dropdown-item" href="cadastrarComprador.jsp">Meu cadastro</a> apgaar se der certo-->
                                        <a class="dropdown-item" href="AlterarComprador?email=${email}">Meu cadastro</a>
                                        <!--teste so exemplo-->
                                        <!--<td><a href="AlterarFuncionario?nome=dolar{funcionario.nome}">Alterar</a></td>-->
                                        <!--fim teste-->
                                        <a class="dropdown-item" href="PaginaPrincipal">Sair</a>
                                        <!--<a class="dropdown-item" href="#">Something else here</a>-->
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </nav>
                    <div class="p-2 flex-fill bd-highlight"><span class="glyphicon glyphicon-search"></span></div>
                </div>  
            </div>
        </div>
        <br>
        <h1>Carrinho</h1>
        <br>
        <table class="table">
            <thead>
            <th>Produto</th>
            <th>Qtd.</th>
            <th>Preço</th>  

        </thead>

        <tbody>
            <!--ter que criar banco carrinho e salvar e listar as informacoes-->
            <c:forEach var="produto" items="${listaCarrinho}">
                <tr>                        
                    <td><img class="thumbnail" src="img/${produto.nomeImagem}"> ${produto.nome}</td>  
                    <td>quantidade apagar 
                        <div class="input-group">
                            <!--botao +-->
                            <!--btn btn-outline-dark btn-sm-->
                            <button type="button" class="btMenos">
                                <i class="fas fa-minus align-self-center"></i>                           

                            </button>
                            <!--form-control tex-center border-dark-->
                            <!--<input type="text" class="form-control text-center border-dark" value="1" id="quantidade">-->
                            <form action="Carrinho"method="POST"> 
                                <input type="text" class="form-control text-center border-dark" value="${produto.quantidade}" id="quantidade" name="quantidade">
                                <input type="text"  value="${produto.nome}"  name="nome" hidden>
                                <br/>
                                <button type="submit" class="btn btn-dark" >Alterar Quantidade</button>
                            </form>

                            <!--botao menos-->
                            <!--btn btn-outline-dark btn-sm-->

                            <button type="button" class="btMais">
                                <i class="fas fa-plus align-self-center"></i>
                                <!--                            <svg class="bi" width="16" height="16" fill="currentColor">
                                                            
                                                                 <use  />
                                                                 </svg>-->

                            </button>
                            <!--botao lixeira-->
                            <button type="button" class="btn btn-outline-danger border-dark btn-sm">
                                <i class="fas fa-trash"></i>                          

                            </button>


                        </div>
                    </td>                      
                    <!--quantidade apagar isso?-->
                    <!--<td> quantidade dolar{produto.qtdEstoque}</td>-->
                    <td>R$${produto.preco}                   
                        <h4>
                            <b>
                                <a href="#" class="text-decoration-none text-danger">R$</a>
                                <a href="#" class="text-decoration-none text-danger" id="preco">${produto.valorTotal}</a>
                                <!--<span class="text-decoration-none text-danger" id="preco">R$dolar{produto.preco}</span>-->

                            </b>

                        </h4> 
                        <!--<a class="btn btn-dark" href="PaginaPrincipal">Pagina principal teste</a>-->

                    </td>


                    <!--                <td><a href="AlterarProduto?nome=dolar{produto.nome}">Alterar</a></td>
                                    <td><a href="CadastrarImagem?nome=dolar{produto.nome}">Imagem teste</a></td>-->
                    <!--<td><a href="ExcluirProduto?nome"dolar aqui{produto.nome}">Excluir</a></td>--> 
                    <!--                <td><a href="AtivarProduto?nome=dolar{produto.nome}">Ativar ou Reativar</a></td> -->


                </tr>
            </c:forEach>            
           <!-- novo valor final ${valorFinal} -->
        </tbody>
    </table>
    <hr>

    <div class="row">
        <div class="col-md-6"> 
            <!--////////////// incluir cep////////////////////-->
            <div  style="margin-left: 100px;">
                <h2>Endereço Entrega</h2><br/>
                <!--CEP: <input type="text" id="cep" name="cep">-->    
                <button onclick="endereco()">Obter endereço</button><br/><br/>
                <!--<form action="AlterarQuantidadeCarrinho" method="POST">-->    
                <form action="Carrinho" method="POST">  
                    CEP: <input type="text" id="cep" name="cep"> 
                    <!--<button onclick="endereco()">Obter endereço</button><br/><br/>-->
                    <input type="email" name="email" value="${email}" hidden/><br/>

                    <!--<p>Endereço de Faturamento </p>-->
                    Logradouro: <input type="text" id="logradouro" name="logradouro" ><br/>
                    Bairo: <input type="text" id="logradouro2" name="bairro" readonly="true" >
                    Complemento: <input type="text" id="logradouro4" name="texto2" disabled><br/>
                    Localidade: <input type="text" id="logradouro5" name="cidade" ><br/>
                    UF: <input type="text" id="logradouro6" name="uf" ><br/>
                    <button type="submit">Calcular Frete </button><br/><br/>

                </form>
            </div>

        </div>

        <!--////////////////// valor final e frete-->
        <div class="col-md-6"> 
            <h3 class="text-right" style="margin-right: 250px;">
                <b>                      
                    <a class="font-weight-bold text-decoration-none text-#020202">Frete</a>  
                    <a href="#" class="text-decoration-none text-danger">R$</a>
                    <a href="#" class="text-decoration-none text-danger">${valorFrete}</a>
                    <br/>
                    <br/>
                    <p class="font-weight-bold text-decoration-none text-#020202">valor final</p> 
                    <a href="#" class="text-decoration-none text-danger">R$</a>
                    <a href="#" class="text-decoration-none text-danger" id="preco">${valorFinal}</a>
                    <!--<span class="text-decoration-none text-danger" id="preco">R$dolar{produto.preco}</span>-->
                    <br/>
                    <br/>
                   <!--<a class="btn btn-dark" href="ListarCheckout?nome=${nome}">Comprar</a>-->                  
                    <a class="btn btn-dark" href="ListarCheckout?email=${email}">Comprar</a>  


                </b>

            </h3> 

        </div>
    </div>
    <!--///////////////// fim do teste//////////////////-->

    <!--estudo inicial/////////////////////-->
    <!--    <ul class="list-group-item mb-3" >
            <li class="list-group-item py-3">
                <div class="row g-4">
                    coluna da imagem
                    <div class="col-4 col-md-3 col-lg-2">
                        <a href="#">
                        <img src="img/dolar{produtoI.nomeImagem}" class="img-thumbnail">
                        </a>
                    </div>
                    coluna do texto
                    <div class="col-8 col-md-9 col-lg-6 col-xl-6 text-left align-self-center">
                        <h4>
                            <b>
                                <a href="#" class="text-decoration-none text-danger">Abacate Manteiga</a>
    
                            </b>
    
                        </h4>
                        <h4>
    
                            <small>Abacate manteiga da melhor qualidade possível e muito fresco</small>      
                        </h4>
    
                    </div>
                    coluna dos botoes
                    <div class="col-6 offset-6 col-sm-6 offset-sm-6 col-md-4 offset-md-8 col-lg-2 offset-lg-0 col-xl-2 align-self-center mt-3" >
                        <div class="input-group">
                            botao +
                            btn btn-outline-dark btn-sm
                            <button type="button" class="btMenos">
                                <i class="fas fa-minus align-self-center"></i>                           
    
                            </button>
                            form-control tex-center border-dark
                            apaguei pq tava reclando de 2 ids   <input type="text" class="form-control text-center border-dark" value="1" id="quantidade">
                            botao menos
                            btn btn-outline-dark btn-sm
    
                            <button type="button" class="btMais">
                                <i class="fas fa-plus align-self-center"></i>
                                                            <svg class="bi" width="16" height="16" fill="currentColor">
                                                            
                                                                 <use  />
                                                                 </svg>
    
                            </button>
                            botao lixeira
                            <button type="button" class="btn btn-outline-danger border-dark btn-sm">
                                <i class="fas fa-trash"></i>                          
    
                            </button>
    
    
                        </div>
    
                    </div>
                    coluna do preco
                    <div class="col-6 offset-6 col-sm-6 offset-sm-6 col-md-4 offset-md-8 col-lg-2 offset-lg-0 col-xl-2 align-self-center mt-3">
                        <h4>
                            <b>
                                <a href="#" class="text-decoration-none text-danger">R$</a>
                                <a href="#" class="text-decoration-none text-danger" id="preco">dolar{produto.preco}</a>
                                <span class="text-decoration-none text-danger" id="preco">R$dolar{produto.preco}</span>
    
                            </b>
    
                        </h4>                    
    
                    </div>
    
    
                </div>
    
            </li>
        </ul>-->
    <br/>
    <a href="PaginaPrincipal">Voltar</a>


    <!--// pausado por ser uma lista-->
    <!--    <script>
            document.querySelector(".btMenos").setAttribute("disabled", "disabled");
            var valorContador;
    
            var preco = document.getElementById("preco").innerText;
    
            function precoTotal()
            {
                // teste
                valorContador = document.getElementById("quantidade").value = valorContador;
                // fim teste
    //            var total = (valorContador * preco) ;
                document.getElementById("preco").innerText = total
    
            }
            // mostrar ao iniciar a pagina
            valorContador = document.getElementById("quantidade").value;
            document.getElementById("quantidade").value = valorContador;
            precoTotal();
            // fim mostar pagina /////
    
            document.querySelector(".btMais").addEventListener("click", function () {
                valorContador = document.getElementById("quantidade").value;
                valorContador++;
                document.getElementById("quantidade").value = valorContador;
    
                if (valorContador > 1)
                {
                    document.querySelector(".btMenos").removeAttribute("disabled")
                    document.querySelector(".btMenos").classList.remove("disabled")
                }
    
                precoTotal()
    
            })
    
            document.querySelector(".btMenos").addEventListener("click", function () {
                valorContador = document.getElementById("quantidade").value;
                valorContador--;
                document.getElementById("quantidade").value = valorContador
    
                if (valorContador == 1)
                {
                    document.querySelector(".btMenos").setAttribute("disabled", "disabled")
                }
    
                precoTotal()
    
            })
        </script>-->
    <!--cep////////////////////////-->
    <script language="javascript">

        function endereco() {
            var cep = document.getElementById("cep");
            var Logradouro = document.getElementById("logradouro");
            var Complemento = document.getElementById("logradouro4");
            var Bairo = document.getElementById("logradouro2");
            var Localidade = document.getElementById("logradouro5");
            var UF = document.getElementById("logradouro6");
            var url = "http://viacep.com.br/ws/" + cep.value + "/json/"
            var mensagem = "endereço invalido";
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
