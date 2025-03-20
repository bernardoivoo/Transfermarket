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
        // Criar uma instância do GerenciadorClube
        GerenciadorClube gerenciadorClube = new GerenciadorClube();

        // Buscar os clubes
        List<Clube> clubes = gerenciadorClube.buscarClubes();

        // Verificar se a lista não é nula e imprimir os clubes
        if (clubes != null) {
            for (Clube clube : clubes) {
                System.out.println(clube);
            }
        } else {
            System.out.println("Não foi possível obter a lista de clubes.");
        }
    }
}


