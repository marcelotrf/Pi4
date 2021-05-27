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
public class CarrinhoE 
{
    private String nomeComprador;
    // produto
    private String nome;
    private int quantidade;
    private double preco;
    private double valorTotal;
    private int numeroOrdem;
    private String statusOrdem;
    private String nomeImagem;
    private double valorFinal;
    
   
    public CarrinhoE(String nomeComprador, String nome, int quantidade, double preco, String statusOrdem, String nomeImagem) {
        this.nomeComprador = nomeComprador;
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
        this.statusOrdem = statusOrdem;
        this.nomeImagem = nomeImagem;
    }
    
    // construtor para retornar quantidade de produto no carrinho e atualizar

    public CarrinhoE(int quantidade) {
        this.quantidade = quantidade;
    }
    // alterado para usar na lista de produto
    public CarrinhoE(String nomeComprador, String nome, int quantidade, double preco, String statusOrdem, String nomeImagem, double valorTotal, double valorFinal) {
        this.nomeComprador = nomeComprador;
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
        this.statusOrdem = statusOrdem;
        this.nomeImagem = nomeImagem;
        this.valorTotal = valorTotal;        
        this.valorFinal = valorFinal;        
    }

    public CarrinhoE(int numeroOrdem, double valorTotal, String statusOrdem) {
        this.numeroOrdem = numeroOrdem;
        this.valorTotal = valorTotal;
        this.statusOrdem = statusOrdem;
    }
    
    
    
    
    
    

    public String getNomeComprador() {
        return nomeComprador;
    }

    public void setNomeComprador(String nomeComprador) {
        this.nomeComprador = nomeComprador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getNumeroOrdem() {
        return numeroOrdem;
    }

    public void setNumeroOrdem(int numeroOrdem) {
        this.numeroOrdem = numeroOrdem;
    }

    public String getStatusOrdem() {
        return statusOrdem;
    }

    public void setStatusOrdem(String StatusOrdem) {
        this.statusOrdem = StatusOrdem;
    }

    public String getNomeImagem() {
        return nomeImagem;
    }

    public void setNomeImagem(String nomeImagem) {
        this.nomeImagem = nomeImagem;
    }

    public double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(double valorFinal) {
        this.valorFinal = valorFinal;
    }
    
    
    
    
    
}
