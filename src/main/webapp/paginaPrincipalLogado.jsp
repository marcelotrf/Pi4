<%-- 
    Document   : cadastrarImagens
    Created on : 6 de abr de 2021, 16:56:26
    Author     : marce
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
        <link rel="stylesheet" href="./css/slider.css" />

        <title>JSP Page</title>
    </head>
    <body>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>

        <!--<h1>Hello World!</h1>-->
        <h1>Tela Principal </h1>
        <div class="col-md-12"><br></div>        
        <div class="row">
            <!--divisão do logo-->
            <div class="col-md-4">
                <!--<h1>Hello World!</h1>-->
                <div class="d-flex justify-content-between">
                    <!--<div class="w-25 p-3" class="h-25 d-inline-block" class="p-2 flex-fill bd-highlight"" ><img src="./img/Sapatilha Laranja.png" class="img-fluid" alt="Texto alternativo(alt)"></div>-->
                    <!--<div ><img src="./img/Sapatilha Laranja.png" class="img-fluid" alt="Texto alternativo(alt)"></div>-->
                </div>
            </div>
            <!--barra de pesquisa-->
            <div class="col-md-4">
                <div class="w-50 p-3" class="d-flex justify-content-betweent"><input type="text" class="form-control" placeholder="Search"></div>
            </div>
            <!--menu nav bar--> 
            <div class="col-md-4">
                <!--teste nav bar login-->
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
                            <!--                                                        <li class="nav-item">
                                                                                        <a class="nav-link" href="#">Features</a>
                                                                                    </li>-->
                            <!--                            <li class="nav-item">
                                                            <a class="nav-link" href="#">Pricing</a>
                                                        </li>-->
                            <li class="nav-item dropdown">

                                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    ${nome}
                                </a>
                                <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                                    <!--<a class="dropdown-item" href="cadastrarComprador.jsp">Meu cadastro</a> apgaar se der certo-->
                                    <a class="dropdown-item" href="AlterarComprador?email=${nome}">Meu cadastro</a>
                                    <a class="dropdown-item" href="ListarPedidosComprador?email=${nome}">Histórico de Pedidos</a>
                                    <!--teste so exemplo-->
                                    <!--<td><a href="AlterarFuncionario?nome=dolar{funcionario.nome}">Alterar</a></td>-->
                                    <!--fim teste-->
                                    <a class="dropdown-item" href="PaginaPrincipal">Sair</a>
                                    <!--<a class="dropdown-item" href="#">Something else here</a>-->
                                </div>
                            </li>                            
                            <li class="nav-item active">
                                <a class="nav-link" href="Carrinho?email=${nome}&nomeProduto=${produtoNome}">Carrinho <span class="sr-only">(current)</span></a>
                            </li>

                        </ul>
                    </div>
                </nav>
            </div>
            <!--fim teste login-->
            <!--            nao funciona linha abaixo
                        <div class="p-2 flex-fill bd-highlight"><span class="glyphicon glyphicon-search"></span></div>-->
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
        <!--</div>-->

        <div class="row">
            <div class="col-md-6"> 
                <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" id="customCheck1">
                    <label class="custom-control-label" for="customCheck1">Categoria 1</label>
                </div>
                <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" id="customCheck1">
                    <label class="custom-control-label" for="customCheck1">Categoria 2</label>
                </div>
                <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" id="customCheck1">
                    <label class="custom-control-label" for="customCheck1">Categoria 3</label>
                </div>
                <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" id="customCheck1">
                    <label class="custom-control-label" for="customCheck1">Categoria 4</label>
                </div>
                <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" id="customCheck1">
                    <label class="custom-control-label" for="customCheck1">Categoria 5</label>
                </div>
                <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" id="customCheck1">
                    <label class="custom-control-label" for="customCheck1">Categoria 6</label>
                </div>
                <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" id="customCheck1">
                    <label class="custom-control-label" for="customCheck1">Categoria 7</label>
                </div>
                <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" id="customCheck1">
                    <label class="custom-control-label" for="customCheck1">Categoria 8</label>
                </div>                

            </div> 
            <!--apresentações dos cards dos produtos-->
            <div class="col-md-6">
                <div class="row">
                    <!--primeiro produto-->
                    <div class="col-md-3">
                        <div class="card" style="width: 18rem;">
                            <img src="img/${produtoI.nomeImagem}" class="card-img-top" alt="...">
                            <!--<img  src="img/dolar{produtoI8.nomeImagem}" class="card-img-top">-->
                            <div class="card-body">
                                <h5 class="card-title"></h5>
                                <p class="card-text">${produto.nomeExtenso}</p>
                                <p class="card-text">R$ ${produto.preco}</p>
                                <!--                                <a href="login.jsp" class="btn btn-primary">Login</a>-->
                                <!--<a href="VisualizarProduto?nome=dolar{produtoNome}" class="btn btn-primary">Ver</a>--> 
                                <!--teste apagar linha abaixo--> 
                                <!--<a href="Carrinho?email=${nome}&nomeProduto=${produtoNome}" class="btn btn-primary">Carrinho de compra</a>--> 
                                <a href="VisualizarProduto?nome=${produtoNome}" class="btn btn-primary">Ver</a> 
                                <a href="Carrinho?email=${nome}&nomeProduto=${produtoNome}" class="btn btn-primary">Comprar</a>                                 
                                <!--<a href="login.jsp">Login</a>-->
                                <!--<a href="" class="btn btn-primary">Go 2</a>-->
                            </div>
                        </div>
                        <!--segundo produto-->
                    </div>
                    <div class="col-md-3">
                        <div class="card" style="width: 18rem;">
                            <img src="img/${produtoI2.nomeImagem}" class="card-img-top" alt="...">
                            <div class="card-body">
                                <h5 class="card-title"></h5>
                                <p class="card-text">${produto2.nomeExtenso} ${produto2.preco}</p>
                                <a href="VisualizarProduto?nome=${produto2Nome}" class="btn btn-primary">Ver</a> 
                                <a href="Carrinho?email=${nome}&nomeProduto=${produto2Nome}" class="btn btn-primary">Comprar</a> 
                            </div>
                        </div>
                        
                    </div>
                    <!--terceiro produto-->
                    <div class="col-md-3">
                        <div class="card" style="width: 18rem;">
                            <img src="img/${produtoI3.nomeImagem}" class="card-img-top" alt="...">
                            <div class="card-body">
                                <h5 class="card-title"></h5>
                                <p class="card-text">${produto3.nomeExtenso} ${produto3.preco}</p>
                                <a href="VisualizarProduto?nome=${produto3Nome}" class="btn btn-primary">Ver</a> 
                                <a href="Carrinho?email=${nome}&nomeProduto=${produto3Nome}" class="btn btn-primary">Comprar</a>
                            </div>
                        </div>
                        
                    </div>
                            <!--quarto produto-->
                    <div class="col-md-3">
                        <div class="card" style="width: 18rem;">
                            <img src="img/${produtoI4.nomeImagem}" class="card-img-top" alt="...">
                            <div class="card-body">
                                <h5 class="card-title"></h5>
                                <p class="card-text">${produto4.nomeExtenso} ${produto4.preco}</p>
                                <a href="VisualizarProduto?nome=${produto4Nome}" class="btn btn-primary">Ver</a> 
                                <a href="Carrinho?email=${nome}&nomeProduto=${produto4Nome}" class="btn btn-primary">Comprar</a>
                            </div>
                        </div>
                        
                    </div>
                </div>
                <div class="row">
                    <!--quinto produto-->
                    <div class="col-md-3">
                        <div class="card" style="width: 18rem;">
                            <img src="img/${produtoI5.nomeImagem}" class="card-img-top" alt="...">
                            <div class="card-body">
                                <h5 class="card-title"></h5>
                                <p class="card-text">${produto5.nomeExtenso} ${produto5.preco}</p>
                                <a href="VisualizarProduto?nome=${produto5Nome}" class="btn btn-primary">Ver</a> 
                                <a href="Carrinho?email=${nome}&nomeProduto=${produto5Nome}" class="btn btn-primary">Comprar</a>
                            </div>
                        </div>
                        
                    </div>
                            <!--sexto produto-->
                    <div class="col-md-3">
                        <div class="card" style="width: 18rem;">
                            <img src="img/${produtoI6.nomeImagem}" class="card-img-top" alt="...">
                            <div class="card-body">
                                <h5 class="card-title"></h5>
                                <p class="card-text">${produto6.nomeExtenso} ${produto6.preco}</p>
                                <a href="VisualizarProduto?nome=${produto6Nome}" class="btn btn-primary">Ver</a> 
                                <a href="Carrinho?email=${nome}&nomeProduto=${produto6Nome}" class="btn btn-primary">Comprar</a>
                            </div>
                        </div>
                        
                    </div>
                            <!--setimo produto-->
                    <div class="col-md-3">
                        <div class="card" style="width: 18rem;">
                            <!--<img src="img/${produtoI7.nomeImagem}" class="card-img-top" alt="...">-->
                            <img src="img/${produtoI7.nomeImagem}" class="card-img-top" alt="...">
                            <div class="card-body">
                                <h5 class="card-title"></h5>
                                <p class="card-text">${produto7.nomeExtenso} ${produto7.preco}</p>
                                <a href="VisualizarProduto?nome=${produto7Nome}" class="btn btn-primary">Ver</a> 
                                <a href="Carrinho?email=${nome}&nomeProduto=${produto7Nome}" class="btn btn-primary">Comprar</a>
                            </div>
                        </div>
                        
                    </div>
                            <!--oitavo produto-->
                    <div class="col-md-3">
                        <div class="card" style="width: 18rem;">
                            <!--<img src="..." class="card-img-top" alt="...">-->
                            <!--<img  src="img/${produtoI8.nomeImagem}" class="card-img-top">-->
                            <img  src="img/${produtoI8.nomeImagem}" class="card-img-top">
                            <div class="card-body">
                                <h5 class="card-title"></h5>                      
                                <p class="card-text">${produto8.nomeExtenso} ${produto8.preco}</p>
                                <a href="VisualizarProduto?nome=${produto8Nome}" class="btn btn-primary">Ver</a> 
                                <a href="Carrinho?email=${nome}&nomeProduto=${produto8Nome}" class="btn btn-primary">Comprar</a>                             
                            </div>
                        </div>                       
                    </div>
                </div>
            </div>                
        </div>

                            
                            
                            <!--apagar tudo para baixo-->
        <!--teste nav bar login-->
