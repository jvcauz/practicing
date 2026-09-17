/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oop;

/**
 *
 * @author joaov
 */
public class PacoteViagem {
    
    private Transporte transporte;
    private Hospedagem hospedagem;
    private String destino;
    private int quantidadeDias;
    private float margemLucro;
    private float taxasAdicionais;
    
    // CONSTRUTOR PRINCIPAL DA CLASSE
    public PacoteViagem(Transporte transporte, Hospedagem hospedagem){
        this.transporte = transporte;
        this.hospedagem = hospedagem;
    }
    
    // GETTERS E SETTERS
    public Transporte getTransporte() {
        return transporte;
    }

    public Hospedagem getHospedagem() {
        return hospedagem;
    }
    
    public String getDestino(){
        return destino;
    }
    
    public void setDestino(String destino){
        this.destino = destino;
    }
    
    public int getQuantidadeDias(){
        return quantidadeDias;
    }
    
    public void setQuantidadeDias(int quantidadeDias){
        this.quantidadeDias = quantidadeDias;
    }

    public float getMargemLucro() {
        return margemLucro;
    }

    public void setMargemLucro(float margemLucro) {
        this.margemLucro = margemLucro;
    }

    public float getTaxasAdicionais() {
        return taxasAdicionais;
    }

    public void setTaxasAdicionais(float taxasAdicionais) {
        this.taxasAdicionais = taxasAdicionais;
    }
    
    // MÉTODOS
    public float calcularHospedagem(){
        return hospedagem.getValorDiaria()*quantidadeDias;
    }
    
    public float calcularLucro(){
        float valorBase = transporte.getValor()+calcularHospedagem();
        return valorBase + (valorBase*(margemLucro/100));
    }
    
    public float calcularTotal(){
        return calcularLucro() + taxasAdicionais;
    }
}
