/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifsp.pwe.contatos.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao {
    static Connection connection = null;
    //Possibilita instancias
 public Conexao () {
 
 } 

public static Connection getConexao() {
          //atributo do tipo Connection
        try {
          Connection connection = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/contatos", "root", "");
                 if (connection != null) {
                   System.out.println("Connected");
                 }
        }catch(SQLException ex) {
        ex.printStackTrace();
        }
        return connection;
}
public static boolean FecharConexao() {
 
        try {
            Conexao.getConexao().close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
}
