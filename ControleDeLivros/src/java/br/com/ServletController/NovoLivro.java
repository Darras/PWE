/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ServletController;

import br.com.JavaBeans.Livro;
import br.com.JavaBeans.Usuario;
import br.com.JavaDAO.LivroDAO;
import br.com.JavaDAO.LivroUsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Gabriel
 */
public class NovoLivro extends HttpServlet {

public String retorno = "";

    public String executa(HttpServletRequest req, HttpServletResponse resp) throws SQLException{
        String Titulo = req.getParameter("nome");
        String Autor  = req.getParameter("autor");
        String Genero = req.getParameter("genero");
        String Status = req.getParameter("status_leitura");
        
        Livro livro = new Livro();
        livro.setTitulo(Titulo);
        livro.setAutor(Autor);
        livro.setGenero(Genero);
        livro.setStatus_Leitura(Status);
                
        boolean inserir = new LivroDAO().InsereLivro(livro);
        
        Collection<Livro> LivrosAtuais = new LivroDAO().buscaPorTitulo(livro.getTitulo());
        
        HttpSession session = req.getSession();
        Usuario user = (Usuario) session.getAttribute("usuarioLogado");
                
        for(Livro l : LivrosAtuais) { 
            if(l.getTitulo().equals(livro.getTitulo())){ 
                new LivroUsuarioDAO().InsereLivroUsuario(user, l.getId(), Status);
            }
        }
        // Collection<Livro> livros = new LivroDAO().buscaTodosOsLivros();
        return "/WEB-INF/paginas/Main.jsp";
    }
}
