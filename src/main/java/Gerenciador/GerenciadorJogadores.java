/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gerenciador;

/**
 *
 * @author berna
 */

import Transfermarket.Jogador;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;
import java.util.List;

public class GerenciadorJogadores {
    private static final String API_URL = "https://transfermarket-api.p.rapidapi.com/players";
    private static final String API_KEY = "51a5628402mshedf0e2040b28bd0p1c7eb4jsnab192d4f4280";

    private final OkHttpClient client = new OkHttpClient();

   public List<Jogador> buscarJogadores() {
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

            // Converter JSON para lista de jogadores
            String json = response.body().string();
            Gson gson = new Gson();
            List<Jogador> jogadores = gson.fromJson(json, new TypeToken<List<Jogador>>() {}.getType());

            return jogadores;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
