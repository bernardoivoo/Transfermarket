/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Transfermarket;

import java.util.Date;

/**
 *
 * @author berna
 */
public class Transferencia {
    private Jogador jogador;
    private Clube clubeOrigem;
    private Clube clubeDestino;
    private double valorTransferencia;
    private Date dataTransferencia;

    public Transferencia(Jogador jogador, Clube clubeOrigem, Clube clubeDestino, double valorTransferencia, Date dataTransferencia) {
        this.jogador = jogador;
        this.clubeOrigem = clubeOrigem;
        this.clubeDestino = clubeDestino;
        this.valorTransferencia = valorTransferencia;
        this.dataTransferencia = dataTransferencia;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public Clube getClubeOrigem() {
        return clubeOrigem;
    }

    public Clube getClubeDestino() {
        return clubeDestino;
    }

    public double getValorTransferencia() {
        return valorTransferencia;
    }

    public Date getDataTransferencia() {
        return dataTransferencia;
    }

    @Override
    public String toString() {
        return "Transferência: " + jogador.getNome() + " de " + clubeOrigem.getNome() +
               " para " + clubeDestino.getNome() + " por €" + valorTransferencia + 
               " em " + dataTransferencia;
    }
}
