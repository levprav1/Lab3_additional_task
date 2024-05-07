package org.example.clothes;

import org.example.item.CigarettePack;
import org.example.item.Item;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import java.util.ArrayList;

public class Pocket {
    private ArrayList<Item> items;

    public Pocket() {
    }

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

    public DefaultMutableTreeNode getNode(){
        DefaultMutableTreeNode pocketNode = new DefaultMutableTreeNode("Карман");
        for (Item item: items) {
            pocketNode.add(item.getNode());
        }
        return pocketNode;
    }
    public void addCigarette(int numbCigarette) throws Exception {
        for(Item item: items){
            if(item instanceof CigarettePack){
                if(((CigarettePack) item).canAddCigarette(numbCigarette)){
                    ((CigarettePack) item).addCigarette(numbCigarette);
                    throw new Exception();
                }
            }
        }
    }

    public void grabCigarette(int numbCigarette) throws Exception {
        for(Item item: items){
            if(item instanceof CigarettePack){
                if(((CigarettePack) item).canGrabCigarette(numbCigarette)){
                    ((CigarettePack) item).grabCigarette(numbCigarette);
                    throw new Exception();
                }
            }
        }
    }
}
