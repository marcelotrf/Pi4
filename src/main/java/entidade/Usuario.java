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
public class Usuario 
{
    String nome;
    String login;
    String senha;
    String tipo;
    String email;
    String status;
    boolean administrador;
//    talvez tenha que mudar o administrador e login
    
    public Usuario(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public Usuario(String nome, String senha, String tipo, String email, String status) {
        this.nome = nome;
        this.senha = senha;
        this.tipo = tipo;
        this.email = email;
        this.status = status;
    }

    public Usuario(String nome, String tipo, String email) {
        this.nome = nome;
        this.tipo = tipo;
        this.email = email;
    }

    public Usuario(String nome, String senha, String tipo, String email) {
        this.nome = nome;
        this.senha = senha;
        this.tipo = tipo;
        this.email = email;
    }
    
    public Usuario() {
        
    }
    
    
    
    
    
    
    
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isAdministrador() {
        return administrador;
    }

    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
}
