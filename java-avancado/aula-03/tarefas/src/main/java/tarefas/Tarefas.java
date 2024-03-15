package tarefas;

public class Tarefas {
    private String titulo;
    private String descricao;
    private boolean concluida;

    public Tarefas(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.concluida = false; // Por padrão, a tarefa é criada como não concluída
    }

    public Tarefas(Object object, String string, boolean b) {
		// TODO Auto-generated constructor stub
	}

	// Getters e setters
    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }
}
