/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Transfermarket;

/**
 *
 * @author berna
 */
public class Jogador {
    private String nome;
    private int idade;
    private String nacionalidade;
    private String posicao;
    private double valorDeMercado;
    private Clube clubeAtual;

    public Jogador(String nome, int idade, String nacionalidade, String posicao, double valorDeMercado, Clube clubeAtual) {
        this.nome = nome;
        this.idade = idade;
        this.nacionalidade = nacionalidade;
        this.posicao = posicao;
        this.valorDeMercado = valorDeMercado;
        this.clubeAtual = clubeAtual;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public double getValorDeMercado() {
        return valorDeMercado;
    }

    public void setValorDeMercado(double valorDeMercado) {
        this.valorDeMercado = valorDeMercado;
    }

    public Clube getClubeAtual() {
        return clubeAtual;
    }

    public void setClubeAtual(Clube clubeAtual) {
        this.clubeAtual = clubeAtual;
    }

}
