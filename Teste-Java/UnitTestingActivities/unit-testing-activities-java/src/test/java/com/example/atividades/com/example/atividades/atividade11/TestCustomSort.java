package com.example.atividades.atividade11;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

public class TestCustomSort {

    @Test
    public void testCustomSort() {
        // Crie uma lista de números desordenados
        List<Integer> unsortedNumbers = Arrays.asList(5, 2, 9, 1, 3);

        // Crie uma instância de CustomSort
        CustomSort customSort = new CustomSort();

        // Chame o método customSort para ordenar a lista de números
        List<Integer> sortedNumbers = customSort.customSort(unsortedNumbers);

        // Verifique se a lista de números está ordenada corretamente em ordem decrescente
        List<Integer> expectedSortedNumbers = Arrays.asList(9, 5, 3, 2, 1);
        assertEquals(expectedSortedNumbers, sortedNumbers);
    }
}
