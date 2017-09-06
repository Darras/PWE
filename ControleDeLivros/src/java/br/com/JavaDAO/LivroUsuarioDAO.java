/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.JavaDAO;

import br.com.JavaBeans.Conexao;
import br.com.JavaBeans.Livro;
import br.com.JavaBeans.LivroUsuario;
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
 * @author Gabriel
 */
public class LivroUsuarioDAO {
    Connection con;
    Usuario user = null;
    PreparedStatement stmt = null;
    
    public Collection<LivroUsuario> BuscaLivrosUsuario(int idUsuario) throws SQLException {     
     Collection<LivroUsuario> livros = new ArrayList<> ();
        try{
         con = Conexao.getConexaoMySQL();
            String sql = "SELECT * FROM Livro_USUARIO WHERE idusuario = ?";
         stmt = con.prepareStatement(sql);
         stmt.setInt(1, idUsuario);
         System.out.println(stmt.toString());
         ResultSet result = stmt.executeQuery();
        
        while(result.next()){
            LivroUsuario livro = new LivroUsuario();
            livro.setIdLivro(result.getInt(2));
            livro.setIdUsuario(result.getInt(1));
            livro.setStatus_Leitura(result.getString(3));
           livros.add(livro); 
        }
        stmt.close();
        con.close();
     }catch(SQLException ex){
         System.out.println(ex.toString());
         return null;
     }
     return livros;
    }
        public boolean InsereLivroUsuario(Usuario user,Livro livro){
        try{
            con = Conexao.getConexaoMySQL();
            String sql = "INSERT INTO Livro_USUARIO(IdUsuario,IdLivro,Status_leitura) VALUES(?,?,?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, user.getEmail());
            stmt.setString(2, user.getSenha());
            stmt.setString(3, user.getNome());
            int i = stmt.executeUpdate();
            if(i>0){
                System.out.println("Usuario inserido");
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
        
    public Collection<Livro> retornaLivrosWeb(Usuario usuario){
        Collection<Livro> ListaLivros = new ArrayList<>();
        
         try{
             Collection<LivroUsuario> livros = this.BuscaLivrosUsuario(usuario.getId());
            con = Conexao.getConexaoMySQL();
               String sql = "SELECT * FROM livros WHERE idlivro IN (";
               int i = 0;
            for(LivroUsuario livro : livros){
                i++;
                sql+= livro.toString();
                if(livros.size() <= i)
                    sql+=",";
                else
                    sql+=")";
            }
               stmt = con.prepareStatement(sql);
            System.out.println(stmt.toString());
            ResultSet result = stmt.executeQuery();
        
        while(result.next()){
            Livro livro = new Livro();
            livro.setId(result.getInt(2));
            livro.setTitulo(result.getString("titulo"));
            livro.setAutor(result.getString("autor"));
            livro.setGenero(result.getString("genero"));
            livro.setStatus_Leitura(result.getString("status_leitura"));
           ListaLivros.add(livro); 
        }
        stmt.close();
        con.close();
     }catch(SQLException ex){
         System.out.println(ex.toString());
         return null;
     }
        return ListaLivros;
    
    }
}
