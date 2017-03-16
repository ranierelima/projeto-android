package com.erroronserver.aplicativoprimeiroestagio.model;

import java.io.Serializable;

/**
 * Created by Raniere de Lima - contato@erroronserver.com on 14/03/2017.
 */

public class Usuario implements Serializable{

    private String login;
    private String senha;
    private Integer telefone;
    private String nome;
    private String email;

    public Usuario(){}


    public Usuario(String login, String senha, Integer telefone, String nome, String email){
        setLogin(login);
        setSenha(senha);
        setTelefone(telefone);
        setNome(nome);
        setEmail(email);
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

    public Integer getTelefone() {
        return telefone;
    }

    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Login: " + this.getLogin() + " Senha: " + this.getSenha()
        + " Telefone: " + this.getTelefone() + " Nome: " + this.getNome()
                + " E-mail: " + this.getEmail();
    }
}