<!--        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="#">Navbar</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavDropdown">
                <ul class="navbar-nav">
                    <li class="nav-item active">
                        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Features</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Pricing</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            ${nome}
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                            <a class="dropdown-item" href="cadastrarComprador.jsp">Meu cadastro</a> apgaar se der certo
                            <a class="dropdown-item" href="AlterarComprador?email=${nome}">Meu cadastro</a>
                            teste so exemplo
                            <td><a href="AlterarFuncionario?nome=dolar{funcionario.nome}">Alterar</a></td>
                            fim teste
                            <a class="dropdown-item" href="PaginaPrincipal">Sair</a>
                            <a class="dropdown-item" href="#">Something else here</a>
                        </div>
                    </li>
                </ul>
            </div>
        </nav>
        fim teste login

        <div class="row">
            <div class="col-md-12">Primeira linha<br>(col-md-12)
                <form action="CadastrarImagem"method="POST" >
                <form>
                    <div class="form-group row">
                        <label for="inputEmail3" class="col-sm-2 col-form-label">Caminho arquivo Upload</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="inputEmail3" name="nomeImg">
                        </div>
                    </div>     
                    <input type="checkbox" name="imagemPrincipal" value="C">Imagem da Pagina Principal <br/>
                    <button type="submit" class="btn btn-primary">Upload</button>                    
                </form>
                                <form action="CadastrarImagem"method="POST">  
                                    <button type="submit" class="btn btn-primary">Upload</button>                      
                                </form>
            </div>

        </div>
        <div class="row">

            <div class="col-md-12">Segunda linha<br>(col-md-12)

                <div class="col-md-6">checkbox linha(col-md-6)<br>

                    ${cBox}  
                    <c:forEach var="imagem" items="${listaimagens}">
                        <input type="checkbox" name="imagem" value="${imagem.nomeImagem}">Imagem 
                        ${cBox}
                    </c:forEach> 


                                        <input type="checkbox" name="imagem" value="C">Imagem 1 
                                        <input type="checkbox" name="imagem" value="C">Imagem 2 
                                        <input type="checkbox" name="imagem" value="C">Imagem 3 
                                        <input type="checkbox" name="imagem" value="C">Imagem 4                
                </div>
                <div class="col-md-6">imagens linha(col-md-6)
                                        <div id="slide-wrapper">
                                            <img id="slideLeft" class="arrow" src="img/Left arrow.png">
                                            <div id="slider">
                                                
                    
                    
                                                                            <img class="thumbnail active" src="img/IMG_4594.JPG">
                                                                            trazendo do servlet a informacap
                                                                            <img class="thumbnail" src="dolar{img}">
                                                                            <img class="thumbnail" src="img/Lavadora de Roupas Ex2.jpg">
                                                                            
                                                
                                                                            <img class="thumbnail" src="img/Lavadora de Roupas Ex3.jpg">
                                                                                            <img class="thumbnail" src="img/IMG_5328.JPG">
                                                                                            <img class="thumbnail" src="img/IMG_5326.JPG">
                                                                                            <img class="thumbnail" src="img/IMG_5328.JPG">
                                            </div>
                                            <img id="slideRight" class="arrow" src="img/Right arrow.png">
                                            <button type="submit" class="btn btn-primary">Remover Selecionados</button>            
                                        </div>
                </div>            
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Concluir Cadastro Produto</button> 

                <div class="container">
                    <br><br>
                    <h1 style="text-align:center;">Javascript Image Gallery</h1>
                    3 minuto o style acima
                    <br><br>
                    <form id="form" enctype="multipart/form-data">
                        <div class="form-group">
                            <input type="file" class="form-control" id="image">
                        </div>
                        <div class="form-group">
                            <button class="btn btn-primary">Upload</button>
                        </div>
                    </form>
                    <button onclick="remove()" class="btn btn-danger">Remove</button>            
                    <div id="result">
        
                    </div>
        
                </div>

        <form id="form" enctype="multipart/form-data">
            <div class="form-group">
                <input type="file" class="form-control" id="image">
            </div>
            <div class="form-group">
                <button class="btn btn-primary">Upload</button>
            </div>
        </form>
        <div  id="result"></div>
        <button onclick="remove()" class="btn btn-danger">Remove</button> 


        <div id="slide-wrapper">
            <img id="slideLeft" class="arrow" src="img/Left arrow.png">
            <div id="slider">    



                <img src="img/IMG_4594.JPG">                    

                                <form id="form" enctype="multipart/form-data">
                                    <div class="form-group">
                                        <input type="file" class="form-control" id="image">
                                    </div>
                                    <div class="form-group">
                                        <button class="btn btn-primary">Upload</button>
                                    </div>
                                </form>
                <button onclick="remove()" class="btn btn-danger">Remove</button>            
                <div  id="result"></div>




                <!--ta estranho o i em cima-- 2 minuto de video>

                o input e botao padrao que abre pasta documentos



                                <img class="thumbnail active" src="img/IMG_4594.JPG">
                
                                <img class="thumbnail" src="img/Lavadora de Roupas Ex2.jpg">
                                <img class="thumbnail" src="img/Lavadora de Roupas Ex3.jpg">
                                <img class="thumbnail" src="img/IMG_5328.JPG">
                                <img class="thumbnail" src="img/IMG_5326.JPG">
                                <img class="thumbnail" src="img/IMG_5328.JPG">
            </div>
            <img id="slideRight" class="arrow" src="img/Right arrow.png">
            <button type="submit" class="btn btn-primary">Remover Selecionados</button>            -->
        <!--</div>-->

        <script type="text/javascript">
            let thumbnails = document.getElementsByClassName('thumbnail')

            let activeImages = document.getElementsByClassName('active')

            for (var i = 0; i < thumbnails.length; i++)
            {
                thumbnails[i].addEventListener('mouseover', function ()
                {
                    //                            console.log(activeImages)
                    if (activeImages.length > 0)
                    {
                        activeImages[0].classList.remove('active')
                    }

                    this.classList.add('active')
                    //                    document.getElementById('featured').src = this.src

                })

            }

            let buttonRight = document.getElementById('slideRight');
            let buttonLeft = document.getElementById('slideLeft');

            buttonLeft.addEventListener('click', function () {
                document.getElementById('slider').scrollLeft -= 180


            })

            buttonRight.addEventListener('click', function () {
                document.getElementById('slider').scrollLeft += 180
            })



        </script>

        <script>
            var form = document.getElementById('form')
            var parentDiv = document.getElementById('result')

            form.addEventListener('submit', function (event) {
                event.preventDefault()

                var reader = new FileReader()

                var name = document.getElementById("image").files[0].name

                reader.addEventListener('load', function () {
                    if (this.result && localStorage)
                    {
                        window.localStorage.setItem(name, this.result)
                        //                        alert("image stored in local storage")
                        parentDiv.innerHTML = ''
                        showImages()
                    } else
                    {
                        alert("not successful")
                    }



                })

                reader.readAsDataURL(document.getElementById('image').files[0])
                console.log(name)
            })

            function showImages() {
                for (let i = 0; i < window.localStorage.length; i++)
                {
                    let res = window.localStorage.getItem(window.localStorage.key(i))
                    var image = new Image()
                    image.src = res;

                    parentDiv.appendChild(image)
                }
            }

            function remove() {
                window.localStorage.clear()
                parentDiv.innerHTML = ''

            }

            showImages()


        </script>

<!--        const file = this.files[0];
        if (file) {
        const reader = new FileReader();
        reader.onload = function () {
        const result = reader.result;
        img.src = result;
        wrapper.classList.add("active");
        }
        cancelBtn.addEventListener("click", function () {
        img.src = "";
        wrapper.classList.remove("active");

        })
        reader.readAsDataURL(file);-->

    </body>
</html>
