/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bd.ConexaoBD;
import entidade.Imagem;
import entidade.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import servelet.ListarProduto;

/**
 *
 * @author marce
 */
public class ImagemDao 
{
    public static void addImagem(Imagem imagem) throws SQLException, ClassNotFoundException
    {
        
        Connection con = ConexaoBD.getConexao();        
        String query = "insert into imagem(nomeProduto,nomeImagem) values (?,?)";
        PreparedStatement ps = con.prepareStatement(query);
//        ps.setString(1, produto.getNome());
        ps.setString(1, imagem.getNomeProduto());
        ps.setString(2, imagem.getNomeImagem());               
        
        ps.execute();        
        
    }
    
    public static List<Imagem> getImagem(String nomeProduto)
    {
        List<Imagem> listaImagem = new ArrayList();
        
         try {
                Connection con = ConexaoBD.getConexao();
                String query = "select * from imagem where nomeProduto=?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, nomeProduto);
                ResultSet rs = ps.executeQuery();
                while(rs.next())
                {
//                    String nome = rs.getString("nomeProduto");
                    String nomeImagem = rs.getString("nomeImagem");                   

                    listaImagem.add(new Imagem(nomeProduto,nomeImagem));                     

                }                    
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ListarProduto.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ListarProduto.class.getName()).log(Level.SEVERE, null, ex);
            }
         return listaImagem;
        
    }
    
    public static boolean VerificaImagem(String nomeProduto,String nomeImagem)
    {
//        List<Imagem> listaImagem = new ArrayList();
        boolean verifica=false;
        
         try {
                Connection con = ConexaoBD.getConexao();
                String query = "select nomeProduto from imagem where nomeImagem=? and nomeProduto=?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, nomeImagem);
                ps.setString(2, nomeProduto);
                ResultSet rs = ps.executeQuery();
                while(rs.next())
                {
//                    String nome = rs.getString("nomeProduto");
//                    String nomeImagem = rs.getString("nomeImagem");                   
//
//                    listaImagem.add(new Imagem(nomeProduto,nomeImagem));
                  String  nomeProduto2 = rs.getString("nomeProduto");
                  if(nomeProduto.equals(nomeProduto2))
verifica = true;                    

                }                    
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ListarProduto.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ListarProduto.class.getName()).log(Level.SEVERE, null, ex);
            }
         return verifica;
        
    }
    
}
