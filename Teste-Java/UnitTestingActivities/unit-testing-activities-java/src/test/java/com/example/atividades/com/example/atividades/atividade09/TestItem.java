package com.example.atividades.atividade09;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TestItem {

    @Test
    public void testGetName() {
        String itemName = "Example Item";
        Item item = new Item(itemName);
        assertEquals(itemName, item.getName());
    }
}
