<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
        <title>Lista de Contatos</title>
    </head>
    <body>

        <br>
        <div class="container">

            <p> Lista de contatos </p>

            <hr>

            <p> Novo contato </p>
            <form action="controller" method="POST">
                <input type="hidden" name="tarefa" value="NovoContato">
                Nome: <input type="text" name="nome"/>
                Email: <input type="email" name="email"/>

                <input type="submit" name="salvar" value="salvar"/>
            </form>

            <br>

            <form action="controller" method="GET">
                <input type="hidden" name="tarefa" value="BuscaContato">
                Buscar contato: <input type="text" name="filtro">
                <input type="submit" value="buscar contato!">
            </form>

        </div>
    </body>
</html>
