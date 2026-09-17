package api.service;

import api.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioService {

    private final ArrayList<Usuario> usuarios = new ArrayList<>();

    private int proximoId = 1;

    // CREATE
    public Usuario cadastrar(String nome, String email){

        Usuario usuario = new Usuario(proximoId, nome, email);
        usuarios.add(usuario);

        proximoId++;

        return usuario;
    }

    // READ
    public List<Usuario> listar(){
        return usuarios;
    }

    public Usuario buscarPorId(int id){
        for(int i = 0; i < usuarios.size(); i++){
            Usuario usuario = usuarios.get(i);

            if(usuario.getId() == id){
                return usuario;
            }
        }
        return null;
    }

    // UPDATE
    public Usuario atualizar(int id, String nome, String email){
        Usuario usuario = buscarPorId(id);
        if(usuario == null){
            return null;
        }

        usuario.setNome(nome);
        usuario.setEmail(email);

        return usuario;
    }

    // DELETE
    public boolean remover(int id){

        Usuario usuario = buscarPorId(id);

        if (usuario == null){
            return false;
        }

        usuarios.remove(usuario);

        return true;
    }
}
