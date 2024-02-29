package DadosEstatisticos;

import java.util.Arrays;

@SuppressWarnings("unused")
abstract class DadosEstatisticos {
    abstract int maximo();
    abstract int minimo();
    abstract void ordenar();
    abstract boolean buscar(int valor);
}

