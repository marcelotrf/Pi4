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
public class Comprador 
{
    String nome;    
    String senha;    
    String email;
    String cpf;
    String logradouro;
    String bairro;
    String cidade;
    String uf;  
    String cep;
    int numeroL;
    
                
    public Comprador(String nome, String senha, String cpf, String email) {
        this.nome = nome;
        this.senha = senha;
        this.cpf = cpf;
        this.email = email;
    }

    public Comprador(String nome, String email, String cpf, String logradouro, String bairro, String cidade, String uf) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
    }

    public Comprador(String nome, String senha, String email, String cpf, String logradouro, String bairro, String cidade, String uf) {
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.cpf = cpf;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
    }
//// alterado para colocar numeroL
    public Comprador(String cpf, String logradouro, String bairro, String cidade, String uf, String cep, int numeroL) {
        this.cpf = cpf;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
        this.numeroL = numeroL;
    }
// adicionadoo numeroL para checkout
    public Comprador(String logradouro, String bairro, String cidade, String uf, String cep, int numeroL) {
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
        this.numeroL = numeroL;
    }   

      
    
    
    
    
    
    
public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public int getNumeroL() {
        return numeroL;
    }

    public void setNumeroL(int numeroL) {
        this.numeroL = numeroL;
    }       
    
}
