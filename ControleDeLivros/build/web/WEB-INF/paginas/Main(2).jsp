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

            <h2> Bem Vindo !!! </h2>
            <div style="border: 1px solid #CCCCCC;padding-right: 14px;padding-left: 14px;">
                <h3>Cadastrar Livro</h3>
                <br>
                <form action="controller" method="POST">
                    <input type="hidden" name="tarefa" value="NovoLivro">
                    <input type="hidden" name="metodo" value="executa">
                    Titulo: <input type="text" name="nome"/>
                    Autor: <input type="text" name="autor"/>
                    Genero: <input type="text" name="genero"/>
                    Status de Leitura <select type="text" name="status_leitura">
                        <option type="text" name="status" value="0"/>Leitura não Iniciada
                        <option type="text" name="status" value="1"/>Em leitura
                        <option type="text" name="status" value="2"/>Lido
                    </select>

                    <input type="submit" name="salvar" value="salvar"/>
                </form>
                <br>
            </div>
            <br>
            
            <form action="controller" method="GET">
                <input type="hidden" name="tarefa" value="MeusLivros">
                <input type="hidden" name="metodo" value="executa">
                <input type="submit" value="Meus Livros">
            </form>
            
            <br>
            
            <form action="controller" method="GET">
                <input type="hidden" name="tarefa" value="BuscarUsuario">
                <input type="hidden" name="metodo" value="executa">
                Buscar Usuario: <input type="text" name="param">
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
