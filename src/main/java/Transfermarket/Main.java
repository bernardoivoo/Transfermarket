package Transfermarket;

import Gerenciador.GerenciadorClube;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Cria uma instância do GerenciadorClube
        GerenciadorClube gerenciadorClube = new GerenciadorClube();

        // Cria o Scanner para ler entradas do usuário
        Scanner scanner = new Scanner(System.in);

        // Solicita ao usuário para escolher se quer buscar por clube ou por liga
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Buscar clube pelo nome");
        System.out.println("2 - Exibir clubes de uma liga");
        System.out.print("Digite sua escolha (1 ou 2): ");
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        if (opcao == 1) {
            // Opção 1: Buscar clube pelo nome
            System.out.print("Digite o nome do clube: ");
            String nomeClube = scanner.nextLine();
            Clube clube = gerenciadorClube.buscarClubePorNome(nomeClube);

            if (clube != null) {
                System.out.println("Informações do clube: " + clube.getNome());
                System.out.println("Liga: " + clube.getLiga()); // Exibe a liga do clube

                // Buscar e exibir o plantel do clube
                List<String> plantel = gerenciadorClube.buscarPlantelDoClube(clube.getId());
                if (plantel != null && !plantel.isEmpty()) {
                    System.out.println("Plantel:");
                    for (String jogador : plantel) {
                        System.out.println("- " + jogador);
                    }
                } else {
                    System.out.println("Plantel não disponível.");
                }
            } else {
                System.out.println("Clube não encontrado.");
            }
        } else if (opcao == 2) {
            // Opção 2: Exibir clubes de uma liga
            System.out.println("Escolha uma liga:");
            System.out.println("1 - Liga Italiana");
            System.out.println("2 - Liga Inglesa");
            System.out.println("3 - Liga Espanhola");
            System.out.println("4 - Liga Francesa");
            System.out.print("Digite sua escolha (1-4): ");
            int ligaEscolhida = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            String idLiga = "";
            switch (ligaEscolhida) {
                case 1:
                    idLiga = "IT1"; // Liga Italiana
                    break;
                case 2:
                    idLiga = "GB1"; // Liga Inglesa
                    break;
                case 3:
                    idLiga = "ES1"; // Liga Espanhola
                    break;
                case 4:
                    idLiga = "FR1"; // Liga Francesa
                    break;
                default:
                    System.out.println("Opção inválida.");
                    return; // Sai do programa se a opção for inválida
            }

            // Exibe os clubes da liga selecionada
            gerenciadorClube.exibirClubesPorLigaSelecionada(idLiga);
        } else {
            System.out.println("Opção inválida.");
        }

        scanner.close(); // Fecha o scanner
    }
}
