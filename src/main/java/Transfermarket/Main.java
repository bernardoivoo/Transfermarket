package Transfermarket;

import Gerenciador.GerenciadorClube;
import Transfermarket.Clube;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Cria uma instância do GerenciadorClube
        GerenciadorClube gerenciadorClube = new GerenciadorClube();

        // Busca os clubes das 4 principais ligas
        List<Clube> clubesItalia = gerenciadorClube.buscarClubesPorCompeticao("IT1");
        List<Clube> clubesInglaterra = gerenciadorClube.buscarClubesPorCompeticao("GB1");
        List<Clube> clubesEspanha = gerenciadorClube.buscarClubesPorCompeticao("ES1");
        List<Clube> clubesFranca = gerenciadorClube.buscarClubesPorCompeticao("FR1");

        // Exibe os clubes com a identificação da liga
        gerenciadorClube.exibirClubesPorLiga(clubesItalia, "Itália");
        gerenciadorClube.exibirClubesPorLiga(clubesInglaterra, "Inglaterra");
        gerenciadorClube.exibirClubesPorLiga(clubesEspanha, "Espanha");
        gerenciadorClube.exibirClubesPorLiga(clubesFranca, "França");
    }
}
