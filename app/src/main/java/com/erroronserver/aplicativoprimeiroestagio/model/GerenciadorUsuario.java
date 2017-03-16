package com.erroronserver.aplicativoprimeiroestagio.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Raniere de Lima - contato@erroronserver.com on 14/03/2017.
 */
public class GerenciadorUsuario {

    private static List<Usuario> usuarios = new ArrayList<>();
    private static GerenciadorUsuario gerenciadorUsuario;
    private static Usuario usuario = null;
    private static int iContador = 0;

    private GerenciadorUsuario(){
        usuarios.add(new Usuario("admin","admin", 00112233445, "Administrador", "admin@admin.com"));
        usuarios.add(new Usuario("usuario","usuario", 566778899, "José", "jose@admin.com"));
        usuarios.add(new Usuario("a","a", 1133435, "Arlindo", "ar@alindo.com"));;
    }

    public static GerenciadorUsuario getInstance(){
        if(gerenciadorUsuario == null){
            gerenciadorUsuario = new GerenciadorUsuario();
        }
        return gerenciadorUsuario;
    }

    public Usuario verificaUsuario(String login, String senha){
        Usuario usuario = null;

        for (int i = 0 ; i < usuarios.size() ; i ++){
            Usuario user = usuarios.get(i);
            if(user.getLogin().equals(login) && user.getSenha().equals(senha)){
                usuario = user;
                this.usuario = usuario;
                iContador = i;
            }
        }
        return usuario;
    }

    public Usuario getUsuario(){
        return usuario;
    }

    public void editar(Usuario usuario) {

        usuarios.remove(iContador);
        usuarios.add(iContador, usuario);
        this.usuario = usuario;

    }

    public static List<Usuario> getUsuarios() {
        return usuarios;
    }
}
