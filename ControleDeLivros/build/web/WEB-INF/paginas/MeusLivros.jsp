<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Meus Livros</title>
    </head>
    <body>
        
        <h2>Meus Liuvros </h2>
        
        <table>
            <tr>
                <td>Titulo</td>
                <td>Autor</td>
                <td>Genero</td>
                <td>Status da Leitura</td>
            </tr>
            <c:forEach var="livro" items="${livros}">
                <h2>
                    <tr>
                        <td> ${livro.titulo}</td>
                        <td> ${livro.autor} </td>
                        <td> ${livro.genero} </td>
                        <td></td>
                    </tr>
                </h2>
            </c:forEach>
        </table>
    </body>
</html>