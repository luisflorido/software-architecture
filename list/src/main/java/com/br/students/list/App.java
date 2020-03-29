package com.br.students.list;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {

    /*
        Inicializar variáveis dentro do construtor pode ser melhor caso haja alguma lógica adicional ou tratamento de erro
     */
    private static boolean run;
    private static Scanner scanner;
    private static HashSet<String> arlist;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        arlist = new HashSet<>();
        run = true;

        carregarMenu();

        scanner.close();
    }
    
    private static void criarAluno() {
    	System.out.println("Digite o nome do aluno: ");

        String name = scanner.nextLine();
        if (!arlist.add(name)) {
            System.out.println("O aluno já esta cadastrado!");
            criarAluno();
        }
    }
    
    private static void listarAlunos() {
    	System.out.println("Listando ...");
        /*
            Method reference
            poderia ser utilizado também com lambda
            arlist.forEach(e -> System.out.println(e));
            for ou for each padrão
         */
        arlist.forEach(System.out::println);
        System.out.println("");
    }
    
    private static void exibirMenu() {
    	System.out.println("Menu");
        System.out.println("Digite 1 para inserir o estudante ");
        System.out.println("Digite 2 para imprimir a lista ");
        System.out.println("Digite 3 sair \n");

    }
    
    private static void carregarMenu() {
        while (run) {
        	exibirMenu();
            String option = scanner.nextLine();
            
            switch(option) {
            	case "1":
            		criarAluno();
                	System.out.println("Aluno Cadastrado");
                	break;
            	case "2":
                	listarAlunos();
                	break;
            	case "3":
            		break;
            	default:
            		System.out.println("Digite uma opção válida");
                    exibirMenu();
                    break;
            }
        }
    }
}
