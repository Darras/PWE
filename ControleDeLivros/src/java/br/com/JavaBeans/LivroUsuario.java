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
public class LivroUsuario {
    private int IdUsuario;
    private int IdLivro;
    private String Status_Leitura;

    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public int getIdLivro() {
        return IdLivro;
    }

    public void setIdLivro(int IdLivro) {
        this.IdLivro = IdLivro;
    }

    public String getStatus_Leitura() {
        return Status_Leitura;
    }

    public void setStatus_Leitura(String Status_Leitura) {
        this.Status_Leitura = Status_Leitura;
    }
}
