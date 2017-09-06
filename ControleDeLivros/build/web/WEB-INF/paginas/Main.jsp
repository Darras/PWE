<%@page import="br.com.JavaBeans.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

            <p> Cadastro de livros </p>
            <p>Bem Vindo <% colocar usuario aqui %></p>
            <form action="controller" method="POST">
                <input type="hidden" name="tarefa" value="NovoLivro">
                <input type="hidden" name="metodo" value="executa">
                Titulo: <input type="text" name="nome"/>
                Autor: <input type="text" name="autor"/>
                Genero: <input type="text" name="genero"/>
                Status de Leitura <select type="text" name="">
                    <option type="text" name="status_leitura" value="Leitura não Iniciada"/>leitura
                    <option type="text" name="status_leitura" value="Em leitura"/>em leitura
                    <option type="text" name="status_leitura" value="Lido"/>lido
                </select>

                <input type="submit" name="salvar" value="salvar"/>
            </form>

            <br>
            
            <form action="controller" method="GET">
                <input type="hidden" name="tarefa" value="BuscaUsuario">
                <input type="hidden" name="metodo" value="executa">
                Buscar Usuario: <input type="text" name="filtro">
                <input type="submit" value="buscar contato!">
            </form>
            <br>
            <c:forEach var="livros" items="${livro}">
                ${livro.titulo}
                ${livro.autor}
                ${livro.genero}
            </c:forEach>
        </div>
    </body>
    </html>
