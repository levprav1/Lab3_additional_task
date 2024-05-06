package org.example.clothes;

import org.example.item.Item;

import java.util.ArrayList;

public class Pocket {
    private ArrayList<Item> items;

    public Pocket(ArrayList<Item> items) {
        this.items = items;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
    public void addItem(Item item) {
        items.add(item);
    }
}
