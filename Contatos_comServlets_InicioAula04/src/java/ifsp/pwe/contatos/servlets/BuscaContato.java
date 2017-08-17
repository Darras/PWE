package ifsp.pwe.contatos.servlets;

import ifsp.pwe.contatos.beans.Contato;
import ifsp.pwe.contatos.daos.ContatoDAO;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Giovani
 */
public class BuscaContato implements Tarefa {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        Collection<Contato> similares = new ContatoDAO().buscaSimilar(req.getParameter("filtro"));
        req.setAttribute("contatos", similares);
        return "WEB-INF/busca.jsp";
    }
}
