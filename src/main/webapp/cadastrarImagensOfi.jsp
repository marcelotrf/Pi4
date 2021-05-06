<%-- 
    Document   : cadastrarImagensOfi
    Created on : 10 de abr de 2021, 12:49:09
    Author     : marce
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Tela cadastro da Imagem</h1>

        <form action="CadastrarImagem" method="POST"  id="form" enctype="multipart/form-data" >
            Produto <input name="nomeP" value="${nome}" readonly="true"/><br/>
            <div class="form-group">
                <input type="file" class="form-control" id="image" name="nomeImg" >
            </div>
            <div class="form-group">
                <button class="btn btn-primary" type="submit" value="Uplodar">Mostrar imagem</button>
            </div>
            <div class="file-name" ></div>  
            <div  id="result" ></div>           

            <button class="btn btn-primary" onclick="document.getElementById('form').submit()" >Cadastrar Imagem</button>

        </form>

        <button onclick="remove()" class="btn btn-danger">Remove Imagem</button> 

        <!--/////////teste lista imagens--> 
<!--        <div id="slide-wrapper">
            <img id="slideLeft" class="arrow" src="img/Left arrow.png">
            <div id="slider">-->
                <%--<c:forEach var="imagem" items="dolar{listaimagens}">--%>
                    <!--<img class="thumbnail" src="img/dolar{imagem.nomeImagem}">--> 

                <%--</c:forEach>--%>   


                <!--                            <img class="thumbnail active" src="img/IMG_4594.JPG">
                                            trazendo do servlet a informacap
                                            <img class="thumbnail" src="dolar{img}">
                                            <img class="thumbnail" src="img/Lavadora de Roupas Ex2.jpg">
                                            
                
                                            <img class="thumbnail" src="img/Lavadora de Roupas Ex3.jpg">
                                                            <img class="thumbnail" src="img/IMG_5328.JPG">
                                                            <img class="thumbnail" src="img/IMG_5326.JPG">
                                                            <img class="thumbnail" src="img/IMG_5328.JPG">-->
<!--            </div>
            <img id="slideRight" class="arrow" src="img/Right arrow.png">
            <button type="submit" class="btn btn-primary">Remover Selecionados</button>            
        </div>-->

        <!--/////////////                fim do teste-->


        <script>
            var form = document.getElementById('form')
            var parentDiv = document.getElementById('result')
            const fileName = document.querySelector(".file-name")
            let regExp = /[0-9a-zA-Z\^\&\'\@\{\}\[\]\,\$\=\!\~\#\(\)\.\%\+\-\_ ]+$/;

            form.addEventListener('submit', function (event) {
                event.preventDefault()

                var reader = new FileReader()

                var name = document.getElementById("image").files[0].name

                reader.addEventListener('load', function () {
                    if (this.result && localStorage)
                    {
                        window.localStorage.setItem(name, this.result)
                        let valueStore = name;
                        fileName.textContent = valueStore;
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
//                $("#form").prop("disabled", false);
            })

            $("#btnSubmit").click(function (event) {
                document.getElementById("form").submit();
                // parar o envio para que possamos faze-lo manualmente.
//                    event.preventDefault();
//                    // capture o formulário
//                    var form = $('#fileUploadForm')[0];
//                    // crie um FormData {Object}
//                    var data = new FormData(form);
//                    // caso queira adicionar um campo extra ao FormData
//                    // data.append("customfield", "Este é um campo extra para teste");
//                    // desabilitar o botão de "submit" para evitar multiplos envios até receber uma resposta
//                    $("#btnSubmit").prop("disabled", true);
//                    // processar
//                    $.ajax({
//                        type: "POST",
//                        enctype: 'multipart/form-data',
//                        url: "/coolurl/upload",
//                        data: data,
//                        processData: false, // impedir que o jQuery tranforma a "data" em querystring
//                        contentType: false, // desabilitar o cabeçalho "Content-Type"
//                        cache: false, // desabilitar o "cache"
//                        timeout: 600000, // definir um tempo limite (opcional)
//                        // manipular o sucesso da requisição
//                        success: function (data) {
//                            console.log(data);
//                            // reativar o botão de "submit"
//                            $("#btnSubmit").prop("disabled", false);
//                        },
//                        // manipular erros da requisição
//                        error: function (e) {
//                            console.log(e);
//                            // reativar o botão de "submit"
//                            $("#btnSubmit").prop("disabled", false);
//                        }
//                    });
            });



            function showImages() {
                for (let i = 0; i < window.localStorage.length; i++)
                {

                    let res = window.localStorage.getItem(window.localStorage.key(i))

                    var image = new Image()
                    image.src = res;

                    parentDiv.appendChild(image)
//                     if (this.value) {

//                    }
                }
            }

            function remove() {
                window.localStorage.clear()
                parentDiv.innerHTML = ''

            }

            showImages()


        </script>
    </body>
</html>
