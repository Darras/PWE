package ifsp.pwe.contatos.servlets;

import ifsp.pwe.contatos.beans.Contato;
import ifsp.pwe.contatos.daos.ContatoDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Giovani
 */
public class NovoContato implements Tarefa {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        Contato contato = new Contato(req.getParameter("nome"), req.getParameter("email"));
        new ContatoDAO().adiciona(contato);
        req.setAttribute("contato", contato);
        return "WEB-INF/adicionado.jsp";
    }
}