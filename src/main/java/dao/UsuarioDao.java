/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bd.ConexaoBD;
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
public class UsuarioDao 
{       
     public static boolean verificaUsuario(String email, String senha)
    {
        // declarar o retorno
        Usuario usuario = new Usuario();
         try {
                Connection con = ConexaoBD.getConexao();
//                cuidado com nome repetido
                String query = "select * from usuario where email=? and senha=?";
                PreparedStatement ps = con.prepareStatement(query);
                // passando o parametro email para o banco
                ps.setString(1, email);
                ps.setString(2, senha);
//                stmt.setString(2, usuario.getSenha());
                ResultSet rs = ps.executeQuery();
                if(rs.next())
                {    
                    String tipo = rs.getString("tipo"); 
                    String status = rs.getString("status"); 
//                    usuario.setTipo(tipo);
//                    usuario.setStatus(status);
//                    verifica se usuario esta ativo
                    return status.equals("Ativado");
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
     
     public static byte[] encripitar(byte[] data)
    {
        byte[] enc = new byte[data.length];
        
        for (int i = 0; i < data.length; i++) 
        {
            enc[i] = (byte) ((i%2 ==0) ? data[i] + 1 : data[i] - 1);
            
        }        
        return enc;
    }
    
    public static byte[] descripitar(byte[] data)
    {
        byte[] enc = new byte[data.length];
        
        for (int i = 0; i < data.length; i++) 
        {
            enc[i] = (byte) ((i%2 ==0) ? data[i] - 1 : data[i] + 1);
            
        }        
        return enc;
    }
    
    public static void addUsuario(Usuario usuario) throws ClassNotFoundException, SQLException
    {        
        Connection con = ConexaoBD.getConexao();
        String query = "insert into usuario(nome,senha,tipo,email,status) values (?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, usuario.getNome());
        ps.setString(2, usuario.getSenha());
        ps.setString(3, usuario.getTipo());
        ps.setString(4, usuario.getEmail());
        ps.setString(5, usuario.getStatus());
//        ps.setLong(3, cliente.getCpf());
        
        ps.execute();
        
    }
    
    public static boolean verificaEmail(String email)
    {
        // declarar o retorno
//        Usuario usuario = null;
         try {
                Connection con = ConexaoBD.getConexao();
//                cuidado com nome repetido
                String query = "select * from usuario where email=? ";
                PreparedStatement ps = con.prepareStatement(query);
                // passando o parametro email para o banco
                ps.setString(1, email);
//                ps.setString(2, senha);
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
    
     public static List<Usuario> getUsuario()
    {
        List<Usuario> listaFuncionario = new ArrayList();
        
//      nao sei pra que serve  String statusAlt = "Ativo";
       // String statusAlt = request.getParameter("status");
//        if(statusAlt == null)
//        statusAlt = "Inativo";
        
//      apagar  String status = "Inativo";
         try {
                Connection con = ConexaoBD.getConexao();
                String query = "select * from usuario";
                PreparedStatement ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                while(rs.next())
                {                   
                    String nome = rs.getString("nome");
                    String tipo = rs.getString("tipo");
//                    int qtdEstrela = rs.getInt("qtdEstrela");
//                    int qtdEstoque = rs.getInt("qtdEstoque");
//                    double preco = rs.getDouble("preco");
                    String email = rs.getString("email");
                    //statusAlt = status;
//                    if(status == null)
//                        status = "Inativo";
//                    if(status.equals("Ativo"))
//            statusAlt = "Inativo";
//        else
//            statusAlt = "Ativo";
//                    criar construtor
                    listaFuncionario.add(new Usuario(nome,tipo,email));                    

                }                    
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ListarFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ListarFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            }
         return listaFuncionario;
        
    }
     
      public static Usuario getUsuario(String nome)
    {
        // declarar o retorno
        Usuario funcionario = null;
         try {
                Connection con = ConexaoBD.getConexao();
//                cuidado com nome repetido
                String query = "select * from usuario where nome=?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, nome);
                ResultSet rs = ps.executeQuery();
                if(rs.next())
                {                    
                    String email = rs.getString("email");               
                    String tipo = rs.getString("tipo");
                    funcionario = new Usuario(nome,tipo,email);                    
                }                    
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ListarFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ListarFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            }
         return funcionario;
        
    }
      
      public static void atualizarFuncionario(Usuario funcionario) throws ClassNotFoundException, SQLException 
    {
        Connection con = ConexaoBD.getConexao();                  
        String query = "update usuario set nome=?,tipo=?,senha=? where email=? ";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, funcionario.getNome());
        ps.setString(2, funcionario.getTipo());
        ps.setString(3, funcionario.getSenha());             
        ps.setString(4, funcionario.getEmail());             
        ps.execute();
        
    }
      
      public static String getStatus(String email)
    {
        // declarar o retorno
        String status = "Ativado";
         try {
                Connection con = ConexaoBD.getConexao();
//                cuidado com nome repetido
                String query = "select * from usuario where email=? ";
                PreparedStatement ps = con.prepareStatement(query);
                // passando o parametro email para o banco
                ps.setString(1, email);
//                ps.setString(2, senha);
//                stmt.setString(2, usuario.getSenha());
                ResultSet rs = ps.executeQuery();                
                if(rs.next())
                {    
                    status = rs.getString("status");
//                    if(status.equals("Ativado"))
//                        status = "Desativado";
//                    else
//                        return status;
                    return status;
//                    String nomeExtenso = rs.getString("nomeExtenso"); 
//                    int qtdEstoque = rs.getInt("qtdEstoque"); 
//                    String status = rs.getString("status");
//                    usuario = new Produto(nome,nomeExtenso,status,qtdEstoque);                    
                } 
                else
                    return status;
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(LoginUsuario.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(LoginUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
         return status;
        
    }
      
       public static String statusAlternado(String status)
    {
        // declarar o retorno
//         status = "Ativado";
         
                    if(status.equals("Ativado"))
                        status = "Desativar";
                    else
                    {
                        status = "Ativar";
                        return status;
                    }
                        
                    return status;
                  
        
    }
       
       public static void atualizarStatus(Usuario funcionario) throws ClassNotFoundException, SQLException 
    {
//        String status = funcionario.getStatus();
        if(funcionario.getStatus().equals("Ativado"))
        funcionario.setStatus("Desativado");
        else
        funcionario.setStatus("Ativado");
        Connection con = ConexaoBD.getConexao();                  
        String query = "update usuario set status=? where email=? ";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, funcionario.getStatus());                  
        ps.setString(2, funcionario.getEmail());             
        ps.execute();
        
    }
       
       public static boolean verificaUsuarioFuncionario(String email, String senha)
    {
        // declarar o retorno
        Usuario usuario = new Usuario();
         try {
                Connection con = ConexaoBD.getConexao();
//                cuidado com nome repetido
                String query = "select * from usuario where email=? and senha=?";
                PreparedStatement ps = con.prepareStatement(query);
                // passando o parametro email para o banco
                ps.setString(1, email);
                ps.setString(2, senha);
//                stmt.setString(2, usuario.getSenha());
                ResultSet rs = ps.executeQuery();
                if(rs.next())
                {    
//                    String tipo = rs.getString("tipo"); 
                    String status = rs.getString("status"); 
//                    usuario.setTipo(tipo);
//                    usuario.setStatus(status);
//                    verifica se usuario esta ativo
                    return status !=null;
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
       
       public static Usuario getTipoUsuario(String email)
    {
        // declarar o retorno
        Usuario funcionario = null;
         try {
                Connection con = ConexaoBD.getConexao();
//                cuidado com nome repetido
                String query = "select * from usuario where email=?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, email);
                ResultSet rs = ps.executeQuery();
                if(rs.next())
                {                    
                    String nome = rs.getString("nome");               
                    String tipo = rs.getString("tipo");
                    funcionario = new Usuario(nome,tipo,email);                    
                }                    
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ListarFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ListarFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            }
         return funcionario;
        
    }
    
}
