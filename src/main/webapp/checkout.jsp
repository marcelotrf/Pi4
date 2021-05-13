<%-- 
    Document   : checkout
    Created on : 12 de mai de 2021, 05:36:29
    Author     : marce
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w==" crossorigin="anonymous" />
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">

        <style>
            body {
                font-family: Arial;
                font-size: 17px;
                padding: 8px;
            }

            * {
                box-sizing: border-box;
            }

            .row {
                display: -ms-flexbox; /* IE10 */
                display: flex;
                -ms-flex-wrap: wrap; /* IE10 */
                flex-wrap: wrap;
                margin: 0 -16px;
            }

            .col-25 {
                -ms-flex: 25%; /* IE10 */
                flex: 25%;
            }

            .col-50 {
                -ms-flex: 50%; /* IE10 */
                flex: 50%;
            }

            .col-75 {
                -ms-flex: 75%; /* IE10 */
                flex: 75%;
            }

            .col-25,
            .col-50,
            .col-75 {
                padding: 0 16px;
            }

            .container {
                background-color: #f2f2f2;
                padding: 5px 20px 15px 20px;
                border: 1px solid lightgrey;
                border-radius: 3px;
            }

            input[type=text] {
                width: 100%;
                margin-bottom: 20px;
                padding: 12px;
                border: 1px solid #ccc;
                border-radius: 3px;
            }

            label {
                margin-bottom: 10px;
                display: block;
            }

            .icon-container {
                margin-bottom: 20px;
                padding: 7px 0;
                font-size: 24px;
            }

            .btn {
                background-color: #04AA6D;
                color: white;
                padding: 12px;
                margin: 10px 0;
                border: none;
                width: 100%;
                border-radius: 3px;
                cursor: pointer;
                font-size: 17px;
            }

            .btn:hover {
                background-color: #45a049;
            }

            a {
                color: #2196F3;
            }

            hr {
                border: 1px solid lightgrey;
            }

            span.price {
                float: right;
                color: grey;
            }

            .thumbnail{
                width: 100px;
            }

            .price{
                font-size: 1.5rem;
            }

        </style>
    </head>
    <body>
        <div class="row">
            <div class="col-75">
                <div class="container">
                    <form action="/action_page.php">

                        <div class="row">
                            <div class="col-50">
                                <h3>Endereço de cobrança</h3>
                                <label for="fname"><i class="fa fa-user"></i> Full Name</label>
                                <input type="text" id="fname" name="firstname" placeholder="John M. Doe" value="${comprador.nome}">

                                <label for="email"><i class="fa fa-envelope"></i> Email</label>
                                <input type="text" id="email" name="email" placeholder="john@example.com" value="${comprador.email}">

                                <label for="adr"><i class="fa fa-address-card-o"></i> Address</label>
                                <input type="text" id="adr" name="address" placeholder="542 W. 15th Street" value="${comprador.logradouro}">

                                <label for="city"><i class="fa fa-institution"></i> City</label>
                                <input type="text" id="city" name="city" placeholder="New York"value="${comprador.cidade}">

                                <div class="row">
                                    <div class="col-50">
                                        <label for="state">State</label>
                                        <input type="text" id="state" name="state" placeholder="NY" value="${comprador.uf}">
                                    </div>
                                    <div class="col-50">
                                        <label for="zip">Zip</label>
                                        <input type="text" id="zip" name="zip" placeholder="10001" value="${cep}">
                                    </div>
                                </div>
                            </div>
                            <!--//////////////////////cartao////////////////////-->
                            <!--                            <div class="col-50">
                                                            <h3>Payment</h3>
                                                            <label for="fname">Accepted Cards</label>
                                                            <div class="icon-container">
                                                                <i class="fa fa-cc-visa" style="color:navy;"></i>
                                                                <i class="fa fa-cc-amex" style="color:blue;"></i>
                                                                <i class="fa fa-cc-mastercard" style="color:red;"></i>
                                                                <i class="fa fa-cc-discover" style="color:orange;"></i>
                                                            </div>
                                                            <label for="cname">Name on Card</label>
                                                            <input type="text" id="cname" name="cardname" placeholder="John More Doe">
                                                            <label for="ccnum">Credit card number</label>
                                                            <input type="text" id="ccnum" name="cardnumber" placeholder="1111-2222-3333-4444">
                                                            <label for="expmonth">Exp Month</label>
                                                            <input type="text" id="expmonth" name="expmonth" placeholder="September">
                                                            <div class="row">
                                                                <div class="col-50">
                                                                    <label for="expyear">Exp Year</label>
                                                                    <input type="text" id="expyear" name="expyear" placeholder="2018">
                                                                </div>
                                                                <div class="col-50">
                                                                    <label for="cvv">CVV</label>
                                                                    <input type="text" id="cvv" name="cvv" placeholder="352">
                                                                </div>
                                                            </div>
                                                        </div>-->
                            <!--fim cartao////////////////////////-->

                        </div>
                        <!--                        <label>
                                                    <input type="checkbox" checked="checked" name="sameadr"> Shipping address same as billing
                                                </label>-->
                        <!--<input type="submit" value="Continue to checkout" class="btn">-->
                    </form>
                </div>
            </div>
            <div class="col-25">
                <div class="container">
                    <!--<h4>Cart <span class="price" style="color:black"><i class="fa fa-shopping-cart"></i> <b>4</b></span></h4>-->
                    <h4>Carrinho <span class="price" style="color:black"><i class="fa fa-shopping-cart"></i> <b></b></span></h4>
                    <!--///////////// colocar lista/////////////////-->
                    <table class="table">
                        <thead>
                        <th>Produto</th>
                        <th>Qtd.</th>
                        <th>Preço</th>  

                        </thead>

                        <tbody>
                            <c:forEach var="produto" items="${listaCarrinho}">
                                <tr>                        
                                    <td><img class="thumbnail" src="img/${produto.nomeImagem}"> ${produto.nome}</td>  
                                    <td>
                                        <div class="input-group">                                       
                                            ${produto.quantidade}
                                            <form action="Carrinho"method="POST"> 
                                                <!--<input type="text" class="form-control text-center border-dark" value="dolar{produto.quantidade}" id="quantidade" name="quantidade">-->
                                                <input type="text"  value="${produto.nome}"  name="nome" hidden>
                                                <br/>
                                                <!--                                            <button type="submit" class="btn btn-dark" >Alterar Quantidade</button>-->
                                            </form>

                                            <!--botao menos-->
                                            <!--btn btn-outline-dark btn-sm-->

                                            <!--                                        <button type="button" class="btMais">
                                                                                        <i class="fas fa-plus align-self-center"></i>
                                                                                                                    <svg class="bi" width="16" height="16" fill="currentColor">
                                                                                                                    
                                                                                                                         <use  />
                                                                                                                         </svg>
                                            
                                                                                    </button>-->
                                            <!--botao lixeira-->
                                            <!--                                        <button type="button" class="btn btn-outline-danger border-dark btn-sm">
                                                                                        <i class="fas fa-trash"></i>                          
                                            
                                                                                    </button>-->


                                        </div>
                                    </td>                      
                                    <!--quantidade apagar isso?-->
                                    <!--<td> quantidade dolar{produto.qtdEstoque}</td>-->
                                    <!--// R$dolar{produto.preco}  //-->  
                                    <td>               
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
                            novo valor final ${valorFinal}
                        </tbody>
                    </table>
                    <!--                    <hr>
                                        <p><a href="#">Product 1</a> <span class="price">$15</span></p>
                                        <p><a href="#">Product 2</a> <span class="price">$5</span></p>
                                        <p><a href="#">Product 3</a> <span class="price">$8</span></p>
                                        <p><a href="#">Product 4</a> <span class="price">$2</span></p>-->
                    <hr>
                    <!--//////////////fim da lista//////////////-->
                    <p>Total <span class="price" style="color:black"><b>R$ ${valorFinal}</b></span></p>
                </div>
            </div> 
        </div>
        <!--formas de pagametno////////////////////////////////-->
        <!--//tentar utilizar o post do listarchecout servlet-->
        <form action="ListarCheckout" method="POST">


            <div class="card w-50 " style="top: 50px; left: 332px;">
                <div class="card-body">
                    <h5 class="card-title text-center">Escolha a forma de Pagamento</h5>
                    <div class="row">
                        <div class="col-50">
                            <p><a href="ListarCheckout" ><i class="fas fa-barcode fa-9x " style="color: black" ></i> </a> </p>                                      
                            <h4 class="card-text">Boleto</h4>

                        </div>
                        <div class="col-50" style=" margin-top: -0.25rem !important;">
                            <p><a href="#" ><i class="far fa-credit-card fa-9x" style="color: black"></i> </a> </p>  
                            <!--<a class="btn btn-dark" href="ListarCheckout?email=${email}">Comprar</a>--> 
                            <button type="submit">Boleto </button><br/><br/>
                            <h4 class="card-text">Cartão de Crédito</h4>
                            <input type="email" name="email" value="${comprador.email}" hidden/><br/>

                        </div>
                    </div>



                </div>
            </div>
        </form>
        <!--fim do teste///////////////////////////////////////-->

        <a href="PaginaPrincipal" class="btn btn-primary" style="margin-top: 100px;">voltar para algum lugar</a>
    </body>
</html>
