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
        <link rel="stylesheet" href="css/sliderV.css" />
        <!--pode apagar-->
        <!--<link rel="stylesheet" href="css/upload.css">-->
        <script src="https://kit.fontawesome.com/a076d05399.js"></script>

        <title>JSP Page</title>
    </head>
    <body>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>

        
        <div class="row">
            
            <div class="col-md-6">
                <h1 class="text-center"> ${nomeProduto}  ${img} </h1>
                <!--teste////////////-->
                <div id="content-wrapper">

                    <div class="colum">
                        <!--colocar a primeira imagem-->
                        <!--<img id=featured src="img/IMG_4594.JPG">-->
                        <img id=featured src="img/${produtoI.nomeImagem}">

                        <div id="slide-wrapper">                            
                            <img id="slideLeft" class="arrow" src="img/Left arrow.png">
                            <div id="slider">
                                <!--repetir a primeira imagem-->
                                <!--<img class="thumbnail active" src="img/Lavadora de Roupas Ex3.jpg">-->

                                <!--acho que nao precisa-->
                                <!--<img class="thumbnail active" src="img/dolar{produtoI.nomeImagem}">-->

                                <!--colocar o resto dentro do for-->
                                <c:forEach var="imagens" items="${listaImagens}">
                                    <img class="thumbnail" src="img/${imagens.nomeImagem}">
                                </c:forEach>
                                <!--                                <img class="thumbnail" src="img/BOTA PRETA 2.JPG">
                                                                <img class="thumbnail" src="img/BOTA BEGE.JPG">
                                
                                                                <img class="thumbnail" src="img/IMG_4594.JPG">
                                                                <img class="thumbnail" src="img/IMG_5328.JPG">
                                                                <img class="thumbnail" src="img/IMG_5326.JPG">
                                                                <img class="thumbnail" src="img/IMG_5328.JPG">-->
                            </div>
                            <img id="slideRight" class="arrow" src="img/Right arrow.png">     
                            
                        </div>
                    </div>

                </div>
            </div>
            <!--fim teste;;;;;-->

            <div class="col-md-3">
                <div class="coluna15">
                    <!--nome do produto-->                    
                    <h3 id="nomeH3"> ${nomeProduto} </h3>  </br><br/>
                    <!--descricao-->
                    <textarea type="text" rows="4" cols="100" maxlength="500" class="descrição" >${produto.nomeExtenso}</textarea>
                </div>
                <div class="colum" id="colum2">

                    <!--<h1>titulo</h1>-->
                    <!--<hr>-->
                    <h3>R$ ${produto.preco}</h3>

                    <!--<p>paragrafo</p>-->
                    <!--<input value="1" type="number">-->
                    <!--bootstrap-->
                    <!--//alterado devido ao logado-->
                    <a class="btn btn-dark" href="Carrinho?nomeProduto=${nomeProduto}">Comprar</a> <a class="btn btn-dark" href="PaginaPrincipal">voltar</a>


                </div>


            </div>
            <!--
        fim teste
        teste segunda coluna
            -->       

        </div>  


        <!--fim teste///////-->

        <!--        <div class="row">
        
                    <div class="col-md-12">Segunda linha<br>(col-md-12)
        
        
                        <div class="col-md-6">imagens linha(col-md-6)
        
                        </div>            
                    </div>
                </div>
                <button type="submit" class="btn btn-primary">Concluir Cadastro Produto</button> -->




        <!--        <script>
                    const wrapper = document.querySelector(".wrapperUpload")
                    const fileName = document.querySelector(".file-name")
                    const cancelBtn = document.querySelector("#cancel-btn")
                    const defaultBtn = document.querySelector("#default-btn")
                    const customBtn = document.querySelector("#custom-btn")
                    const img = document.querySelector("img")
                    let regExp = /[0-9a-zA-Z\^\&\'\@\{\}\[\]\,\$\=\!\~\#\(\)\.\%\+\-\_ ]+$/;
                    function defaultBtnActive() {
                        defaultBtn.click();
                    }
                    defaultBtn.addEventListener("change", function () {
                        const file = this.files[0];
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
                            reader.readAsDataURL(file);
                        }
                        if (this.value) {
                            let valueStore = this.value.match(regExp);
                            fileName.textContent = valueStore;
                        }
                    });
        
        
        
                </script>-->

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

        <!--        <script>
                    const wrapper2 = document.querySelector(".wrapper2")
        //            const cancelBtn = document.querySelector("#cancel-btn")
                    const defaultBtn2 = document.querySelector("#default-btn2")
        //            const customBtn2 = document.querySelector("#custom-btn2")
                    const img2 = document.querySelector("#img2")
        //            let regExp = /[0-9a-zA-Z\^\&\'\@\{\}\[\]\,\$\=\!\~\#\(\)\.\%\+\-\_ ]+$/;
                    function defaultBtnActive2() {
                        defaultBtn2.click();
                    }
                    defaultBtn2.addEventListener("change", function () {
                        const file = this.files[0];
                        if (file) {
                            const reader = new FileReader();
                            reader.onload = function () {
                                const result = reader.result;
                                img2.src = result;
                                wrapper2.classList.add("active");
                            }
                            cancelBtn.addEventListener("click", function () {
                                img2.src = "";
                                wrapper2.classList.remove("active");
        
                            })
                            reader.readAsDataURL(file);
                        }
                    });
        
        
        
                </script>-->

    </body>
</html>
