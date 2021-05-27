/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bd.ConexaoBD;
import entidade.CarrinhoE;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import servelet.ListarPedido;
import servelet.LoginUsuario;

/**
 *
 * @author marce
 */
public class CarrinhoDao {

    public static void CriarCarrinho(CarrinhoE carrinho) throws ClassNotFoundException, SQLException {
        Connection con = ConexaoBD.getConexao();
        String query = "insert into carrinho(nomeComprador,nome,quantidade,preco,statusOrdem,nomeImagem) values (?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, carrinho.getNomeComprador());
        ps.setString(2, carrinho.getNome());
        ps.setInt(3, carrinho.getQuantidade());
        ps.setDouble(4, carrinho.getPreco());
        ps.setString(5, carrinho.getStatusOrdem());
        ps.setString(6, carrinho.getNomeImagem());

        ps.execute();

    }

    // acho que ainda nao usou
    public static void AddProdutoCarrinho(CarrinhoE carrinho) throws ClassNotFoundException, SQLException {
        Connection con = ConexaoBD.getConexao();
        String query = "insert into carrinho(nomeComprador,nome,quantidade,preco,statusOrdem) values (?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, carrinho.getNomeComprador());
        ps.setString(2, carrinho.getNome());
        ps.setInt(3, carrinho.getQuantidade());
        ps.setDouble(4, carrinho.getPreco());
        ps.setString(5, carrinho.getStatusOrdem());
        ps.setString(6, carrinho.getNomeImagem());

        ps.execute();

    }

