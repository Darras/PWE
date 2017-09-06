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

public class Login implements Tarefa {
    public String retorno = "";
    
    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) throws SQLException{
        try{
        Usuario usuario = new UsuarioDAO().buscaPorEmaileSenha(req.getParameter("email"), req.getParameter("senha"));
        Collection<Livro> livros = new LivroDAO().buscaTodosOsLivros();
        
            if(usuario==null) {
                retorno = "naoEncontrado.jsp";
            } else {
                HttpSession session = req.getSession();
                session.setAttribute("usuarioLogado", usuario);
                session.setAttribute("livros", livros);
                retorno =  "/WEB-INF/paginas/Main.jsp";
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return retorno;
    }
}
