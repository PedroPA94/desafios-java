package com.trybe.acc.java.sistemadevotacao;

import java.util.ArrayList;

/**
 * Responsável por gerenciar todo o processo de votação, capaz de cadastrar candidatos, eleitores e
 * votos e gerar relatório de votação.
 */
public class GerenciamentoVotacao {
  private ArrayList<PessoaCandidata> pessoasCandidatas = new ArrayList<PessoaCandidata>();
  private ArrayList<PessoaEleitora> pessoasEleitoras = new ArrayList<PessoaEleitora>();
  private ArrayList<String> cpfComputado = new ArrayList<String>();
  private int totalVotos = 0;

  /**
   * Permite registrar um novo candidato, verificando se o número está disponível.
   * 
   * @param nome Nome do candidato.
   * @param numero Número do candidato.
   */
  public void cadastrarPessoaCandidata(String nome, int numero) {
    if (this.ehCandidatoRegistrado(numero)) {
      System.out.println("Número pessoa candidata já utilizado!");
    } else {
      pessoasCandidatas.add(new PessoaCandidata(nome, numero));
    }
  }

  private boolean ehCandidatoRegistrado(int numero) {
    for (PessoaCandidata pessoaCandidata : this.pessoasCandidatas) {
      if (pessoaCandidata.getNumero() == numero) {
        return true;
      }
    }
    return false;
  }

  /**
   * Permite registrar uma pessoa eleitora, validando se o cpf ainda não foi registrado.
   * 
   * @param nome Nome da pessoa eleitora.
   * @param cpf CPF da pessoa eleitora.
   */
  public void cadastrarPessoaEleitora(String nome, String cpf) {
    if (this.ehEleitorRegistrado(cpf)) {
      System.out.println("Pessoa eleitora já cadastrada!");
    } else {
      pessoasEleitoras.add(new PessoaEleitora(nome, cpf));
    }
  }

  private boolean ehEleitorRegistrado(String cpf) {
    for (PessoaEleitora pessoaEleitora : this.pessoasEleitoras) {
      if (pessoaEleitora.getCpf().equals(cpf)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Registra um novo voto caso a pessoa eleitora ainda não tenha votado.
   * 
   * @param cpfPessoaEleitora CPF da pessoa eleitora.
   * @param numeroPessoaCandidata Número da pessoa candidata que recebeu o voto.
   */
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {
    if (this.cpfComputado.contains(cpfPessoaEleitora)) {
      System.out.println("Pessoa eleitora já votou!");
    } else {
      this.computarVoto(numeroPessoaCandidata);
      this.cpfComputado.add(cpfPessoaEleitora);
      this.totalVotos += 1;
    }
  }

  private void computarVoto(int numeroPessoaCandidata) {
    for (PessoaCandidata pessoaCandidata : this.pessoasCandidatas) {
      System.out.println(pessoaCandidata.getNumero() + ", " + numeroPessoaCandidata);
      System.out.println(pessoaCandidata.getNumero() == numeroPessoaCandidata);
      if (pessoaCandidata.getNumero() == numeroPessoaCandidata) {
        pessoaCandidata.receberVoto();
      }
    }
  }

  /**
   * Apresenta um relatório parcial ou final da votação no console.
   */
  public void mostrarResultado() {
    if (this.totalVotos == 0) {
      System.out.println("É preciso ter pelo menos um voto para mostrar o resultado.");
      return;
    }

    for (PessoaCandidata pessoaCandidata : this.pessoasCandidatas) {
      double percentual = this.calcularPorcentagemVotos(pessoaCandidata.getVotos());
      System.out.println("Nome: " + pessoaCandidata.getNome() + " - " + pessoaCandidata.getVotos()
          + " votos (" + percentual + "% )");
    }
    System.out.println("Total de votos: " + this.totalVotos);
  }

  private double calcularPorcentagemVotos(int votos) {
    double votosDbl = (double) votos;
    return Math.round((votosDbl / this.totalVotos) * 100);
  }
}


