<%-- 
    Document   : alterarFuncionario
    Created on : 27 de abr de 2021, 16:32:22
    Author     : marce
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar Funcionario</title>
    </head>
    <body>
        <h1>Tela do funcionário ${funcionarioJ.nome}</h1>
        (nome,senha,tipo,email,status);
        <!--alterar action-->
        <!--aterar value-->
        <form action="AlterarFuncionario" method="POST">
            <p>email</p>
            <input type="email" name="email" value="${funcionarioJ.email}" readonly="true" /><br/> 
            <p>Nome</p>
            <input name="nome" value="${funcionarioJ.nome}" /><br/>
            <p>Nova Senha</p>
            <input type="password" name="senha"  value="${funcionarioJ.senha}"/><br/>
            
            <!--nao precisa-->
<!--            <p>status</p>
            <input name="qtdEstoque" value="${produto.qtdEstoque}"/><br/>            -->
            <!--alternativa para mosrtar cpf original,colocar $ e retirar tru em cima-->
            <!--<input name="cpfOriginal" value="{cliente.cpf}" hiden="true"/><br/>-->            
            <label>Tipo </label>
            <select name="tipo">                 
                <option value="${funcionarioJ.tipo}" selected>${funcionarioJ.tipo}</option>    
                <option value="Estoquista">Estoquista</option>  
                <option value="Administrador" >Administrador</option>
            </select>

            <button type="submit">Enviar</button>            
        </form>
        <br/>
        <!--alterar href-->
        <a href="ListarFuncionario">Voltar</a>
    </body>
</html>
