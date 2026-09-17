package com.senac.atividade2;

/**
 *
 * @author joaov
 */
public abstract class Funcionario {
    
    private String nome;
    private String cpf;
    private String endereco;
    private String telefone;
    private String setor;
    
    public Funcionario(){
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }
    
    // METODOS ABSTRATOS
    public abstract float calcularSalario();
    
    public abstract float aplicarAumento(float aumento);
    
    public abstract void mostrarDados();
}
