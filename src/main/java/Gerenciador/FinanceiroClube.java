/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gerenciador;

import Transfermarket.Clube;

/**
 *
 * @author berna
 */
public class FinanceiroClube {
    private Clube clube;
    private double totalGasto;
    private double totalRecebido;

    public FinanceiroClube(Clube clube) {
        this.clube = clube;
        this.totalGasto = 0;
        this.totalRecebido = 0;
    }

    public void registrarCompra(double valor) {
        totalGasto += valor;
    }

    public void registrarVenda(double valor) {
        totalRecebido += valor;
    }

    public double getSaldo() {
        return totalRecebido - totalGasto;
    }

    @Override
    public String toString() {
        return "Clube: " + clube.getNome() + 
               " | Total Gasto: €" + totalGasto + 
               " | Total Recebido: €" + totalRecebido + 
               " | Saldo Final: €" + getSaldo();
    }
}

