/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifsp.pwe.contatos.daos;

import ifsp.pwe.contatos.beans.Conexao;
import ifsp.pwe.contatos.beans.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Giovani
 */
public class UsuarioDAO {
    Conexao con = null;
    PreparedStatement stmt = null;
    Usuario user = null;
    
    public Usuario buscaPorEmaileSenha(String email, String senha) throws SQLException {     
     try{
         String sql = "SELECT * FROM USUARIO WHERE email = ? and SENHA = ?";
         stmt = con.getConexao().prepareStatement(sql);
         stmt.setString(0, email);
         stmt.setString(1, senha);
         ResultSet result = stmt.executeQuery(sql);
        
        while(result.next()){
            user = new Usuario();
            user.setEmail(email);
            user.setSenha(senha);
        }
        stmt.close();
        con.FecharConexao();
     }catch(SQLException ex){
         return null;
     }
     return user;
    }
    
    public boolean InsereUsuario(Usuario user){
        try{
            String sql = "INSERT INTO USUARIO VALUES(?,?)";
            stmt = con.getConexao().prepareStatement(sql);
            stmt.setString(0, user.getEmail());
            stmt.setString(1, user.getSenha());
            int i = stmt.executeUpdate();
            if(i>0){
                System.out.println("Usuario inserido");
            }else{
                System.out.println("falha ao inserir");
            }
            stmt.close();
            con.FecharConexao();
        }catch(SQLException ex){
            return false;
     }
     return true;
    }

}
