<%-- 
    Document   : paginaPrincipal
    Created on : 24 de mar de 2021, 19:38:03
    Author     : marce
--%>


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

        <!--        <h1>Hello World!</h1>-->
        <div class="row">
            <div class="col-md-12">Cabecalho<br>(col-md-12)</div>
            <!--<h1>Hello World!</h1>-->
            <div class="d-flex justify-content-between">
                <div class="w-25 p-3" class="h-25 d-inline-block" class="p-2 flex-fill bd-highlight"" ><img src="./img/Sapatilha Laranja.png" class="img-fluid" alt="Texto alternativo(alt)"></div>
                <div class="w-50 p-3" class="d-flex justify-content-betweent"><input type="text" class="form-control" placeholder="Search"></div>
                <div class="w-25 p-3" class="p-2 flex-fill bd-highlight"><a href="login.jsp">Login</a></div>
                <div class="p-2 flex-fill bd-highlight"><span class="glyphicon glyphicon-search"></span></div>
            </div>
            <!--outro teste-->
            <!--<img src="img/IMG_4594.JPG" class="img-fluid" width: 10%; alt="Texto alternativo(alt)">-->

            <!--            <form class="navbar-form navbar-left" role="search">
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Search">
                            </div>
                            <button type="submit" class="btn btn-default">
                                <span class="glyphicon glyphicon-search"></span>
                            </button>
                        </form>-->
        </div>
        <!--</div>--> 
        <!--apenas teste-->
        <!--    <form class="navbar-form navbar-left" role="search">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Search">
                </div>
                <button type="submit" class="btn btn-default">
                    <span class="glyphicon glyphicon-search"></span>
                </button>
            </form>-->
        <!--<a href="login.jsp">Login</a>-->
        <!--</div>-->
        <div class="row">
            <div class="col-md-6"> 
                <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" id="customCheck1">
                    <label class="custom-control-label" for="customCheck1">Check this custom checkbox 1</label>
                </div>
                <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" id="customCheck1">
                    <label class="custom-control-label" for="customCheck1">Check this custom checkbox 2</label>
                </div>
                <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" id="customCheck1">
                    <label class="custom-control-label" for="customCheck1">Check this custom checkbox 3</label>
                </div>
                <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" id="customCheck1">
                    <label class="custom-control-label" for="customCheck1">Check this custom checkbox 4</label>
                </div>
                <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" id="customCheck1">
                    <label class="custom-control-label" for="customCheck1">Check this custom checkbox 5</label>
                </div>
                <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" id="customCheck1">
                    <label class="custom-control-label" for="customCheck1">Check this custom checkbox 6</label>
                </div>
                <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" id="customCheck1">
                    <label class="custom-control-label" for="customCheck1">Check this custom checkbox 7</label>
                </div>
                <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" id="customCheck1">
                    <label class="custom-control-label" for="customCheck1">Check this custom checkbox 8</label>
                </div>                
                Coluna de anuncios<br>(col-md-6)
            </div>                
            <div class="col-md-6">
                <div class="row">
                    <div class="col-md-3">
                        <div class="card" style="width: 18rem;">
                            <img src="img/${produtoI.nomeImagem}" class="card-img-top" alt="...">
                            <!--<img  src="img/${produtoI8.nomeImagem}" class="card-img-top">-->
                            <div class="card-body">
                                <h5 class="card-title"></h5>
                                <p class="card-text">${produto.nomeExtenso}</p>
                                <p class="card-text">R$ ${produto.preco}</p>
                                <!--                                <a href="login.jsp" class="btn btn-primary">Login</a>-->
                                <a href="VisualizarProduto?nome=${produtoNome}" class="btn btn-primary">Ver</a> 
                                <!--<a href="login.jsp">Login</a>-->
                                <!--<a href="" class="btn btn-primary">Go 2</a>-->
                            </div>
                        </div>
                        Coluna de anuncios<br>(col-md-3)

                    </div>
                    <div class="col-md-3">
                        <div class="card" style="width: 18rem;">
                            <img src="img/${produtoI2.nomeImagem}" class="card-img-top" alt="...">
                            <div class="card-body">
                                <h5 class="card-title"></h5>
                                <p class="card-text">${produto2.nomeExtenso}</p>
                                <p class="card-text">R$ ${produto2.preco}</p>
                                <a href="VisualizarProduto?nome=${produto2Nome}" class="btn btn-primary">Ver</a> 
                            </div>
                        </div>
                        Coluna de anuncios<br>(col-md-3)
                    </div>
                    <div class="col-md-3">
                        <div class="card" style="width: 18rem;">
                            <img src="img/${produtoI3.nomeImagem}" class="card-img-top" alt="...">
                            <div class="card-body">
                                <h5 class="card-title"></h5>
                                <p class="card-text">${produto3.nomeExtenso} </p>
                                <p class="card-text">R$ ${produto3.preco}</p>
                                <a href="VisualizarProduto?nome=${produto3Nome}" class="btn btn-primary">Ver</a>
                            </div>
                        </div>
                        Coluna de anuncios<br>(col-md-3)
                    </div>
                    <div class="col-md-3">
                        <div class="card" style="width: 18rem;">
                            <img src="img/${produtoI4.nomeImagem}" class="card-img-top" alt="...">
                            <div class="card-body">
                                <h5 class="card-title"></h5>
                                <p class="card-text">${produto4.nomeExtenso}</p>
                                <p class="card-text">R$ ${produto4.preco}</p>
                                <a href="VisualizarProduto?nome=${produto4Nome}" class="btn btn-primary">Ver</a>
                            </div>
                        </div>
                        Coluna de anuncios<br>(col-md-3)
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-3">
                        <div class="card" style="width: 18rem;">
                            <img src="..." class="card-img-top" alt="...">
                            <div class="card-body">
                                <h5 class="card-title">Card title</h5>
                                <p class="card-text">${produto5.nomeExtenso} ${produto5.preco}</p>
                                <a href="#" class="btn btn-primary">Ver</a>
                            </div>
                        </div>
                        Coluna de anuncios<br>(col-md-3)
                    </div>
                    <div class="col-md-3">
                        <div class="card" style="width: 18rem;">
                            <img src="..." class="card-img-top" alt="...">
                            <div class="card-body">
                                <h5 class="card-title">Card title</h5>
                                <p class="card-text">${produto6.nomeExtenso} ${produto6.preco}</p>
                                <a href="#" class="btn btn-primary">Ver</a>
                            </div>
                        </div>
                        Coluna de anuncios<br>(col-md-3)
                    </div>
                    <div class="col-md-3">
                        <div class="card" style="width: 18rem;">
                            <img src="img/${produtoI7.nomeImagem}" class="card-img-top" alt="...">
                            <div class="card-body">
                                <h5 class="card-title">Card title</h5>
                                <p class="card-text">Some quick ${produto7.nomeExtenso} ${produto7.preco}</p>
                                <a href="#" class="btn btn-primary">Ver</a>
                            </div>
                        </div>
                        Coluna de anuncios<br>(col-md-3)
                    </div>
                    <div class="col-md-3">
                        <div class="card" style="width: 18rem;">
                            <!--<img src="..." class="card-img-top" alt="...">-->
                            <img  src="img/${produtoI8.nomeImagem}" class="card-img-top">
                            <div class="card-body">
                                <h5 class="card-title">Card title</h5>                      
                                <p class="card-text">Some ${produto8.nomeExtenso} ${produto8.preco}</p>
                                teste ${produto8Nome} apagar


                                <a href="VisualizarProduto?nome=${produto8Nome}" class="btn btn-primary">Ver</a>                              
                            </div>
                        </div>
                        Coluna de anuncios<br>(col-md-3)
                    </div>
                </div>
            </div>                
        </div>
    </body>
</html>
