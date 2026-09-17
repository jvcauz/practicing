package com.auth;

import java.util.Scanner;

public class Login {

    public static void login(){

        String username = "jaozin";
        String pass = "joaozika";

        String userFirstName = "Joao";
        String userLastName = "Cauzzo";

        Scanner scanner = new Scanner(System.in);

        User user = new User();

        user.firstName = userFirstName;
        user.lastName = userLastName;

        int attempts = 0;

        while(attempts < 5) {

            System.out.println("-- LOGIN --");
            System.out.println("Digite seu username: ");

            user.name = scanner.nextLine();

            System.out.println("Digite sua senha: ");
            user.password = scanner.nextLine();

            if(user.password.equals(pass) && user.name.equals(username)){
                System.out.println("Bem vindo(a) "+ user.getFullName()+"!");
                return;
            }

            attempts++;

            System.out.println("Dados incorretos.");

            if(attempts < 4) {
                System.out.println("Restam " + (5-attempts) + " tentativas");
            } else if(attempts == 4) {
                System.out.println("Resta 1 tentativa");
            }
        }

        System.out.println("CONTA BLOQUEADA.");

    }
}
