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
public class Imagem 
{
    private String nomeProduto;
     private String nomeImagem;   

    public Imagem(String nomeProduto, String nomeImagem) {
        this.nomeProduto = nomeProduto;
        this.nomeImagem = nomeImagem;
    }
    

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getNomeImagem() {
        return nomeImagem;
    }

    public void setNomeImagem(String nomeImagem) {
        this.nomeImagem = nomeImagem;
    }
     
     
}


