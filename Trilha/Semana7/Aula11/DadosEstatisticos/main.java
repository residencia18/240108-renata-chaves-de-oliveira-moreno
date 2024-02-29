package DadosEstatisticos;

import java.util.Arrays;

class DatasDeNascimento extends DadosEstatisticos {
    private int[] datas;

    public DatasDeNascimento(int[] datas) {
        this.datas = datas;
    }

    @Override
    public int maximo() {
        return Arrays.stream(datas).max().orElse(0);
    }

    @Override
    public int minimo() {
        return Arrays.stream(datas).min().orElse(0);
    }

    @Override
    public void ordenar() {
        Arrays.sort(datas);
    }

    @Override
    public boolean buscar(int valor) {
        return Arrays.stream(datas).anyMatch(x -> x == valor);
    }
}

class TemperaturasDoPeriodo extends DadosEstatisticos {
    private int[] temperaturas;

    public TemperaturasDoPeriodo(int[] temperaturas) {
        this.temperaturas = temperaturas;
    }

    @Override
    public int maximo() {
        return Arrays.stream(temperaturas).max().orElse(0);
    }

    @Override
    public int minimo() {
        return Arrays.stream(temperaturas).min().orElse(0);
    }

    @Override
    public void ordenar() {
        Arrays.sort(temperaturas);
    }

    @Override
    public boolean buscar(int valor) {
        return Arrays.stream(temperaturas).anyMatch(x -> x == valor);
    }
}

class CidadesDoBrasil extends DadosEstatisticos {
    private int[] populacoes;

    public CidadesDoBrasil(int[] populacoes) {
        this.populacoes = populacoes;
    }

    @Override
    public int maximo() {
        return Arrays.stream(populacoes).max().orElse(0);
    }

    @Override
    public int minimo() {
        return Arrays.stream(populacoes).min().orElse(0);
    }

    @Override
    public void ordenar() {
        Arrays.sort(populacoes);
    }

    @Override
    public boolean buscar(int valor) {
        return Arrays.stream(populacoes).anyMatch(x -> x == valor);
    }
}

public class main {
    public static void main(String[] args) {
        DatasDeNascimento datas = new DatasDeNascimento(new int[]{19900101, 19851215, 20030420});
        TemperaturasDoPeriodo temperaturas = new TemperaturasDoPeriodo(new int[]{25, 30, 15, 20});
        CidadesDoBrasil cidades = new CidadesDoBrasil(new int[]{1000000, 500000, 2000000});

        // Executando os métodos
        System.out.println("Máximo de datas: " + datas.maximo());
        System.out.println("Mínimo de temperaturas: " + temperaturas.minimo());
        System.out.println("Ordenando cidades...");
        cidades.ordenar();
        System.out.println("Buscando temperatura 25: " + temperaturas.buscar(25));
    }
}
