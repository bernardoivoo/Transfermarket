package Gerenciador;

import Transfermarket.Clube;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class GerenciadorClube {
    private static final String API_URL = "https://transfermarket.p.rapidapi.com/clubs/list-by-competition?id=IT1&domain=de";
    private static final String API_KEY = "51a5628402mshedf0e2040b28bd0p1c7eb4jsnab192d4f4280";

    private final OkHttpClient client = new OkHttpClient();

    public List<Clube> buscarClubes() {
       Request request = new Request.Builder()
     .url("https://transfermarket.p.rapidapi.com/clubs/list-by-competition?id=IT1&domain=de")
        .get()
        .addHeader("x-rapidapi-key", "51a5628402mshedf0e2040b28bd0p1c7eb4jsnab192d4f4280")
        .addHeader("x-rapidapi-host", "transfermarket.p.rapidapi.com")
        .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                System.out.println("Erro na requisição: " + response.code() + " - " + response.message());
                throw new IOException("Erro na requisição: " + response);
            }

            // Converter JSON para lista de clubes
            String json = response.body().string();
            System.out.println("Resposta JSON: " + json); // Log para depuração
            
            Gson gson = new Gson();
            List<Clube> clubes = gson.fromJson(json, new TypeToken<List<Clube>>() {}.getType());
            
            if (clubes == null || clubes.isEmpty()) {
                System.out.println("Nenhum clube encontrado na resposta da API.");
            }
            return clubes;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Método para buscar um clube específico pelo nome
    public Clube buscarClubePorNome(String nomeClube) {
        List<Clube> clubes = buscarClubes();
        if (clubes == null) return null;

        return clubes.stream()
            .filter(clube -> clube.getNome().equalsIgnoreCase(nomeClube))
            .findFirst()
            .orElse(null);
    }

    // Método para listar todos os clubes de uma liga específica
    public List<Clube> listarClubesPorLiga(String nomeLiga) {
        List<Clube> clubes = buscarClubes();
        if (clubes == null) return null;

        // Log para verificar clubes e suas ligas
        for (Clube clube : clubes) {
            System.out.println("Verificando clube: " + clube.getNome() + " | Liga: " + (clube.getLiga() != null ? clube.getLiga().getNome() : "N/A"));
        }

        return clubes.stream()
            .filter(clube -> clube.getLiga() != null && clube.getLiga().getNome().equalsIgnoreCase(nomeLiga)) 
            .collect(Collectors.toList());
    }

    // Método para exibir clubes formatados
    public void exibirClubes(List<Clube> lista) {
        if (lista == null || lista.isEmpty()) {
            System.out.println("Nenhum clube encontrado.");
            return;
        }

        for (Clube clube : lista) {
            System.out.println("\uD83C\uDFDF️ Clube: " + clube.getNome() + " | Liga: " + (clube.getLiga() != null ? clube.getLiga().getNome() : "Desconhecida"));
        }
    }
}