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

/**
 *
 * @author Giovani
 */
public class UsuarioDAO {
    Connection con;
    Usuario user = null;
    PreparedStatement stmt = null;
    
    public Usuario buscaPorEmaileSenha(String email, String senha) throws SQLException {     
     try{
         con = Conexao.getConexaoMySQL();
            String sql = "SELECT * FROM USUARIO WHERE email = ? and senha = ?";
         stmt = con.prepareStatement(sql);
         stmt.setString(1, email);
         stmt.setString(2, senha);
         System.out.println(stmt.toString());
         ResultSet result = stmt.executeQuery();
        
        while(result.next()){
            user = new Usuario();
            user.setId(result.getInt("id"));
            user.setEmail(result.getString("email"));
            user.setSenha(result.getString("senha"));
        }
        stmt.close();
        con.close();
     }catch(SQLException ex){
         System.out.println(ex.toString());
         return null;
     }
     return user;
    }
    
    public boolean InsereUsuario(Usuario user){
        try{
            con = Conexao.getConexaoMySQL();
            String sql = "INSERT INTO USUARIO(email,senha,nome) VALUES(?,?,?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, user.getEmail());
            stmt.setString(2, user.getSenha());
            stmt.setString(3, user.getNome());
            int i;
            i = stmt.executeUpdate();
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
}
