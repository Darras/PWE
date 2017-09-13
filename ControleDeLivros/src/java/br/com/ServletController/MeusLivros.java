/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ServletController;

import br.com.JavaBeans.Livro;
import br.com.JavaBeans.LivroUsuario;
import br.com.JavaBeans.Usuario;
import br.com.JavaDAO.LivroDAO;
import br.com.JavaDAO.LivroUsuarioDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Aluno
 */
public class MeusLivros implements Tarefa {
    public String retorno = "";
    
    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) throws SQLException{
        HttpSession session = req.getSession();
        Usuario user = (Usuario) session.getAttribute("usuarioLogado");
        
        Collection<Livro> livros_do_usuario = new ArrayList<> ();
        
        Collection<LivroUsuario> livros = new LivroUsuarioDAO().BuscaLivrosUsuario(user.getId());
                
        for(LivroUsuario l : livros) { 
           Livro l1 = new LivroDAO().buscaPorId(l.getIdLivro()); 
           l1.setStatus_Leitura(l.getStatus_Leitura());
           livros_do_usuario.add(l1);
        }
        req.setAttribute("livros", livros_do_usuario);
        retorno = "/WEB-INF/paginas/MeusLivros.jsp";
        return retorno;
    }
}
