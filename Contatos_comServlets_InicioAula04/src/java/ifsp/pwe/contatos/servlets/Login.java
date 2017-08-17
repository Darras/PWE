/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifsp.pwe.contatos.servlets;

import ifsp.pwe.contatos.beans.Usuario;
import ifsp.pwe.contatos.daos.UsuarioDAO;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Giovani
 */
public class Login implements Tarefa {
    public String retorno = "";
    
    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) throws SQLException{
        try{
        Usuario usuario = new UsuarioDAO().buscaPorEmaileSenha(req.getParameter("email"), req.getParameter("senha"));
        if(usuario==null) {
            retorno = "naoEncontrado.jsp";
        } else {
            HttpSession session = req.getSession();
            session.setAttribute("usuarioLogado", usuario);
            
            retorno =  "/WEB-INF/paginas/Main.jsp";
        }
        }catch(SQLException ex){
        
        }
        return retorno;
    }
}
