<%-- 
    Document   : CadastrarUsuario
    Created on : 30/08/2017, 21:49:04
    Author     : Gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Usuarios</title>
    </head>
    <body>
        <h1>Cadastrar Usuarios</h1>
            <form action="controller" method="POST">
                <input type="hidden" name="tarefa" value="CriarUsuario">
                <input type="hidden" name="metodo" value="redirect">
                Nome: <input type="text" name="nome"/>
                Email: <input type="email" name="email"/>
                Senha: <input type="password" name="senha"/>
                <input type="submit" name="salvar" value="salvar"/>
            </form>

    </body>
</html>
