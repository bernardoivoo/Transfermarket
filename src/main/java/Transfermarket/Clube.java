package Transfermarket;

import com.google.gson.annotations.SerializedName;

public class Clube {
    private String id;

    @SerializedName("name") // Mapeia o campo "name" do JSON para "nome" no Java
    private String nome;

    @SerializedName("image")
    private String imagem;

    private String liga; // Campo adicionado para armazenar a liga do clube

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

    @Override
    public String toString() {
        return "Clube{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", imagem='" + imagem + '\'' +
                ", liga='" + liga + '\'' + // Exibe a liga na string
                '}';
    }
}
