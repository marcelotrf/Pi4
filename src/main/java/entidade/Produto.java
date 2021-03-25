/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

/**
 *
 * @author marce
 */
public class Produto 
{
     private String nome;
     private String nomeExtenso;
     private int qtdEstrela;
     private String status;
     private int qtdEstoque;
     private double preco;
     private String statusAlt;

    public Produto(String nome, String nomeExtenso, int qtdEstrela, String status, int qtdEstoque, double preco) {
        this.nome = nome;
        this.nomeExtenso = nomeExtenso;
        this.qtdEstrela = qtdEstrela;
        this.status = status;
        this.qtdEstoque = qtdEstoque;
        this.preco = preco;
    }
     
     

    public Produto(String nome, String nomeExtenso, int qtdEstrela, int qtdEstoque, double preco) {
        this.nome = nome;
        this.nomeExtenso = nomeExtenso;
        this.qtdEstrela = qtdEstrela;
        this.qtdEstoque = qtdEstoque;
        this.preco = preco;
    }   

    public Produto(String nome, String nomeExtenso, int qtdEstoque) {
        this.nome = nome;
        this.nomeExtenso = nomeExtenso;
        this.qtdEstoque = qtdEstoque;
    }

    public Produto(String nome, String nomeExtenso, int qtdEstrela, int qtdEstoque, double preco, String status) {
        this.nome = nome;
        this.nomeExtenso = nomeExtenso;
        this.qtdEstrela = qtdEstrela;
        this.qtdEstoque = qtdEstoque;
        this.preco = preco;
        this.status = status;
    }

    public Produto(String nome, String nomeExtenso, String status, int qtdEstoque) {
        this.nome = nome;
        this.nomeExtenso = nomeExtenso;
        this.status = status;
        this.qtdEstoque = qtdEstoque;
    }

    public Produto(String statusAlt) {
        this.statusAlt = statusAlt;
    }

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }
    
    
    

    public Produto(String nome, String nomeExtenso, int qtdEstrela,  int qtdEstoque, double preco, String status, String statusAlt) {
        this.nome = nome;
        this.nomeExtenso = nomeExtenso;
        this.qtdEstrela = qtdEstrela;        
        this.qtdEstoque = qtdEstoque;
        this.preco = preco;
        this.status = status;
        this.statusAlt = statusAlt;
    }   
   
      
    public Produto(String nome, String nomeExtenso, String status, int qtdEstoque, String statusAlt) {
        this.nome = nome;
        this.nomeExtenso = nomeExtenso;
        this.status = status;
        this.qtdEstoque = qtdEstoque;
        this.statusAlt = statusAlt;
    }
public String getStatusAlt() {
        return statusAlt;
    }

    public void setStatusAlt(String statusAlt) {
        this.statusAlt = statusAlt;
    }
    
    

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
    
    
   
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeExtenso() {
        return nomeExtenso;
    }

    public void setNomeExtenso(String nomeExtenso) {
        this.nomeExtenso = nomeExtenso;
    }

    public int getQtdEstrela() {
        return qtdEstrela;
    }

    public void setQtdEstrela(int qtdEstrela) {
        this.qtdEstrela = qtdEstrela;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
//    @Override
//    public String toString() {
//        return String.format("Nome: %s <br/> "
//                + "Email: %s <br/> <hr/>", nome, nomeExtenso);
////        CPF %d <br/> removido temporariamente
//    }
    
     @Override
    public String toString() {
        return String.format("NomeExtenso: %s <br/> ", nomeExtenso);
//        CPF %d <br/> removido temporariamente
    }
     
     
            
    
}
