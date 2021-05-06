/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bd.ConexaoBD;
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
public class ProdutoDao 
{
    public static void addProduto(Produto produto) throws SQLException, ClassNotFoundException
    {
        Connection con = ConexaoBD.getConexao();        
        String query = "insert into produto(nome,nomeExtenso,qtdEstrela,qtdEstoque,preco,status) values (?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, produto.getNome());
        ps.setString(2, produto.getNomeExtenso());
        ps.setInt(3, produto.getQtdEstrela());
        ps.setInt(4, produto.getQtdEstoque());
        ps.setDouble(5, produto.getPreco());        
        ps.setString(6, produto.getStatus());        
        
        ps.execute();
        
    }
    
    public static List<Produto> getProduto()
    {
        List<Produto> listaProduto = new ArrayList();
        String statusAlt = "Ativo";
       // String statusAlt = request.getParameter("status");
//        if(statusAlt == null)
//        statusAlt = "Inativo";
        
//      apagar  String status = "Inativo";
         try {
                Connection con = ConexaoBD.getConexao();
                String query = "select * from produto";
                PreparedStatement ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                while(rs.next())
                {
                    String nome = rs.getString("nome");
                    String nomeExtenso = rs.getString("nomeExtenso");
                    int qtdEstrela = rs.getInt("qtdEstrela");
                    int qtdEstoque = rs.getInt("qtdEstoque");
                    double preco = rs.getDouble("preco");
                    String status = rs.getString("status");
                    //statusAlt = status;
                    if(status == null)
                        status = "Inativo";
                    if(status.equals("Ativo"))
            statusAlt = "Inativo";
        else
            statusAlt = "Ativo";

                    listaProduto.add(new Produto(nome,nomeExtenso,qtdEstrela,qtdEstoque,preco,status,statusAlt));                    

                }                    
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ListarProduto.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ListarProduto.class.getName()).log(Level.SEVERE, null, ex);
            }
         return listaProduto;
        
    }
    
    public static Produto getProduto(String nome)
    {
        // declarar o retorno
        Produto produto = null;
         try {
                Connection con = ConexaoBD.getConexao();
//                cuidado com nome repetido
                String query = "select * from produto where nome=?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, nome);
                ResultSet rs = ps.executeQuery();
                if(rs.next())
                {                    
                    String nomeExtenso = rs.getString("nomeExtenso"); 
                    int qtdEstoque = rs.getInt("qtdEstoque"); 
                    String status = rs.getString("status");
                    produto = new Produto(nome,nomeExtenso,status,qtdEstoque);                    
                }                    
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ListarProduto.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ListarProduto.class.getName()).log(Level.SEVERE, null, ex);
            }
         return produto;
        
    }
    
    public static Produto getProduto2(String nome)
    {
        // declarar o retorno
        Produto produto = null;
        String statusAlt = "Ativo";
         try {
                Connection con = ConexaoBD.getConexao();
//                cuidado com nome repetido
                String query = "select * from produto where nome=?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, nome);
                ResultSet rs = ps.executeQuery();
                if(rs.next())
                {                    
                    String nomeExtenso = rs.getString("nomeExtenso"); 
                    int qtdEstoque = rs.getInt("qtdEstoque"); 
                    String status = rs.getString("status");
                    if(status == null)
                        status = "Inativar";
                    if(status.equals("Ativo"))
            statusAlt = "Inativar";
        else
            statusAlt = "Ativar";
                    
                    produto = new Produto(nome,nomeExtenso,status,qtdEstoque,statusAlt);                    
                }                    
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ListarProduto.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ListarProduto.class.getName()).log(Level.SEVERE, null, ex);
            }
         return produto;
        
    }
    
    public static Produto getProdutoPP(String nome)
    {
        ///pp eh pagina principal
        // declarar o retorno
        Produto produto = null;
         try {
                Connection con = ConexaoBD.getConexao();
//                cuidado com nome repetido
                String query = "select * from produto where nome=?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, nome);
                ResultSet rs = ps.executeQuery();
                if(rs.next())
                {                    
                    String nomeExtenso = rs.getString("nomeExtenso"); 
                    double preco = rs.getDouble("preco");
//                    int qtdEstoque = rs.getInt("qtdEstoque"); 
//                    String status = rs.getString("status");
                    produto = new Produto(nomeExtenso,preco);                    
                }                    
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ListarProduto.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ListarProduto.class.getName()).log(Level.SEVERE, null, ex);
            }
         return produto;
        
    }
    
    public static void atualizarProduto(Produto produto) throws ClassNotFoundException, SQLException 
    {
        Connection con = ConexaoBD.getConexao();                  
        String query = "update produto set qtdEstoque=?,nomeExtenso=? where nome=? ";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, produto.getQtdEstoque());
        ps.setString(2, produto.getNomeExtenso());
        ps.setString(3, produto.getNome());             
        ps.execute();
        
    }
    
}
