package API;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author berna
 */
public class Infoclubes {

    private static final String API_URL = "https://transfermarket-api.p.rapidapi.com/teams";
    private static final String API_KEY = "51a5628402mshedf0e2040b28bd0p1c7eb4jsnab192d4f4280";

    public String buscarClubes() {
        try {
            URL url = new URL(API_URL);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-RapidAPI-Key", API_KEY);
            con.setRequestProperty("X-RapidAPI-Host", "transfermarket-api.p.rapidapi.com");

            int responseCode = con.getResponseCode();
            if (responseCode == 200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                return response.toString();
            } else {
                return "Erro na requisição. Código: " + responseCode;
            }

        } catch (Exception e) {
            return "Erro: " + e.getMessage();
        }
    }
}

