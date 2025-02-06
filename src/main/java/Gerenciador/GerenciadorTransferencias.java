/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gerenciador;


import Transfermarket.Clube;
import Transfermarket.FinanceiroClube;
import Transfermarket.Transferencia;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author berna
 */
public class GerenciadorTransferencias {
    private List<Transferencia> transferencias;

    public GerenciadorTransferencias() {
        this.transferencias = new ArrayList<>();
    }

    public void adicionarTransferencia(Transferencia transferencia) {
        transferencias.add(transferencia);
    }

    public FinanceiroClube calcularFinanceiro(Clube clube) {
        FinanceiroClube financeiro = new FinanceiroClube(clube);
        
        for (Transferencia t : transferencias) {
            if (t.getClubeDestino().equals(clube)) {
                financeiro.registrarCompra(t.getValorTransferencia());
            }
            if (t.getClubeOrigem().equals(clube)) {
                financeiro.registrarVenda(t.getValorTransferencia());
            }
        }
        
        return financeiro;
    }
}

