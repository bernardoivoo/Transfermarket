/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Transfermarket;

/**
 *
 * @author berna
 */
import Transfermarket.Clube;
import Gerenciador.GerenciadorClube;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GerenciadorClube gerenciador = new GerenciadorClube();

        // Buscar um clube específico
        Clube realMadrid = gerenciador.buscarClubePorNome("Real Madrid");
        if (realMadrid != null) {
            System.out.println("🏟️ Clube encontrado: " + realMadrid.getNome() + " | Liga: " + realMadrid.getLiga());
        } else {
            System.out.println("Clube não encontrado.");
        }

        // Buscar clubes de uma liga específica
        List<Clube> clubesPremier = gerenciador.listarClubesPorLiga("Premier League");
        gerenciador.exibirClubes(clubesPremier);
    }
}



