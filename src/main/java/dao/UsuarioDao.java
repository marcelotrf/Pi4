/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bd.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import servelet.LoginUsuario;



/**
 *
 * @author marce
 */
public class UsuarioDao 
{
     public static boolean verificaUsuario(String nome, String senha)
    {
        // declarar o retorno
//        Usuario usuario = null;
         try {
                Connection con = ConexaoBD.getConexao();
//                cuidado com nome repetido
                String query = "select * from usuario where nome=? and senha=?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, nome);
                ps.setString(2, senha);
//                stmt.setString(2, usuario.getSenha());
                ResultSet rs = ps.executeQuery();
                if(rs.next())
                {    
                    return true;
//                    String nomeExtenso = rs.getString("nomeExtenso"); 
//                    int qtdEstoque = rs.getInt("qtdEstoque"); 
//                    String status = rs.getString("status");
//                    usuario = new Produto(nome,nomeExtenso,status,qtdEstoque);                    
                }  
                else
                return false;
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(LoginUsuario.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(LoginUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
         return false;
        
    }
    
}
