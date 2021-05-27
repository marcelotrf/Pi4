<%-- 
    Document   : boletoFinalizar
    Created on : 12 de mai de 2021, 17:43:19
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

            .boleto {
                margin-left: 261px;
                margin-right: auto;
                width: 6em
            }
            
            .card2 {
    position: relative;
    display: -ms-flexbox;
    display: flex;
    -ms-flex-direction: column;
    flex-direction: column;
    min-width: 0;
    word-wrap: break-word;
    background-color: #fff;
    background-clip: border-box;
    /*border: 1px solid rgba(0,0,0,.125);*/
    border-radius: .25rem;
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
                                <label for="fname"><i class="fa fa-user"></i> Nome Completo</label>
                                <input type="text" id="fname" name="firstname" placeholder="John M. Doe" value="${comprador.nome}" readonly="true">

                                <label for="email"><i class="fa fa-envelope"></i> Email</label>
                                <input type="text" id="email" name="email" placeholder="john@example.com" value="${comprador.email}" readonly="true">

                                <label for="adr"><i class="fa fa-address-card-o"></i> Endereço</label>
                                <input type="text" id="adr" name="address" placeholder="542 W. 15th Street" value="${logradouro}" readonly="true">

                                <label for="city"><i class="fa fa-institution"></i> Cidade</label>
                                <input type="text" id="city" name="city" placeholder="New York"value="${cidade}" readonly="true">

                                <div class="row">
                                    <div class="col-50">
                                        <label for="state">Uf</label>
                                        <input type="text" id="state" name="state" placeholder="NY" value="${uf}" readonly="true">
                                    </div>
                                    <div class="col-50">
                                        <label for="zip">Cep</label>
                                        <input type="text" id="zip" name="zip" placeholder="10001" value="${cep}" readonly="true">
                                    </div>
                                </div>
                            </div>
                        </div>
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

                                        </div>
                                    </td>                      

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
                                </tr>

                            </c:forEach>  
                            novo valor final ${valorFinal}
                        </tbody>
                    </table>

                    <hr>
                    <!--//////////////fim da lista//////////////-->
                    <p>Total <span class="price" style="color:black"><b>R$ ${valorFinal}</b></span></p>
                    <!--<a href="PaginaPrincipal" class="btn btn-primary" style="margin-top: 100px;">voltar para algum lugar</a>-->
                </div>
                <!--decidir aonde por botao-->
                <!--nome do servlet aproveitado-->
                <form action="AlterarQuantidadeCarrinho" method="POST">
                <a href="PaginaPrincipal" class="btn btn-primary" style="margin-top: 100px;">Não Finalizar Compra</a>
                <button type="submit">Finalizar Compra </button><br/><br/>
                </form>
            </div> 
        </div>
        <!--formas de pagametno////////////////////////////////-->

        <div class="card2 w-50 " style="top: 50px; left: 332px;">
            <div class="card2-body">
                <div class="boleto">
                    <h3 class="card-title text-center" style="width: 306px;">Pagamento com Boleto</h3>
                    <div class="row">
                        <div class="col-50" >
                            <p class="boleto"><a href="#" ><i class="fas fa-barcode fa-9x " style="color: black; margin-left: -174px;" ></i> </a></p>                                      
                            <!--<h3 class="card-text">Boleto</h3>-->
                        </div>
                    </div>
                </div>



            </div>
        </div>

        <a href="PaginaPrincipal" class="btn btn-primary" style="margin-top: 100px;">voltar para algum lugar</a>
    </body>
</html>
