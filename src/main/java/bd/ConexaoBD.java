/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marce
 */
public class ConexaoBD 
{
    //Singleton - bloco static
    
    static
    {
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");// driver do meu banco        
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
        
    
    public static Connection getConexao() throws ClassNotFoundException, SQLException
    {
//        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");// driver do meu banco
        
        String url="jdbc:derby://localhost:1527//senac";
        String user="senac";
        String password="senac";        
        return DriverManager.getConnection(url,user,password);
    }
    
}
