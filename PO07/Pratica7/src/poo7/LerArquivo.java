package poo7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;

public class LerArquivo {

    public static List<Estudante> lerEstudantesDoArquivo(String nomeArquivo) {
        List<Estudante> estudantes = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            // Ler o conteúdo do arquivo para uma string
            StringBuilder conteudo = new StringBuilder();
            String linha;

            while ((linha = reader.readLine()) != null) {
                conteudo.append(linha);
            }

            // Converter a string para um JSONArray
            JSONArray jsonArray = new JSONArray(conteudo.toString());

            // Iterar sobre o JSONArray e reconstruir a lista de estudantes
            for (int i = 0; i < jsonArray.length(); i++) {
                try {
                    Estudante estudante = Estudante.fromJSON(jsonArray.getJSONObject(i));
                    estudantes.add(estudante);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return estudantes;
    }
}
