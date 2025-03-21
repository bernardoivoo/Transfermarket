package Gerenciador;

import Transfermarket.Transferencia;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class GerenciadorTransferencias {
    private static final String API_URL = "https://transfermarket-api.p.rapidapi.com/transfers";
    private static final String API_KEY = "51a5628402mshedf0e2040b28bd0p1c7eb4jsnab192d4f4280";

    private final OkHttpClient client = new OkHttpClient();

    public List<Transferencia> buscarTransferencias() {
        Request request = new Request.Builder()
            .url(API_URL)
            .get()
            .addHeader("X-RapidAPI-Key", API_KEY)
            .addHeader("X-RapidAPI-Host", "transfermarket-api.p.rapidapi.com")
            .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Erro na requisição: " + response);
            }

            // Converter JSON para lista de transferências
            String json = response.body().string();
            Gson gson = new Gson();
            return gson.fromJson(json, new TypeToken<List<Transferencia>>() {}.getType());

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Método para listar transferências por clube
    public List<Transferencia> listarTransferenciasPorClube(String nomeClube) {
        List<Transferencia> transferencias = buscarTransferencias();
        if (transferencias == null) return null;

        return transferencias.stream()
            .filter(t -> t.getClubeOrigem().getNome().equalsIgnoreCase(nomeClube) || 
                         t.getClubeDestino().getNome().equalsIgnoreCase(nomeClube))
            .collect(Collectors.toList());
    }


}
