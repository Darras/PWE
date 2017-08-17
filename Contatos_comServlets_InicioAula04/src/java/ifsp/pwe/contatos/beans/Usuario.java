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
public class Usuario {

    private String email;
    private String senha;

    public Usuario(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public Usuario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }
    public String setEmail(String email) {
        this.email = email;
        return this.email;
    }

    public String setSenha(String senha) {
        this.senha = senha;
        return this.senha;
    }

}
