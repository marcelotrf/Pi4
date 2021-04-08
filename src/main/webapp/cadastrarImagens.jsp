<%-- 
    Document   : cadastrarImagens
    Created on : 6 de abr de 2021, 16:56:26
    Author     : marce
--%>

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
        <h1>Tela do produto ${produto.nome} e ${img} </h1>
        <div class="row">
            <div class="col-md-12">Primeira linha<br>(col-md-12)
                <form>
                    <div class="form-group row">
                        <label for="inputEmail3" class="col-sm-2 col-form-label">Caminho arquivo Upload</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="inputEmail3" name="nomeImg">
                        </div>
                    </div>     
                    <input type="checkbox" name="imagemPrincipal" value="C">Imagem da Pagina Principal <br/>
                    <!--<button type="submit" class="btn btn-primary">Upload</button>-->
                    <a href="CadastrarImagem?img=${img}" class="btn btn-primary">Upload teste</a>
                </form>
            </div>

        </div>
        <div class="row">

            <div class="col-md-12">Segunda linha<br>(col-md-12)

                <div class="col-md-6">checkbox linha(col-md-6)<br>
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
                            <!--trazendo do servlet a informacap-->
                            <img class="thumbnail" src="${img}">
                            <img class="thumbnail" src="img/Lavadora de Roupas Ex2.jpg">
                            

                            <img class="thumbnail" src="img/Lavadora de Roupas Ex3.jpg">
                            <!--                <img class="thumbnail" src="img/IMG_5328.JPG">
                                            <img class="thumbnail" src="img/IMG_5326.JPG">
                                            <img class="thumbnail" src="img/IMG_5328.JPG">-->
                        </div>
                        <img id="slideRight" class="arrow" src="img/Right arrow.png">
                        <button type="submit" class="btn btn-primary">Remover Selecionados</button>            
                    </div>
                </div>            
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Concluir Cadastro Produto</button> 

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
                    document.getElementById('featured').src = this.src

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

    </body>
</html>
