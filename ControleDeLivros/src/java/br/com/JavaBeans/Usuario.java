package br.com.JavaBeans;

import java.util.Collection;

public class Usuario {
    private int Id;
    private String email;
    private String senha;
    private String nome;
    private Collection<LivroUsuario> livros;

    public Usuario(String email, String senha, String nome) {
        this.email = email;
        this.senha = senha;
        this.nome = nome;
    }

    public Usuario() {
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Collection<LivroUsuario> getLivros() {
        return livros;
    }

    public void setLivros(Collection<LivroUsuario> livros) {
        this.livros = livros;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

}
