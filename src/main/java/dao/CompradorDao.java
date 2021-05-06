/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bd.ConexaoBD;
import entidade.Comprador;
import entidade.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import servelet.ListarFuncionario;
import servelet.LoginUsuario;

/**
 *
 * @author marce
 */
public class CompradorDao {

    public static void addComprador(Comprador comprador) throws ClassNotFoundException, SQLException {
        Connection con = ConexaoBD.getConexao();
        String query = "insert into comprador(nome,senha,cpf,email) values (?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, comprador.getNome());
        ps.setString(2, comprador.getSenha());
        ps.setString(3, comprador.getCpf());
        ps.setString(4, comprador.getEmail());

        ps.execute();

    }

    public static boolean verificaDados(String email, String cpf) {
       // declarar o retorno
//        Usuario usuario = null;
         try {
                Connection con = ConexaoBD.getConexao();
//                cuidado com nome repetido
                String query = "select * from comprador where email=? ";
                PreparedStatement ps = con.prepareStatement(query);
                // passando o parametro email para o banco
                ps.setString(1, email);
//                ps.setString(2, senha);
//                stmt.setString(2, usuario.getSenha());
                ResultSet rs = ps.executeQuery();
                if(rs.next())
                {  
                    String cpfBanco = rs.getString("cpf"); 
//                    compara para ver se eh o mesmo cpf
                    return cpfBanco.equals(cpf);//                    String nomeExtenso = rs.getString("nomeExtenso");
//                    int qtdEstoque = rs.getInt("qtdEstoque"); 
//                    String status = rs.getString("status");
//                    usuario = new Produto(nome,nomeExtenso,status,qtdEstoque);                    
//                    retorna se cpf for igual do banco
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
    
     public static boolean verificaUsuario(String email, String senha)
    {
        // declarar o retorno
//        Comprador usuario = new Comprador();
         try {
                Connection con = ConexaoBD.getConexao();
//                cuidado com nome repetido
                String query = "select * from comprador where email=? and senha=?";
                PreparedStatement ps = con.prepareStatement(query);
                // passando o parametro email para o banco
                ps.setString(1, email);
                ps.setString(2, senha);
//                stmt.setString(2, usuario.getSenha());
                ResultSet rs = ps.executeQuery();
                if(rs.next())
                {    
//                    String tipo = rs.getString("tipo"); 
//                    String status = rs.getString("status"); 
//                    usuario.setTipo(tipo);
//                    usuario.setStatus(status);
//                    verifica se usuario esta ativo
//                    return status.equals("Ativado");
//                    String nomeExtenso = rs.getString("nomeExtenso");
//                    int qtdEstoque = rs.getInt("qtdEstoque"); 
//                    String status = rs.getString("status");
//                    usuario = new Produto(nome,nomeExtenso,status,qtdEstoque); 
                    return true;
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
     
      public static Comprador getComprador(String email)
    {
        // declarar o retorno
        Comprador comprador = null;
         try {
                Connection con = ConexaoBD.getConexao();
//                cuidado com nome repetido
                String query = "select * from comprador where email=?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, email);
                ResultSet rs = ps.executeQuery();
                if(rs.next())
                {                    
//                    String email = rs.getString("email");  
                    String nome = rs.getString("nome");
                    String cpf = rs.getString("cpf");                    
                    String logradouro = rs.getString("logradouro");
                    String bairro = rs.getString("bairro");
                    String cidade = rs.getString("cidade");
                    String uf = rs.getString("uf");
                    comprador = new Comprador(nome,email,cpf,logradouro,bairro,cidade,uf);   
                    
                }                    
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ListarFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ListarFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            }
         return comprador;
        
    }
      
      public static void atualizarComprador(Comprador comprador) throws ClassNotFoundException, SQLException 
    {
        Connection con = ConexaoBD.getConexao();                  
        String query = "update comprador set nome=?,cpf=?,logradouro=?,bairro=?,cidade=?,uf=? where email=? ";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, comprador.getNome());
//        ps.setString(2, comprador.getSenha());
        ps.setString(2, comprador.getCpf());             
        ps.setString(3, comprador.getLogradouro());             
        ps.setString(4, comprador.getBairro());             
        ps.setString(5, comprador.getCidade());             
        ps.setString(6, comprador.getUf());             
        ps.setString(7, comprador.getEmail());             
        ps.execute();        
    }
      
      public static void addEnderecoEntrega(Comprador comprador) throws SQLException, ClassNotFoundException
    {
        Connection con = ConexaoBD.getConexao();        
        String query = "insert into enderecoentrega(cpf,logradouro,bairro,cidade,uf) values (?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(query);
//        ps.setString(1, comprador.getNome());
//        ps.setString(2, comprador.getSenha());
        ps.setString(1, comprador.getCpf());             
        ps.setString(2, comprador.getLogradouro());             
        ps.setString(3, comprador.getBairro());             
        ps.setString(4, comprador.getCidade());             
        ps.setString(5, comprador.getUf());             
//        ps.setString(7, comprador.getEmail());         
        
        ps.execute();
        
    }
      
      public static List<Comprador> getEnderecoE(String cpf)
    {
        // declarar o retorno
        List<Comprador> listaEnderecoE = new ArrayList();
//        Comprador enderecoE = null;
         try {
                Connection con = ConexaoBD.getConexao();
//                cuidado com nome repetido
                String query = "select * from enderecoEntrega where cpf=?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, cpf);
                ResultSet rs = ps.executeQuery();
                // acho que while pega valor repetido, if pega so o primeiro
                while(rs.next())
//                if(rs.next())
                {                    
                    String logradouro = rs.getString("logradouro");
                    String bairro = rs.getString("bairro");
                    String cidade = rs.getString("cidade");
                    String uf = rs.getString("uf");
                    listaEnderecoE.add(new Comprador(cpf,logradouro,bairro,cidade,uf));  
//                    enderecoE = new Comprador(cpf,logradouro,bairro,cidade,uf);                    
                }                    
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ListarFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ListarFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            }
         return listaEnderecoE;
        
    }

}
