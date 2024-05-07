package org.example.clothes;

import javax.swing.tree.DefaultMutableTreeNode;

public abstract class Clothes {
    protected String name;
    protected String color;

    public Clothes(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public Clothes() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public DefaultMutableTreeNode getNode() {
        DefaultMutableTreeNode clothesNode = new DefaultMutableTreeNode(getName());
        clothesNode.add(new DefaultMutableTreeNode("Цвет: "+getColor()));
        return clothesNode;
    }

    public abstract void addCigarette(int numbCigarette) throws Exception;
    public abstract void grabCigarette(int numbCigarette) throws Exception;
}
