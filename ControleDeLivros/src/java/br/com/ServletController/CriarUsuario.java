package br.com.ServletController;

import br.com.JavaBeans.Livro;
import br.com.JavaBeans.Usuario;
import br.com.JavaDAO.LivroDAO;
import br.com.JavaDAO.UsuarioDAO;
import java.sql.SQLException;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CriarUsuario implements Tarefa {

    public String retorno = "";

    public String redirect(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        Usuario usuario = new Usuario(req.getParameter("email"), req.getParameter("senha"), req.getParameter("nome"));
        boolean inserir = new UsuarioDAO().InsereUsuario(usuario);
        Collection<Livro> livros = new LivroDAO().buscaTodosOsLivros();

        if (inserir == true) {

            HttpSession session = req.getSession();
            req.setAttribute("contato", usuario);
            session.setAttribute("livros", livros);
        }
        return "/WEB-INF/paginas/Main.jsp";

    }

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        return "/WEB-INF/paginas/CadastrarUsuario.jsp";

    }
}
