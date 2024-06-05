package com.example.atividades.atividade09;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestItemCollection {

    private ItemCollection itemCollection;

    @BeforeEach
    public void setUp() {
        itemCollection = new ItemCollection();
    }

    @Test
    public void testAddItem() {
        Item item = new Item("Test Item");
        itemCollection.addItem(item);
        assertTrue(itemCollection.getItems().contains(item));
    }

    @Test
    public void testRemoveItem() {
        Item item = new Item("Test Item");
        itemCollection.addItem(item);
        itemCollection.removeItem(item);
        assertFalse(itemCollection.getItems().contains(item));
    }

    @Test
    public void testGetItems() {
        Item item1 = new Item("Item 1");
        Item item2 = new Item("Item 2");
        itemCollection.addItem(item1);
        itemCollection.addItem(item2);
        List<Item> items = itemCollection.getItems();
        assertEquals(2, items.size());
        assertTrue(items.contains(item1));
        assertTrue(items.contains(item2));
    }

    @Test
    public void testAddNullItem() {
        assertThrows(IllegalArgumentException.class, () -> {
            itemCollection.addItem(null);
        });
    }

    @Test
    public void testRemoveNonExistingItem() {
        Item item = new Item("Test Item");
        assertThrows(IllegalArgumentException.class, () -> {
            itemCollection.removeItem(item);
        });
    }
}