    public static boolean verificaProdutoCarrinho(String nome) {
        // declarar o retorno
//        Usuario usuario = null;
        String statusOrdem = "Aberto";
        try {
            Connection con = ConexaoBD.getConexao();
//                cuidado com nome repetido
//            String query = "select nome from carrinho where statusOrdem=? ";
            String query = "select * from carrinho where nome=? and statusOrdem=?";
            PreparedStatement ps = con.prepareStatement(query);
            // passando o parametro email para o banco
            ps.setString(1, nome);
            ps.setString(2, statusOrdem);
//                ps.setString(2, senha);
//                stmt.setString(2, usuario.getSenha());
            ResultSet rs = ps.executeQuery();
            // se achar produto esta repetido
            if (rs.next()) {
//                    String cpfBanco = rs.getString("cpf"); 
//                    compara para ver se eh o mesmo cpf
//                    return cpfBanco.equals(cpf);//                    String nomeExtenso = rs.getString("nomeExtenso");
                return true;//                    String nomeExtenso = rs.getString("nomeExtenso");
//                    int qtdEstoque = rs.getInt("qtdEstoque"); 
//                    String status = rs.getString("status");
//                    usuario = new Produto(nome,nomeExtenso,status,qtdEstoque);                    
//                    retorna se cpf for igual do banco
            } else {
                return false;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
        ///////////////////////////teste////////////////////////////////
//    public static boolean verificaUsuarioFuncionario(String email, String senha) {
//        // declarar o retorno
//        Usuario usuario = new Usuario();
//        try {
//            Connection con = ConexaoBD.getConexao();
////                cuidado com nome repetido
//            String query = "select * from usuario where email=? and senha=?";
//            PreparedStatement ps = con.prepareStatement(query);
//            // passando o parametro email para o banco
//            ps.setString(1, email);
//            ps.setString(2, senha);
////                stmt.setString(2, usuario.getSenha());
//            ResultSet rs = ps.executeQuery();
//            if (rs.next()) {
////                    String tipo = rs.getString("tipo"); 
//                String status = rs.getString("status");
////                    usuario.setTipo(tipo);
////                    usuario.setStatus(status);
////                    verifica se usuario esta ativo
//                return status != null;
////                    String nomeExtenso = rs.getString("nomeExtenso");
////                    int qtdEstoque = rs.getInt("qtdEstoque"); 
////                    String status = rs.getString("status");
////                    usuario = new Produto(nome,nomeExtenso,status,qtdEstoque);                    
//            } else {
//                return false;
//            }
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(LoginUsuario.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(LoginUsuario.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return false;

//    }
    }

    public static void Add1Produto(String nome, int quantidade) throws ClassNotFoundException, SQLException {
        Connection con = ConexaoBD.getConexao();
        String query = "update carrinho set quantidade=? where nome=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, quantidade);
        ps.setString(2, nome);

        ps.execute();

////////////////////////////////fim teste//////////////////////////////////////
    }

    public static CarrinhoE QuantidadePCarrinho(String nome) {
        // declarar o retorno
        String statusOrdem= "Aberto";
        CarrinhoE carrinho = null;
        try {
            Connection con = ConexaoBD.getConexao();
//                cuidado com nome repetido
            String query = "select * from carrinho where nome=? and statusOrdem=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, nome);
            ps.setString(2, statusOrdem);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
//                    String email = rs.getString("email");  
//                    String nome = rs.getString("nome");
//                    String cpf = rs.getString("cpf");                    
//                    String logradouro = rs.getString("logradouro");
//                    String bairro = rs.getString("bairro");
//                    String cidade = rs.getString("cidade");
//                    String uf = rs.getString("uf");
                int quantidade = rs.getInt("quantidade");
                quantidade++;
                carrinho = new CarrinhoE(quantidade);

            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginUsuario.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginUsuario.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return carrinho;

    }

    public static List<CarrinhoE> getProdutoCarrinho() {
        List<CarrinhoE> listaProduto = new ArrayList();
        try {
            String statusOrdem = "Aberto";
            Connection con = ConexaoBD.getConexao();
            String query = "select * from carrinho where statusOrdem=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, statusOrdem);
            ResultSet rs = ps.executeQuery();
            double valorFinal = 0;
            while (rs.next()) {

                String nomeComprador = rs.getString("nomeComprador");
                String nome = rs.getString("nome");
                int quantidade = rs.getInt("quantidade");
                double preco = rs.getDouble("preco");
                String nomeImagem = rs.getString("nomeImagem");

                double valorTotal = (double) quantidade * preco;

                valorFinal = valorFinal + valorTotal;
//                    String statusOrdem = rs.getString("statusOrdem");                                       
// aproveitando construtor
                listaProduto.add(new CarrinhoE(nomeComprador, nome, quantidade, preco, statusOrdem, nomeImagem, valorTotal, valorFinal));

            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginUsuario.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginUsuario.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return listaProduto;

    }

//      usado apenas para teste
//      public static void atualizarNomeImagem() throws ClassNotFoundException, SQLException 
//    {
//        String nomeImagem = "Sapatilha Dourada Viper Skin 1.jpg";
//        int quantidade = 3;
//        Connection con = ConexaoBD.getConexao();                  
//        String query = "update carrinho set nomeImagem=? where quantidade=? ";
//        PreparedStatement ps = con.prepareStatement(query);
//        ps.setString(1, nomeImagem);
////        ps.setString(2, comprador.getSenha());
//        ps.setInt(2, quantidade);            
//                     
//        ps.execute();        
//    }
    public static CarrinhoE CalculoValorTotal(String nome) {
        // declarar o retorno
        CarrinhoE carrinho = null;
        try {
            Connection con = ConexaoBD.getConexao();
//                cuidado com nome repetido
            String query = "select * from carrinho where nome=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
//                    String email = rs.getString("email");  
//                    String nome = rs.getString("nome");
//                    String cpf = rs.getString("cpf");                    
//                    String logradouro = rs.getString("logradouro");
//                    String bairro = rs.getString("bairro");
//                    String cidade = rs.getString("cidade");
//                    String uf = rs.getString("uf");
                int quantidade = rs.getInt("quantidade");
                quantidade++;
                carrinho = new CarrinhoE(quantidade);

            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginUsuario.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginUsuario.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return carrinho;

    }

    public static int CalculoFrete(int cep) {
        int valorFrete = 0;

        cep = cep % 2;
        if (cep == 0) {
            valorFrete = 10;

        } //        else if(cep>0)
        //        {
        //            valorFrete = 15;
        //            
        //            
        //        }
        else if (cep < 0) {
            valorFrete = 1000;

        }

        return valorFrete;

    }

    public static void AddNomeComprador(String nome) throws ClassNotFoundException, SQLException {
        Connection con = ConexaoBD.getConexao();
        String statusOrdem = "Aberto";
        String query = "update carrinho set nomeComprador=? where statusOrdem=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, nome);
        ps.setString(2, statusOrdem);

        ps.execute();

    }

    public static void ConcluirOrdem(int numeroOrdem) throws ClassNotFoundException, SQLException {

        Connection con = ConexaoBD.getConexao();
        String statusOrdem = "Aberto";
//        fechar a ordem
        String statusOrdemF = "Aguardando pagamento";
//        int numeroOrdem = 1;
        String query = "update carrinho set numeroOrdem=?,statusOrdem=? where statusOrdem=?";
        PreparedStatement ps = con.prepareStatement(query);
//        ps.setString(1, statusOrdemF);
        ps.setInt(1, numeroOrdem);
        ps.setString(2, statusOrdemF);
        ps.setString(3, statusOrdem);

        ps.execute();

        //        Connection con = ConexaoBD.getConexao();
//        String statusOrdem = "Aberto";
////        fechar a orde
////        String statusOrdemF = "Fechado";
//        int numeroOrdem = 1;
//        String query = "update carrinho set numeroOrdem=? where statusOrdem=?";            
//        PreparedStatement ps = con.prepareStatement(query);
////        ps.setString(1, statusOrdemF);
//        ps.setInt(1, numeroOrdem);
//        ps.setString(2, statusOrdem);
//
//        ps.execute();
        ////////////////////////////////tste
    }

    public static void ConcluirOrdemFechar() throws ClassNotFoundException, SQLException {
        Connection con = ConexaoBD.getConexao();
        String statusOrdem = "Fecahdo";//        fechar a orde
//        
        int numeroOrdem = 1;
        String query = "update carrinho set numeroOrdem=? where numeroOrdem=?";
        PreparedStatement ps = con.prepareStatement(query);
//        ps.setString(1, statusOrdemF);
        ps.setString(1, statusOrdem);
        ps.setInt(2, numeroOrdem);

        ps.execute();

    }

    public static int getNumeroOrdem() {
        // declarar o retorno
//        CarrinhoE carrinho = null;
        int numeroOrdem =1 ;
        List<CarrinhoE> listaProduto = new ArrayList();
        try {
            Connection con = ConexaoBD.getConexao();
//                cuidado com nome repetido
            String query = "select * from carrinho";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
//                    String email = rs.getString("email");  
//                    String nome = rs.getString("nome");
//                    String cpf = rs.getString("cpf");                    
//                    String logradouro = rs.getString("logradouro");
//                    String bairro = rs.getString("bairro");
//                    String cidade = rs.getString("cidade");
//                    String uf = rs.getString("uf");
                int numeroOrdemB = rs.getInt("numeroOrdem");
                if(numeroOrdem<numeroOrdemB)
                {
                    numeroOrdem = numeroOrdemB;
                }
                
//                quantidade++;
               // listaProduto.add(new CarrinhoE(numeroOrdem));

            }
//            numeroOrdem++;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginUsuario.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginUsuario.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return numeroOrdem = numeroOrdem +1;

    }

    public static void ApagarItemCarrinho(String nome) {
        // declarar o retorno
//        CarrinhoE carrinho = null;
        String statusOrdem = "Aberto";
        try {
            Connection con = ConexaoBD.getConexao();
//                cuidado com nome repetido
            String query = "delete from carrinho where nome=? and statusOrdem=?";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, nome);
            ps.setString(2, statusOrdem);
            ps.execute();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginUsuario.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginUsuario.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static List<CarrinhoE> getPedidos()
    {
        List<CarrinhoE> listaPedido = new ArrayList();
        int numeroMesmaOrdem = 1;
//        String statusAlt = "Ativo";
       // String statusAlt = request.getParameter("status");
//        if(statusAlt == null)
//        statusAlt = "Inativo";
        
//      apagar  String status = "Inativo";
         try {
                Connection con = ConexaoBD.getConexao();
                String query = "select * from carrinho";
                PreparedStatement ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                while(rs.next())
                {
//                    String nome = rs.getString("nome");
//                    String nomeExtenso = rs.getString("nomeExtenso");
                    int numeroOrdem = rs.getInt("numeroOrdem");
//                    int qtdEstoque = rs.getInt("qtdEstoque");
//                    double preco = rs.getDouble("preco");
                    // nao tem valor total ainda
                    double valorTotal = rs.getDouble("preco");
                    String statusOrdem = rs.getString("statusOrdem");
                    listaPedido.add(new CarrinhoE(numeroOrdem,valorTotal,statusOrdem));  
                    //statusAlt = status;
//                    if(status == null)
//                        status = "Inativo";
//                    if(status.equals("Ativo"))
//            statusAlt = "Inativo";
//        else
//            statusAlt = "Ativo";
                /////////// depois pensar em uma logica///////////////////
//                    if(numeroOrdem > numeroMesmaOrdem)
//                    {
//                        listaPedido.add(new CarrinhoE(numeroMesmaOrdem,valorTotal,statusOrdem));  
//                        numeroMesmaOrdem++;
//                    }
//                    else
//                    {
//                        
//                    }
                    
                                      

                }                    
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ListarPedido.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ListarPedido.class.getName()).log(Level.SEVERE, null, ex);
            }
         return listaPedido;
        
    }
    
    public static List<CarrinhoE> alterarNumeroOrdem(int numeroOrdem) {
        // declarar o retorno
       List<CarrinhoE> ordem = new ArrayList();        
        
        try {
            Connection con = ConexaoBD.getConexao();
            String query = "select * from carrinho where numeroOrdem=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, numeroOrdem);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                               
                    double valorTotal = rs.getDouble("preco");
                    String statusOrdem = rs.getString("statusOrdem");
                    ordem.add(new CarrinhoE(numeroOrdem,valorTotal,statusOrdem));  
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginUsuario.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginUsuario.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return ordem;

    }
    
     public static void alterarSatusOrdem(String statusOrdem, int numeroOrdem) throws ClassNotFoundException, SQLException {

        Connection con = ConexaoBD.getConexao();
  
        String query = "update carrinho set statusOrdem=? where numeroOrdem=?";
        PreparedStatement ps = con.prepareStatement(query);

        ps.setString(1, statusOrdem);
        ps.setInt(2, numeroOrdem);        

        ps.execute();
       
    }
     
     public static List<CarrinhoE> getPedidosComprador(String nomeComprador)
    {
        List<CarrinhoE> listaPedido = new ArrayList();        
         try {
                Connection con = ConexaoBD.getConexao();                
                String query = "select * from carrinho where nomeComprador=?";
                PreparedStatement ps = con.prepareStatement(query);
                 ps.setString(1, nomeComprador);
                ResultSet rs = ps.executeQuery();
                while(rs.next())
                {
//                   
                    int numeroOrdem = rs.getInt("numeroOrdem");//                    
                    double valorTotal = rs.getDouble("preco");
                    String statusOrdem = rs.getString("statusOrdem");
                    listaPedido.add(new CarrinhoE(numeroOrdem,valorTotal,statusOrdem));  

                }                    
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ListarPedido.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ListarPedido.class.getName()).log(Level.SEVERE, null, ex);
            }
         return listaPedido;
        
    }
     
     public static List<CarrinhoE> getPedidoCarrinho(int numeroOrdem) {
        List<CarrinhoE> listaProduto = new ArrayList();
        try {            
            Connection con = ConexaoBD.getConexao();
            String query = "select * from carrinho where numeroOrdem=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, numeroOrdem);
            ResultSet rs = ps.executeQuery();
            double valorFinal = 0;
            while (rs.next()) {

                String nomeComprador = rs.getString("nomeComprador");
                String nome = rs.getString("nome");
                int quantidade = rs.getInt("quantidade");
                double preco = rs.getDouble("preco");
                String nomeImagem = rs.getString("nomeImagem");
                String statusOrdem = rs.getString("statusOrdem");

                double valorTotal = (double) quantidade * preco;

                valorFinal = valorFinal + valorTotal;
//                    String statusOrdem = rs.getString("statusOrdem");                                       
// aproveitando construtor
                listaProduto.add(new CarrinhoE(nomeComprador, nome, quantidade, preco, statusOrdem, nomeImagem, valorTotal, valorFinal));

            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginUsuario.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginUsuario.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return listaProduto;

    }

}
