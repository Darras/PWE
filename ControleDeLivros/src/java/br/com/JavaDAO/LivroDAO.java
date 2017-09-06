/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.JavaDAO;

import br.com.JavaBeans.Conexao;
import br.com.JavaBeans.Livro;
import br.com.JavaBeans.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Giovani
 */
public class LivroDAO {
    Connection con;
    Livro livro = null;
    PreparedStatement stmt = null;
    
    public Collection<Livro> buscaPorTitulo(String param) throws SQLException {     
     List<Livro> Livros = new ArrayList<>();
     
        try{
         con = Conexao.getConexaoMySQL();
            String sql = "SELECT * FROM Livro WHERE titulo = ?";
         stmt = con.prepareStatement(sql);
         stmt.setString(1, param);
         System.out.println(stmt.toString());
         ResultSet result = stmt.executeQuery();
        
        while(result.next()){
            livro = new Livro();
            livro.setTitulo(result.getString("titulo"));
            livro.setAutor(result.getString("autor"));
            livro.setGenero(result.getString("genero"));
            Livros.add(livro);
                    }
        stmt.close();
        con.close();
     }catch(SQLException ex){
         System.out.println(ex.toString());
         return null;
     }
     return Livros;
    }
    public Collection<Livro> buscaTodosOsLivros() throws SQLException {     
     List<Livro> Livros = new ArrayList<>();
     
        try{
         con = Conexao.getConexaoMySQL();
            String sql = "SELECT * FROM Livro";
         stmt = con.prepareStatement(sql);
         System.out.println(stmt.toString());
         ResultSet result = stmt.executeQuery();
        
        while(result.next()){
            livro = new Livro();
            livro.setTitulo(result.getString("titulo"));
            livro.setAutor(result.getString("autor"));
            livro.setGenero(result.getString("genero"));
            Livros.add(livro);
                    }
        stmt.close();
        con.close();
     }catch(SQLException ex){
         System.out.println(ex.toString());
         return null;
     }
     return Livros;
    }
    public boolean InsereLivro(Livro livro){
        try{
            String sql = "INSERT INTO livro VALUES(?,?,?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setString(3, livro.getGenero());
            int i = stmt.executeUpdate();
            if(i>0){
                System.out.println("Livro inserido");
            }else{
                System.out.println("falha ao inserir");
            }
            stmt.close();
            con.close();
        }catch(SQLException ex){
            return false;
     }
     return true;
    }

}
