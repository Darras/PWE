/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.JavaBeans;

/**
 *
 * @author Gabriel
 */
public class Livro {
    private int Id;
    private String Titulo;
    private String Autor;
    private String Genero;
    private String Status_Leitura;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String Autor) {
        this.Autor = Autor;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public String getStatus_Leitura() {
        return Status_Leitura;
    }

    public void setStatus_Leitura(String Status_Leitura) {
        this.Status_Leitura = Status_Leitura;
    }
    
    
}
