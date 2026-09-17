/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oop;

/**
 *
 * @author joaov
 */
public class Hospedagem {
    
    private String descricao;
    private float valorDiaria;
    
    // CONSTRUTOR PRINCIPAL DA CLASSE
    public Hospedagem(){
    }
    
    // GETTERS E SETTERS
    public String getDescricao(){
        return descricao;
    }
    
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    
    public float getValorDiaria(){
        return valorDiaria;
    }
    
    public void setValorDiaria(float valorDiaria){
        this.valorDiaria = valorDiaria;
    }
}
