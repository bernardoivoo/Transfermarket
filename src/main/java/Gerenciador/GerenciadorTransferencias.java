/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gerenciador;

import Transfermarket.Transferencia;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;
import java.util.List;

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
            List<Transferencia> transferencias = gson.fromJson(json, new TypeToken<List<Transferencia>>() {}.getType());

            return transferencias;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

