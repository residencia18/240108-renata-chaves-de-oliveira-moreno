package tarefas;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorTarefas {
    private List<Tarefas> tarefas;

    public GerenciadorTarefas() {
        this.tarefas = new ArrayList<>();
    }

    public void adicionarTarefa(Tarefas tarefa) {
        tarefas.add(tarefa);
    }

    public void listarTarefas() {
        for (Tarefas tarefa : tarefas) {
            System.out.println("- " + tarefa.getTitulo() + " - " + tarefa.getDescricao() + " (Concluída: " + tarefa.isConcluida() + ")");
        }
    

    }
}

