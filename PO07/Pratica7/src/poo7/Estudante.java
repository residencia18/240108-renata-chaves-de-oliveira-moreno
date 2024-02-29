package poo7;

import org.json.JSONObject;

public class Estudante {

    private String nome;
    private String cpf;
    private float cra;
    private int anoDeAdmissao;

    // Construtor da classe
    public Estudante(String nome, String cpf, float cra, int anoDeAdmissao) {
        this.nome = nome;
        this.cpf = cpf;
        this.cra = cra;
        this.anoDeAdmissao = anoDeAdmissao;
    }

    // Métodos getters e setters para acessar e modificar os atributos
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public float getCra() {
        return cra;
    }

    public void setCra(float cra) {
        this.cra = cra;
    }

    public int getAnoDeAdmissao() {
        return anoDeAdmissao;
    }

    public void setAnoDeAdmissao(int anoDeAdmissao) {
        this.anoDeAdmissao = anoDeAdmissao;
    }

    // Método para converter um objeto Estudante em formato JSON
    public JSONObject toJSON() {
        JSONObject jsonEstudante = new JSONObject();
        jsonEstudante.put("nome", this.nome);
        jsonEstudante.put("cpf", this.cpf);
        jsonEstudante.put("cra", this.cra);
        jsonEstudante.put("anoDeAdmissao", this.anoDeAdmissao);
        return jsonEstudante;
    }

    // Método para criar um objeto Estudante a partir de um objeto JSON
    public static Estudante fromJSON(JSONObject jsonEstudante) {
        String nome = jsonEstudante.getString("nome");
        String cpf = jsonEstudante.getString("cpf");
        float cra = (float) jsonEstudante.getDouble("cra");
        int anoDeAdmissao = jsonEstudante.getInt("anoDeAdmissao");
        return new Estudante(nome, cpf, cra, anoDeAdmissao);
    }

    @Override
    public String toString() {
        return "Estudante{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", cra=" + cra +
                ", anoDeAdmissao=" + anoDeAdmissao +
                '}';
    }
}
