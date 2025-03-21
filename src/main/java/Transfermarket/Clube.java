package Transfermarket;

import com.google.gson.annotations.SerializedName;

public class Clube {
    private String id;

    @SerializedName("name") // Mapeia o campo "name" do JSON para "nome" no Java
    private String nome;

    @SerializedName("image")
    private String imagem;

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getImagem() {
        return imagem;
    }

    @Override
    public String toString() {
        return "Clube{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", imagem='" + imagem + '\'' +
                '}';
    }
}
