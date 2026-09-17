/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oop;

/**
 *
 * @author joaov
 */
public class Venda {
    
    private String nomeCliente;
    private String formaPagamento;
    private float cotacaoDolar;
    private PacoteViagem pacote;
    
    // CONSTRUTOR PRINCIPAL DA CLASSE
    public Venda(PacoteViagem pacote){
        this.pacote = pacote;
    }
    
    // GETTERS E SETTERS
    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public float getCotacaoDolar() {
        return cotacaoDolar;
    }

    public void setCotacaoDolar(float cotacaoDolar) {
        this.cotacaoDolar = cotacaoDolar;
    }
    
    // MÉTODOS
    public float converterParaReal(float valorDolar, float cotacaoDolar){
        return valorDolar*cotacaoDolar;
    }
    
    public void mostrarVenda(){
        String tipoViagem = pacote.getTransporte().getTipo();
        String descricao = pacote.getHospedagem().getDescricao();
        float valorBase = pacote.getTransporte().getValor()+pacote.calcularHospedagem();
        float valorLucro = valorBase*(pacote.getMargemLucro()/100.0f);
        float taxas = pacote.getTaxasAdicionais();
        float total = pacote.calcularTotal();
        
        System.out.println("\nTOTAL DA VIAGEM " + tipoViagem.toUpperCase() + " DE " + nomeCliente.toUpperCase());
        System.out.println("-> " + descricao + " | " + pacote.getDestino() + " | " + pacote.getQuantidadeDias() + " dias");
        System.out.printf("-> Valor Base US$%.2f | R$%.2f%n",valorBase,converterParaReal(valorBase,cotacaoDolar));
        System.out.printf("-> Margem de lucro (%.2f%%) US$%.2f | R$%.2f%n",pacote.getMargemLucro(),valorLucro,converterParaReal(valorLucro, cotacaoDolar));
        System.out.printf("-> Taxas adicionais US$%.2f | R$%.2f%n", taxas,converterParaReal(taxas,cotacaoDolar));
        System.out.printf("-> Valor Total US$%.2f | R$%.2f%n", total, converterParaReal(total, cotacaoDolar));
        System.out.println("-> Metodo de Pagamento: " + formaPagamento);
    }
}