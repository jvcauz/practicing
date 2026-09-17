package com.senac.atividade2;

/**
 *
 * @author joaov
 */
public class Assalariado extends Funcionario {
    
    private float valorSalario;
  
    
    // CONSTRUTOR DA CLASSE
    public Assalariado(){
    }

    // GETTERS e SETTERS
    public float getValorSalario() {
        return valorSalario;
    }

    public void setValorSalario(float valorSalario) {
        this.valorSalario = valorSalario;
    }

    //METODOS ABSTRATOS
    @Override
    public float calcularSalario() {
        return getValorSalario();
    }

    @Override
    public float aplicarAumento(float aumento) {
        return calcularSalario() + (calcularSalario()*(aumento/100));
    }

    @Override
    public void mostrarDados() {

        System.out.println("Tipo: Assalariado");
        System.out.println("Nome: " + getNome());
        System.out.println("CPF: " + getCpf());
        System.out.println("Endereco: " + getEndereco());
        System.out.println("Telefone: " + getTelefone());
        System.out.println("Setor: " + getSetor());
        System.out.printf("Salario: R$ %.2f%n", getValorSalario());
    }
}
