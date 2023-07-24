package com.trybe.acc.java.sistemadevotacao;

/**
 * Representação de uma pessoa candidata, guardando o seu número e qtd de votos.
 */
public class PessoaCandidata extends Pessoa {
  private int numero;
  private int votos;

  /**
   * Construtor da pessoa candidata, recebe nome e número e inicializa o contador de votos em zero.
   * 
   * @param nome Nome do candidato.
   * @param numero Número do candidato.
   */
  public PessoaCandidata(String nome, int numero) {
    this.nome = nome;
    this.numero = numero;
    this.votos = 0;
  }

  public void receberVoto() {
    this.votos += 1;
  }

  public int getNumero() {
    return numero;
  }


  public void setNumero(int numero) {
    this.numero = numero;
  }


  public int getVotos() {
    return votos;
  }


  public void setVotos(int votos) {
    this.votos = votos;
  }


  @Override
  public String getNome() {
    return this.nome;
  }

  @Override
  public void setNome(String nome) {
    this.nome = nome;
  }

}
