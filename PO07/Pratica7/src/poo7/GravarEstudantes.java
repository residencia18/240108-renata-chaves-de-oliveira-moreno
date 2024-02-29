package poo7;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.json.JSONArray;

public class GravarEstudantes {

    public static void gravarEstudantesParaArquivo(List<Estudante> estudantes, String nomeArquivo) {
        JSONArray jsonArray = new JSONArray();

        // Converter cada estudante para formato JSON e adicioná-los ao array JSON
        for (Estudante estudante : estudantes) {
            jsonArray.put(estudante.toJSON());
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            // Escrever o array JSON no arquivo
            writer.write(jsonArray.toString(4)); // O argumento '4' é a quantidade de espaços para indentação
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
