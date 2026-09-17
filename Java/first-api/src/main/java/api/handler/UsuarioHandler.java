package api.handler;

import api.model.Usuario;
import api.service.UsuarioService;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UsuarioHandler implements HttpHandler {

    private final UsuarioService service;

    public UsuarioHandler(UsuarioService service){
        this.service = service;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {

        String metodo = exchange.getRequestMethod();

        switch (metodo) {
            case "GET":
                handleGet(exchange);
                break;
            case "POST":
                handlePost(exchange);
                break;
            case "PUT":
                handlePut(exchange);
                break;
            case "DELETE":
                handleDelete(exchange);
                break;
            default:
                sendResponse(exchange,405, "{\"ERRO\":\"Método não permitido\"}");
        }
    }

    private void sendResponse(HttpExchange exchange, int status, String resposta) throws IOException{
        byte[] bytes = resposta.getBytes(StandardCharsets.UTF_8);

        exchange.getResponseHeaders().set("Content-Type","application/json; charset=UTF-8");

        exchange.sendResponseHeaders(status, bytes.length);

        OutputStream output = exchange.getResponseBody();

        output.write(bytes);

        output.close();
    }

    // HTTP GET
    private void handleGet(HttpExchange exchange) throws IOException {

        String caminho = exchange.getRequestURI().getPath();

        if(caminho.equals("/usuarios")){
            List<Usuario> usuarios = service.listar();
            sendResponse(exchange, 200, listToJson(usuarios));
        }

        Integer id = extrairId(caminho);

        if(id == null){
            sendResponse(exchange, 400, "{\"ERRO\":\"ID inválido\"}");
        }

        Usuario usuario = service.buscarPorId(id);

        if (usuario == null){
            sendResponse(exchange, 404, "{\"ERRO\":\"Usuário não encontrado\"}");
        }

        sendResponse(exchange, 200, userToJson(usuario));

    }

    private Integer extrairId(String caminho){
        try{
            String[] partes = caminho.split("/");

            if(partes.length != 3){
                return null;
            }
            return Integer.parseInt(partes[2]);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    // DADOS DE USUARIO EM STRING JSON
    private String userToJson(Usuario usuario){
        return """
            {
                "id": %d,
                "nome": "%s",
                "email": "%s"
            }
            """.formatted(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail()
        );
    }

    // TRANSFORMAR UMA LISTA NOS MOLDES DE ARQUIVO JSON
    private String listToJson(List<Usuario> usuarios){

        StringBuilder json = new StringBuilder();

        json.append("[");

        for (int i = 0; i < usuarios.size(); i++){
            json.append(userToJson(usuarios.get(i)));

            if (i < usuarios.size() - 1) {
                json.append(",");
            }
        }

        json.append("]");

        return json.toString();
    }

    // DADOS PRA USAR NO POST DPS
    private Map<String, String> readData(String body){

        Map<String, String> dados = new HashMap<>();

        String[] campos = body.split("&");

        for (String campo : campos){
            String[] partes = campo.split("=", 2);

            if (partes.length == 2){

                String chave = URLDecoder.decode(partes[0], StandardCharsets.UTF_8);

                String valor = URLDecoder.decode(partes[1], StandardCharsets.UTF_8);

                dados.put(chave, valor);
            }
        }
        return dados;
    }

    // HTTP POST (CRIAR)
    private void handlePost(HttpExchange exchange) throws IOException {
        String body = new String(exchange.getRequestBody().readAllBytes(),StandardCharsets.UTF_8);

        Map<String, String> dados = readData(body);

        String nome = dados.get("nome");
        String email = dados.get("email");

        if(nome == null || email == null){
            sendResponse(exchange, 400, "{\"ERRO\":\"Nome e email são obrigatórios\"}");
        }

        Usuario usuario = service.cadastrar(nome, email);

        sendResponse(exchange, 201, userToJson(usuario));
    }

    // HTTP PUT (ATUALIZAR)
    private void handlePut(HttpExchange exchange) throws IOException {
        String path = exchange.getRequestURI().getPath();

        Integer id = extrairId(path);

        if(id == null){
            sendResponse(exchange, 400, "{\"ERRO\":\"ID inválido\"}");
        }

        String body = new String(exchange.getRequestBody().readAllBytes(),StandardCharsets.UTF_8);

        Map<String, String> dados = readData(body);

        String nome = dados.get("nome");
        String email = dados.get("email");

        if(nome == null || email == null){
            sendResponse(exchange, 400, "{\"ERRO\":\"Nome e email são obrigatórios\"}");
        }

        Usuario usuario = service.atualizar(id, nome, email);

        sendResponse(exchange, 200, userToJson(usuario));
    }

    // HTTP DELETE (DELETAR)
    private void handleDelete(HttpExchange exchange) throws IOException {
        String path = exchange.getRequestURI().getPath();

        Integer id = extrairId(path);

        if(id == null){
            sendResponse(exchange, 400, "{\"ERRO\":\"ID inválido\"}");
        }

        boolean removed = service.remover(id);

        if(!removed){
            sendResponse(exchange, 404, "{\"ERRO\":\"Usuário não encontrado\"}");
        }

        exchange.sendResponseHeaders(204,-1);

        exchange.close();
    }
}
