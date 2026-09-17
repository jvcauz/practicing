package api;

import api.handler.UsuarioHandler;
import api.service.UsuarioService;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Main {

    public static void main(String[] args) throws IOException {

        UsuarioService usuarioService = new UsuarioService();

        HttpServer servidor = HttpServer.create(new InetSocketAddress(8080),0);

        servidor.createContext("/usuarios", new UsuarioHandler(usuarioService));

        servidor.start();

        System.out.println("Servidor rodando em http://localhost:8080");
    }
}
