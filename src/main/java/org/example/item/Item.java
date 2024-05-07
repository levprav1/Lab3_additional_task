package org.example.item;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

public abstract class Item {
    protected String name;

    public Item(String name) {
        this.name = name;
    }

    public Item() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DefaultMutableTreeNode getNode(){
        DefaultMutableTreeNode itemNode = new DefaultMutableTreeNode(getName());
        return itemNode;
    }

}
