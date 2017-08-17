/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifsp.pwe.contatos.daos;

import ifsp.pwe.contatos.beans.Contato;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Giovani
 */
public class ContatoDAO {
 
    private final static Map<Long, Contato> CONTATOS = new HashMap<>();
	static {
		geraIdEAdiciona(new Contato("Joãozinho", "joaozinho@ifsp.edu.br"));
		geraIdEAdiciona(new Contato("Mariazinha", "mariazinha@ifsp.edu.br"));
                geraIdEAdiciona(new Contato("Marombeiro", "marombeiro123@gmail.com"));
	}

	public Collection<Contato> buscaSimilar(String nome) {
		if (nome == null)
			return CONTATOS.values();
		
		List<Contato> similares = new ArrayList<>();
		for (Contato contato : CONTATOS.values()) {
			if (contato.getNome().toLowerCase().contains(nome.toLowerCase()))
				similares.add(contato);
		}
		return similares;
	}

	public void adiciona(Contato contato) {
		geraIdEAdiciona(contato);
	}

	private static void geraIdEAdiciona(Contato contato) {
		long id = CONTATOS.size()+1l;
		contato.setId(id);
		CONTATOS.put(id, contato);
	}
   
}
