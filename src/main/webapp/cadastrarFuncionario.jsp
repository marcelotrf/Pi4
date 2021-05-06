<%-- 
    Document   : cadastrarFuncionario
    Created on : 27 de abr de 2021, 15:31:31
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
        <h1>Cadastro de Funcionário</h1>
        <!--altear action-->
        <form action="CadastrarUsuario"method="POST">           
            <p>Nome</p>
            <input name="nome"/><br/>
            <p>Email</p>
            <input type="email" name="email"/><br/>
            <p>Senha</p>
            <input type="password" name="senha"/><br/> 
            <!--por enquanto sem sobrenome-->
<!--            <p>Nome Extenso</p>
            <input name="nomeExtenso"/><br/>-->
<!--estrela nao precisa-->
<!--            <p>Qtd Estrelas</p>
            <input name="qtdEstrela"/><br/>
            <br/>-->
            <label>Tipo </label>
            <select name="tipo">
                <option value="valor1" selected>Tipo</option>
                <option value="Administrador" >Administrador</option>
                <option value="Estoquista">Estoquista</option>                  
            </select>  
            <!--nao precisa-->
<!--            <p>Qtd Estoque</p>
            <input name="qtdEstoque"/><br/>
            <p>Preço</p>
            <input name="preco"/><br/>
            <br/>-->
            <!--            <button type="submit">Cancelar</button>-->            
            <button type="submit">Cadastrar Funcionário</button><br/><br/>
            <!--lembrar de levar o nome do produto-->
            <a href="CadastrarImagens.jsp?nome=${produto.nome}" class="btn btn-primary">Cadastrar oficial</a>
            <!--teste-->
            ${nome}
            <a href="CadastrarImagem?nome=${nome}">Cadastrar ir Imagens correto ${nome}</a><br/><br/>
            <!--<a href="CadastrarImagem?nome=${nome}" class="btn btn-primary"></a>Cadastrar ir Imagens correto ${nome}<br/><br/>-->

<!--<a href="CadastrarImagem?nome=${produto.nome} class="btn btn-primary">Imagem teste</a>-->
            <!--fim teste-->
            <a href="index.jsp">Voltar</a>
        </form>
    </body>
</html>
