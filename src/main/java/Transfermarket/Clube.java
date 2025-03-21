package Transfermarket;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Clube {
    private String id;

    @SerializedName("name") // Mapeia o campo "name" do JSON para "nome" no Java
    private String nome;

    @SerializedName("image")
    private String imagem;

    private String liga; // Campo adicionado para armazenar a liga do clube

    private List<String> plantel; // Lista de jogadores

    // Getters e Setters
    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getImagem() {
        return imagem;
    }

    public String getLiga() {
        return liga;
    }

    public void setLiga(String liga) {
        this.liga = liga;
    }

    public List<String> getPlantel() {
        return plantel;
    }

    public void setPlantel(List<String> plantel) {
        this.plantel = plantel;
    }

    @Override
    public String toString() {
        return "Clube{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", imagem='" + imagem + '\'' +
                ", liga='" + liga + '\'' +
                ", plantel=" + (plantel != null ? plantel : "Não disponível") +
                '}';
    }
}
