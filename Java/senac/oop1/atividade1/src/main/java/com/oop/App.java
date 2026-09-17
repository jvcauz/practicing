/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.oop;

import java.util.Scanner;

/**
 *
 * @author joaov
 */
public class App {

    public static void main(String[] args) {
        
        // CRIAÇAO DE OBJETOS
        Scanner sc = new Scanner(System.in);
        Transporte transporte = new Transporte();
        Hospedagem hospedagem = new Hospedagem();
        PacoteViagem pacote = new PacoteViagem(transporte,hospedagem);
        Venda venda = new Venda(pacote);
        
        System.out.println("-= CADASTRE UMA VENDA =-");
        
        // COLETA DE DADOS DE TRANSPORTE E HOSPEDAGEM

        System.out.println("\nTransporte:");
        
        System.out.println("-> Tipo da viagem (aerea, rodoviaria, etc): ");
        transporte.setTipo(sc.next());
        
        System.out.println("-> Valor (em Dolar): ");
        transporte.setValor(sc.nextFloat());
        
        System.out.println("-> Cotacao do Dolar:");
        venda.setCotacaoDolar(sc.nextFloat());
        sc.nextLine(); // LIMPAR O BUFFER
        
        System.out.printf("TOTAL TRANSPORTE US$%.2f | R$%.2f%n",transporte.getValor(),venda.converterParaReal(transporte.getValor(), venda.getCotacaoDolar()));
        
        System.out.println("\nHospedagem:");
        
        System.out.println("-> Descricao:");
        hospedagem.setDescricao(sc.nextLine());
        
        System.out.println("-> Valor diaria (em Dolar): ");
        hospedagem.setValorDiaria(sc.nextFloat());
        sc.nextLine(); // LIMPAR O BUFFER
        
        // COLETA DE DADOS DO PACOTEVIAGEM

        System.out.println("\nPacote de Viagem:");
        
        System.out.println("-> Destino:");
        pacote.setDestino(sc.nextLine());
        
        System.out.println("-> Quantidade de dias:");
        pacote.setQuantidadeDias(sc.nextInt());
        
        System.out.printf("TOTAL HOSPEDAGEM US$%.2f | R$%.2f%n",pacote.calcularHospedagem(),venda.converterParaReal(pacote.calcularHospedagem(), venda.getCotacaoDolar()));
        
        System.out.println("\n-> Margem de lucro (porcentagem):");
        pacote.setMargemLucro(sc.nextFloat());
        
        System.out.println("-> Taxas adicionais (em Dolar)");
        pacote.setTaxasAdicionais(sc.nextFloat());
        sc.nextLine(); // LIMPAR O BUFFER
        
        // COLETA DE DADOS DA VENDA
        System.out.println("\nFinalizar a Venda:");
      
        System.out.println("-> Nome cliente:");
        venda.setNomeCliente(sc.nextLine());
        
        System.out.println("-> Forma de pagamento:");
        venda.setFormaPagamento(sc.nextLine());
        
        venda.mostrarVenda();
    }
}
