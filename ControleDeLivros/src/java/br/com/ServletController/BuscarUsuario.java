/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ServletController;

import br.com.JavaBeans.Livro;
import br.com.JavaBeans.Usuario;
import br.com.JavaDAO.LivroDAO;
import br.com.JavaDAO.UsuarioDAO;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Gabriel
 */
public class BuscarUsuario implements Tarefa {
    public String retorno = "";
    
    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) throws SQLException{
        try{
            System.out.println(req.getParameter("param"));
            List<Usuario> usuarios = new UsuarioDAO().BuscarUsuario(req.getParameter("param"));
            if(usuarios==null) {
                retorno = "naoEncontrado.jsp";
            } else {   
                req.setAttribute("usuarios", usuarios);
                retorno =  "/WEB-INF/paginas/ListarUsuarios.jsp";
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return retorno;
    }
}
