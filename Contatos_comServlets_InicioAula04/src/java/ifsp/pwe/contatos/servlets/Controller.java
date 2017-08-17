/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifsp.pwe.contatos.servlets;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Giovani
 */
public class Controller extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tarefa = req.getParameter("tarefa");

        if (tarefa == null) {
            throw new IllegalArgumentException("Você não informou a tarefa");
        }

        tarefa = "ifsp.pwe.contatos.servlets." + tarefa;

        try {

            //MÉTODO A EXECUTAR
            Class<?> classe = Class.forName(tarefa);
            Tarefa instancia = (Tarefa) classe.newInstance();
            String pagina = instancia.executa(req, resp);

            RequestDispatcher requestDispatcher = req.getRequestDispatcher(pagina);
            requestDispatcher.forward(req, resp);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |SQLException e) {
            throw new ServletException(e);
        }
    }

}
