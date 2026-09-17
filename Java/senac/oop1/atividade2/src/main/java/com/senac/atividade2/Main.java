package com.senac.atividade2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author joaov
 */
public class Main {

    public static void main(String[] args) {
        
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        
        System.out.println("CADASTRO DE FUNCIONARIOS");
        
        int qtdF = 0;
        
        System.out.println("Deseja adicionar quantos funcionario?");
        qtdF = sc.nextInt();
        sc.nextLine(); // LIMPAR O BUFFER
        
        if(qtdF<=10){
            for(int i = 0; i < qtdF; i++){
                System.out.println("\nFUNCIONARIO " + (i + 1));
                System.out.println("Qual tipo de funcionario? (Assalariado/Horista)");
                String tipoF = sc.nextLine().toUpperCase();
                
                switch(tipoF){
                    case "ASSALARIADO":
                        funcionarios.add(cadastrarAssalariado(sc));
                        break;
                    case "HORISTA": 
                        funcionarios.add(cadastrarHorista(sc));
                        break;
                    default:
                        System.out.println("Tipo de funcionario invalido.");
                }
            }
        }else{
            System.out.println("ERRO! Numero maximo de funcionarios sao dez.");
        }
        
        System.out.println("\nFUNCIONARIOS CADASTRADOS");
        
        for (int i = 0; i < funcionarios.size(); i++) {
            System.out.println("------------------------------");
            System.out.println("FUNCIONARIO " + (i + 1));
            funcionarios.get(i).mostrarDados();
        }
        
        System.out.println("\nInforme em % o aumento geral dos funcionarios: ");
        float aumentoGeral = sc.nextFloat();
        
        for (int i = 0; i < funcionarios.size(); i++){
            System.out.println("------------------------------");
            System.out.println("FUNCIONARIO(A) " + funcionarios.get(i).getNome());
            System.out.printf("Valor total com aumento: R$ %.2f%n", funcionarios.get(i).aplicarAumento(aumentoGeral));
        }
    }
    
    public static void cadastrarFuncionario(Scanner sc, Funcionario funcionario){
                        
        System.out.println("Digite o nome: ");
        funcionario.setNome(sc.nextLine());
        System.out.println("Digite o CPF: ");
        funcionario.setCpf(sc.nextLine());
        System.out.println("Digite o endereco: ");
        funcionario.setEndereco(sc.nextLine());
        System.out.println("Digite o telefone: ");
        funcionario.setTelefone(sc.nextLine());
        System.out.println("Digite o setor: ");
        funcionario.setSetor(sc.nextLine());
    }
    
    public static Assalariado cadastrarAssalariado(Scanner sc){
        Assalariado assalariado = new Assalariado();
        
        cadastrarFuncionario(sc, assalariado);
        
        System.out.println("Digite o salario: ");
        assalariado.setValorSalario(sc.nextFloat());
        sc.nextLine(); // LIMPAR O BUFFER
                        
        return assalariado;
    }
    
    public static Horista cadastrarHorista(Scanner sc){
        Horista horista = new Horista();
        
        cadastrarFuncionario(sc, horista);
        
        System.out.println("Digite o valor da hora: ");
        horista.setValorHora(sc.nextFloat());
        System.out.println("Digite as horas trabalhadas: ");
        horista.setHoras(sc.nextInt());
        sc.nextLine(); // LIMPAR O BUFFER
        
        return horista;
    }
}
