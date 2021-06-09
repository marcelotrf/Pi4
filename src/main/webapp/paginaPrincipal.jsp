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

        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet"> 
        <link rel="stylesheet" href="./css/paginaPrincipal.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">

        <title>JSP Page</title>
    </head>
    <body>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>

        <!--        <h1>Hello World!</h1>-->

        <div id="header">
            <div class="burger_div border_div">
                <div class="burger_button"></div>
            </div>
            <p class="center_div">FGMSHOES</p>
            <form class="border_div">
                <input type="text" name="search" id="">
            </form>
        </div>
        <nav id="nav" class="nav">
            <div></div>
            <div id="navigation" class="navigation">
                <p class="p_text">SAPATILHAS</p>
                <p class="p_text">TÊNIS</p>
                <p class="p_text">BOTAS</p>
                <p class="p_text">SANDÁLIAS</p>
            </div>
            <div></div>
        </nav>
        <!--<div id="announce"><p class="p_text">FRETE GRATIS EM COMPRAS ACIMA DE 399.99</p></div>-->

        <div id="imgs">
            <img id="first" class="banner_img" src="./img/Sapatilha Laranja.png"/>
            <img id="second" class="banner_img" src="./img/sapatilhalilas.JPG"/>
            <img id="third" class="banner_img" src="./img/sapatilharosa.JPG"/>
        </div>
        <!--<h1>Hello World!</h1>-->
        <!--<div class="d-flex justify-content-between">
            <div class="w-25 p-3" class="h-25 d-inline-block" class="p-2 flex-fill bd-highlight"" ><img src="./img/Sapatilha Laranja.png" class="img-fluid" alt="Texto alternativo(alt)"></div>
            <div class="w-50 p-3" class="d-flex justify-content-betweent"><input type="text" class="form-control" placeholder="Search"></div>
            <div class="w-25 p-3" class="p-2 flex-fill bd-highlight"><a href="login.jsp">Login</a></div>
            <div class="p-2 flex-fill bd-highlight"><span class="glyphicon glyphicon-search"></span></div>
        </div> -->
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

            <div class="col-md-12">
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

                    </div>
                </div>
                <div class="row">
                    <div class="col-md-3">
                        <div class="card" style="width: 18rem;">
                            <img src="img/${produtoI5.nomeImagem}" class="card-img-top" alt="...">
                            <div class="card-body">
                                <h5 class="card-title"></h5>
                                <p class="card-text">${produto5.nomeExtenso}</p>
                                <p class="card-text">R$ ${produto5.preco}</p>
                                <a href="VisualizarProduto?nome=${produto5Nome}" class="btn btn-primary">Ver</a>
                            </div>
                        </div>

                    </div>
                    <div class="col-md-3">
                        <div class="card" style="width: 18rem;">
                            <img src="img/${produtoI6.nomeImagem}" class="card-img-top" alt="...">
                            <div class="card-body">
                                <h5 class="card-title"></h5>
                                <p class="card-text">${produto6.nomeExtenso}</p>
                                <p class="card-text">R$ ${produto6.preco}</p>
                                <a href="VisualizarProduto?nome=${produto6Nome}" class="btn btn-primary">Ver</a>
                            </div>
                        </div>

                    </div>
                    <div class="col-md-3">
                        <div class="card" style="width: 18rem;">
                            <img src="img/${produtoI7.nomeImagem}" class="card-img-top" alt="...">
                            <div class="card-body">
                                <h5 class="card-title"></h5>
                                <p class="card-text">${produto7.nomeExtenso}</p>
                                <p class="card-text">R$ ${produto7.preco}</p>
                                <a href="VisualizarProduto?nome=${produto7Nome}" class="btn btn-primary">Ver</a>
                            </div>
                        </div>

                    </div>
                    <div class="col-md-3">
                        <div class="card" style="width: 18rem;">
                            <!--<img src="..." class="card-img-top" alt="...">-->
                            <img  src="img/${produtoI8.nomeImagem}" class="card-img-top">
                            <div class="card-body">
                                <h5 class="card-title"></h5>                      
                                <p class="card-text">${produto8.nomeExtenso} ${produto8.preco}</p>
                                <p class="card-text">R$ ${produto8.preco}</p>
                                <!--teste dolar{produto8Nome} apagar-->


                                <a href="VisualizarProduto?nome=${produto8Nome}" class="btn btn-primary">Ver</a>                              
                            </div>
                        </div>

                    </div>
                </div>
            </div>                
        </div>
        <script>
            const menuBtn = document.querySelector('.burger_div');
            let menuOpen = false;
            menuBtn.addEventListener('click', () => {
                if (!menuOpen) {
                    menuBtn.classList.add('open');
                    menuOpen = true;
                } else {
                    menuBtn.classList.remove('open');
                    menuOpen = false;
                }
            });
        </script>
    </body>
</html>
