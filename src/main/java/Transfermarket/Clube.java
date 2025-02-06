/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Transfermarket;

/**
 *
 * @author berna
 */
public class Clube {
    private String nome;
    private String pais;
    private Liga liga;
    private double valorTotalDoElenco;

    public Clube(String nome, String pais, Liga liga, double valorTotalDoElenco) {
        this.nome = nome;
        this.pais = pais;
        this.liga = liga;
        this.valorTotalDoElenco = valorTotalDoElenco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Liga getLiga() {
        return liga;
    }

    public void setLiga(Liga liga) {
        this.liga = liga;
    }

    public double getValorTotalDoElenco() {
        return valorTotalDoElenco;
    }

    public void setValorTotalDoElenco(double valorTotalDoElenco) {
        this.valorTotalDoElenco = valorTotalDoElenco;
    }

    @Override
    public String toString() {
        return "Clube: " + nome + " | País: " + pais +
               " | Liga: " + (liga != null ? liga.getNome() : "Sem liga") +
               " | Valor Total do Elenco: €" + valorTotalDoElenco;
    }
}
