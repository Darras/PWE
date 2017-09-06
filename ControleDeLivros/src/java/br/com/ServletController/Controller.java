package br.com.ServletController;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
    
public class Controller extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        
        
        String tarefa = req.getParameter("tarefa");
        
        if (tarefa == null) {
            throw new IllegalArgumentException("Você não informou a tarefa");
        }
        
        tarefa = "br.com.ServletController." + tarefa;

        try {
            
            //MÉTODO A EXECUTAR
            Class<?> classe = Class.forName(tarefa);
            String metodo = req.getParameter("metodo");
            String pagina = null;
            System.out.println(metodo);
            if(metodo == null){
                Tarefa instancia = (Tarefa) classe.newInstance();
                pagina = instancia.executa(req, resp);
            }else{
                Method method = classe.getDeclaredMethod(metodo, HttpServletRequest.class, HttpServletResponse.class);
                pagina = (String) method.invoke(classe.newInstance(),req, resp);
            }
            System.out.println("salve");
            if(pagina != null){
                RequestDispatcher requestDispacher = req.getRequestDispatcher(pagina);
                requestDispacher.forward(req, resp);
            }
        }catch (ClassNotFoundException |NoSuchMethodException | SQLException | InvocationTargetException| InstantiationException | IllegalAccessException ex) {
            throw new ServletException(ex);
        }
    }

}
