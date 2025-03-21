package Gerenciador;

import Transfermarket.Clube;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorClube {
    private static final String API_KEY = "51a5628402mshedf0e2040b28bd0p1c7eb4jsnab192d4f4280";
    private final OkHttpClient client = new OkHttpClient();

    // Método para buscar clubes de uma competição específica
    public List<Clube> buscarClubesPorCompeticao(String idCompeticao) {
        String apiUrl = "https://transfermarket.p.rapidapi.com/clubs/list-by-competition?id=" + idCompeticao;
        Request request = new Request.Builder()
            .url(apiUrl)
            .get()
            .addHeader("x-rapidapi-key", API_KEY)
            .addHeader("x-rapidapi-host", "transfermarket.p.rapidapi.com")
            .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                System.out.println("Erro na requisição: " + response.code() + " - " + response.message());
                return null;
            }

            String json = response.body().string();
            // Não imprimimos mais o JSON, conforme solicitado

            Gson gson = new Gson();
            ClubesResponse clubesResponse = gson.fromJson(json, ClubesResponse.class);

            return (clubesResponse == null || clubesResponse.clubs == null) ? new ArrayList<>() : clubesResponse.clubs;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Método para buscar um clube pelo nome
    public Clube buscarClubePorNome(String nomeClube) {
        // Vamos buscar nas ligas e retornar o primeiro clube que encontrar
        List<String> ligas = List.of("IT1", "GB1", "ES1", "FR1");

        for (String liga : ligas) {
            List<Clube> clubes = buscarClubesPorCompeticao(liga);
            for (Clube clube : clubes) {
                if (clube.getNome().equalsIgnoreCase(nomeClube)) {
                    clube.setLiga(liga); // Atribui a liga ao clube
                    return clube;
                }
            }
        }
        return null; // Retorna null se o clube não for encontrado
    }

    // Método para exibir clubes de uma liga específica
    public void exibirClubesPorLigaSelecionada(String idLiga) {
        List<Clube> clubes = buscarClubesPorCompeticao(idLiga);
        if (clubes != null && !clubes.isEmpty()) {
            System.out.println("Clubes da liga:");
            for (Clube clube : clubes) {
                System.out.println("\uD83C\uDFDF️ Clube: " + clube.getNome());
            }
        } else {
            System.out.println("Nenhum clube encontrado na liga.");
        }
    }
    
     // Método para buscar o plantel de um clube
    public List<String> buscarPlantelDoClube(String idClube) {
        String apiUrl = "https://transfermarket.p.rapidapi.com/clubs/get-squad?id=" + idClube + "&saison_id=2022";
        Request request = new Request.Builder()
            .url(apiUrl)
            .get()
            .addHeader("x-rapidapi-key", API_KEY)
            .addHeader("x-rapidapi-host", "transfermarket.p.rapidapi.com")
            .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                System.out.println("Erro ao buscar plantel: " + response.code() + " - " + response.message());
                return new ArrayList<>();
            }

            String json = response.body().string();
            Gson gson = new Gson();
            PlantelResponse plantelResponse = gson.fromJson(json, PlantelResponse.class);

            List<String> jogadores = new ArrayList<>();
            if (plantelResponse != null && plantelResponse.squad != null) {
                for (Jogador jogador : plantelResponse.squad) {
                    jogadores.add(jogador.nome);
                }
            }
            return jogadores;
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private class ClubesResponse {
        List<Clube> clubs;
    }
    
     private class PlantelResponse {
        @SerializedName("squad")
        List<Jogador> squad;
    }

    private class Jogador {
        @SerializedName("name")
        String nome;
    }
}
