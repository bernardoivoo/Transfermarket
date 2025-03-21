package Gerenciador;

import Transfermarket.Clube;
import com.google.gson.Gson;
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
            System.out.println("Resposta JSON: " + json);

            Gson gson = new Gson();
            ClubesResponse clubesResponse = gson.fromJson(json, ClubesResponse.class);

            return (clubesResponse == null || clubesResponse.clubs == null) ? new ArrayList<>() : clubesResponse.clubs;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Método para obter clubes das 4 principais ligas
    public List<Clube> buscarClubesPrincipaisLigas() {
        // IDs das ligas principais (sem a liga da Alemanha)
        List<String> ligas = List.of("IT1", "GB1", "ES1", "FR1");
        List<Clube> todosClubes = new ArrayList<>();

        for (String liga : ligas) {
            todosClubes.addAll(buscarClubesPorCompeticao(liga));
        }

        return todosClubes;
    }

    // Exibir clubes com a identificação da liga
    public void exibirClubesPorLiga(List<Clube> lista, String liga) {
        if (lista == null || lista.isEmpty()) {
            System.out.println("Nenhum clube encontrado na liga " + liga + ".");
            return;
        }

        System.out.println("Clubes da liga: " + liga);
        for (Clube clube : lista) {
            System.out.println("\uD83C\uDFDF️ Clube: " + clube.getNome());
        }
    }

    private class ClubesResponse {
        List<Clube> clubs;
    }
}
