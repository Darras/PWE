<%-- 
    Document   : busca
    Created on : Aug 2, 2017, 9:46:41 PM
    Author     : Giovani
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado da busca</title>
    </head>
    <body>
        
        Resultado da busca: 
        
        <ul>
            <c:forEach var="contato" items="${contatos}">
                <h2>
                    <li> ${contato.nome} </li>
                </h2>
            </c:forEach>
        </ul>
        
        JSPPPPPPPPPPPPPPPPPP
        
    </body>
</html>
