/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifsp.pwe.contatos.beans;

/**
 *
 * @author Giovani
 */
public class Contato {
    private long id;
    private String nome;
    private String email;
    
    public Contato(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public void setId(long id) {
        this.id = id;
    }
}
