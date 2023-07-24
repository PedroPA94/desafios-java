package com.trybe.acc.java.sistemadevotacao;

import java.util.Scanner;

/**
 * Classe principal do programa.
 */
public class Principal {

  /**
   * Método principal, roda o sistema de votação.
   * 
   * @param args vazio.
   */
  public static void main(String[] args) {
    GerenciamentoVotacao gerenciamentoVotacao = new GerenciamentoVotacao();
    Scanner scanner = new Scanner(System.in);
    short option;
    boolean shouldLoop = true;

    while (shouldLoop) {
      System.out.println("Cadastrar pessoa candidata?");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");
      System.out.println(" Entre com o número correspondente à opção desejada:");
      option = scanner.nextShort();
      if (option == 1) {
        cadastrarPessoaCandidata(scanner, gerenciamentoVotacao);
      } else if (option == 2) {
        shouldLoop = false;
      } else {
        System.out.println("Opção inválida");
      }
    }

    shouldLoop = true;
    while (shouldLoop) {
      System.out.println("Cadastrar pessoa eleitora?");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");
      System.out.println(" Entre com o número correspondente à opção desejada:");
      option = scanner.nextShort();
      if (option == 1) {
        cadastrarPessoaEleitora(scanner, gerenciamentoVotacao);
      } else if (option == 2) {
        shouldLoop = false;
      } else {
        System.out.println("Opção inválida");
      }
    }

    shouldLoop = true;
    while (shouldLoop) {
      System.out.println(" Entre com o número correspondente à opção desejada:");
      System.out.println("1 - Votar");
      System.out.println("2 - Resultado Parcial");
      System.out.println("3 - Finalizar Votação");
      option = scanner.nextShort();
      if (option == 1) {
        registrarVoto(scanner, gerenciamentoVotacao);
      } else if (option == 2) {
        gerenciamentoVotacao.mostrarResultado();
      } else if (option == 3) {
        gerenciamentoVotacao.mostrarResultado();
        shouldLoop = false;
      } else {
        System.out.println("Opção inválida");
      }
    }
  }

  private static void cadastrarPessoaCandidata(Scanner scanner,
      GerenciamentoVotacao gerenciamentoVotacao) {
    System.out.println("Entre com o nome da pessoa candidata:");
    String nome = scanner.next();
    System.out.println("Entre com o número da pessoa candidata:");
    String numeroStr = scanner.next();
    gerenciamentoVotacao.cadastrarPessoaCandidata(nome, Integer.parseInt(numeroStr));
  }

  private static void cadastrarPessoaEleitora(Scanner scanner,
      GerenciamentoVotacao gerenciamentoVotacao) {
    System.out.println("Entre com o nome da pessoa eleitora:");
    String nome = scanner.next();
    System.out.println("Entre com o cpf da pessoa eleitora:");
    String cpf = scanner.next();
    gerenciamentoVotacao.cadastrarPessoaEleitora(nome, cpf);
  }

  private static void registrarVoto(Scanner scanner, GerenciamentoVotacao gerenciamentoVotacao) {
    System.out.println("Entre com o cpf da pessoa eleitora:");
    String cpf = scanner.next();
    System.out.println("Entre com o número da pessoa candidata:");
    String numeroStr = scanner.next();
    gerenciamentoVotacao.votar(cpf, Integer.parseInt(numeroStr));
  }

}
