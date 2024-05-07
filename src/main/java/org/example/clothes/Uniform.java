package org.example.clothes;

import javax.swing.tree.DefaultMutableTreeNode;
import java.util.ArrayList;

public class Uniform extends Clothes {

    private ArrayList<Pocket> pockets;

    public Uniform() {
    }

    public Uniform(String name, String color, ArrayList<Pocket> pockets) {
        super(name, color);
        this.pockets = pockets;
    }

    public ArrayList<Pocket> getPockets() {
        return pockets;
    }

    public void setPockets(ArrayList<Pocket> pockets) {
        this.pockets = pockets;
    }

    public void addPocket(Pocket pocket) {
        pockets.add(pocket);
    }

    public DefaultMutableTreeNode getNode() {
        DefaultMutableTreeNode clothesNode = new DefaultMutableTreeNode("Одежда");
        clothesNode.add(new DefaultMutableTreeNode("Название: " + getName()));
        clothesNode.add(new DefaultMutableTreeNode("Цвет: " + getColor()));
        for (Pocket pocket : pockets) {
            clothesNode.add(pocket.getNode());
        }
        return clothesNode;
    }

    public void addCigarette(int numbCigarette) throws Exception {
        for (Pocket pocket : pockets) {
            pocket.addCigarette(numbCigarette);
        }
    }

    public void grabCigarette(int numbCigarette) throws Exception {
        for (Pocket pocket : pockets) {
            pocket.grabCigarette(numbCigarette);
        }
    }
}
