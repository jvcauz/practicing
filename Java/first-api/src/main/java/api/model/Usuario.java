package api.model;

public class Usuario {
    //atributos
    private int id;
    private String nome;
    private String email;

    //constructor
    public Usuario(int id, String nome, String email){
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    //getters and setters
    public int getId(){
        return id;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }
}
