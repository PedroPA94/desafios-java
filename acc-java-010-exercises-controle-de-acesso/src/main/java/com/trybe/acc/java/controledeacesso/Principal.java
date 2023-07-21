package com.trybe.acc.java.controledeacesso;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main program.
 */
public class Principal {

  /**
   * Método principal.
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Integer> ages = new ArrayList<Integer>();
    boolean shouldLoop = true;

    while (shouldLoop) {
      System.out.println("Entre com o número correspondente à opção desejada:");
      System.out.println("1 - Acessar o estabelecimento");
      System.out.println("2 - Finalizar sistema e mostrar relatório");
      String option = scanner.next();

      if (option.equals("1")) {
        System.out.println("Entre com a idade:");
        String ageInput = scanner.next();
        int age = Integer.parseInt(ageInput);
        ages.add(age);
        showAgeMessage(age);
      } else if (option.equals("2")) {
        shouldLoop = false;
      } else {
        System.out.println("Entre com uma opção válida!");
      }
    }

    scanner.close();
    generateReport(ages);
  }

  /**
   * Imprime frase de acordo com a idade.
   * 
   * @param age Valor da idade
   */
  public static void showAgeMessage(int age) {
    String ageCharacteristic = "Pessoa adulta";
    if (age < 18) {
      ageCharacteristic = "Pessoa cliente menor de idade";
    } else if (age >= 50) {
      ageCharacteristic = "Pessoa adulta a partir de 50";
    }
    System.out.println(ageCharacteristic + ", catraca liberada!");
  }

  /**
   * Gera relatório de pessoas clientes.
   * 
   * @param ages Array contendo as idades das pessoas clientes.
   */
  public static void generateReport(ArrayList<Integer> ages) {
    float totalClients = ages.size();
    int minors = 0;
    int adults = 0;
    int overFifty = 0;

    for (int age : ages) {
      if (age < 18) {
        minors++;
      } else if (age >= 50) {
        overFifty++;
      } else {
        adults++;
      }
    }

    DecimalFormat percentageFormat = new DecimalFormat("#0.00%");
    String minorsPercentage = percentageFormat.format(minors / totalClients);
    String adultsPercentage = percentageFormat.format(adults / totalClients);
    String overFiftyPercentage = percentageFormat.format(overFifty / totalClients);

    System.out.println("----- Quantidade -----");
    System.out.println("menores: " + minors);
    System.out.println("adultas: " + adults);
    System.out.println("a partir de 50: " + overFifty);

    System.out.println("----- Percentual -----");
    System.out.println("menores: " + minorsPercentage);
    System.out.println("adultas: " + adultsPercentage);
    System.out.println("a partir de 50: " + overFiftyPercentage);

    System.out.println("TOTAL: " + totalClients);
  }
}
