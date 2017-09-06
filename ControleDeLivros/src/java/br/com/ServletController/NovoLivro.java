/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ServletController;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gabriel
 */
public class NovoLivro extends HttpServlet {

public String retorno = "";

    public String executa(HttpServletRequest req, HttpServletResponse resp) throws SQLException{
        
        return "/WEB-INF/paginas/CadastrarUsuario.jsp";
    }
}
