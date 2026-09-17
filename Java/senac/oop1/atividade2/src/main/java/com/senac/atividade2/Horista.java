package com.senac.atividade2;

/**
 *
 * @author joaov
 */
public class Horista extends Funcionario {
    
    private int horas;
    private float valorHora;

    // CONSTRUTOR DA CLASSE
    public Horista(){
    }

    // GETTERS e SETTERS
    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public float getValorHora() {
        return valorHora;
    }

    public void setValorHora(float valorHora) {
        this.valorHora = valorHora;
    }
    
    //METODOS ABSTRATOS
    @Override
    public float calcularSalario() {
        return getValorHora() * getHoras();
    }

    @Override
    public float aplicarAumento(float aumento) {
        return calcularSalario() + (calcularSalario()*(aumento/100));
    }

    @Override
    public void mostrarDados() {

        System.out.println("Tipo: Horista");
        System.out.println("Nome: " + getNome());
        System.out.println("CPF: " + getCpf());
        System.out.println("Endereco: " + getEndereco());
        System.out.println("Telefone: " + getTelefone());
        System.out.println("Setor: " + getSetor());
        System.out.printf("Valor da hora: R$ %.2f%n", getValorHora());
        System.out.println("Horas trabalhadas: " + getHoras());
        System.out.printf("Valor total: R$ %.2f%n", calcularSalario());
    }
}
