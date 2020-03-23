package com.br.students.list;

import java.util.ArrayList;
import java.util.Optional;
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
    private static ArrayList<String> arlist;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        arlist = new ArrayList<>();
        run = true;

        carregarMenu();

        scanner.close();
    }

    /*
        Método para limpar string retirando espaços e deixando letras minúsculas
     */
    private static String clearString(String str){
        return str.toLowerCase().replaceAll(" ", "");
    }
    
    private static void criarAluno() {
    	System.out.println("Digite o nome do aluno: ");

        String name = scanner.nextLine();
        Optional<String> aluno = arlist.stream().filter(e -> clearString(e).equals(clearString(name))).findAny();
        if (!aluno.isPresent()) {
            arlist.add(name);
        } else {
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

            if (option.equals("1")) {
            	criarAluno();
            	System.out.println("Aluno Cadastrado");
//                System.out.println("Digite o nome do aluno: ");
//
//                String name = scanner.nextLine();
//                Optional<String> aluno = arlist.stream().filter(e -> clearString(e).equals(clearString(name))).findAny();
//                if (!aluno.isPresent()) {
//                    arlist.add(name);
//                } else {
//                    System.out.println("O aluno já esta cadastrado!");
//                }
            	
            } else if (option.equals("2")) {
//            	System.out.println("Listando ...");
//                /*
//                    Method reference
//                    poderia ser utilizado também com lambda
//                    arlist.forEach(e -> System.out.println(e));
//                    for ou for each padrão
//                 */
//                arlist.forEach(System.out::println);
//                System.out.println("");
            	listarAlunos();
            } else if (option.equals("3")) {
                run = false;
            } else {
                System.out.println("Digite uma opção válida");
                exibirMenu();
            }
        }
    }
}
