<%-- 
    Document   : ListarUsuarios
    Created on : 11/09/2017, 21:31:32
    Author     : Gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Contatos</h2>
        
        <table>
            <tr>
                <td>Nome</td>
                <td>Email</td>
            </tr>
            <c:forEach var="usuario" items="${usuarios}">
                <h2>
                    <tr>
                        <td> ${usuario.nome} </td>
                        <td> ${usuario.email}</td>
                        <td>
                            <form>
                                
                                <input type="submit" value="Indicar Livro">
                            </form>
                        </td>
                    </tr>
                </h2>
            </c:forEach>
    </body>
</html>
