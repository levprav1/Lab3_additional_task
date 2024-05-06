package org.example.clothes;

import java.util.ArrayList;

public class Uniform extends Clothes{

    private ArrayList<Pocket> pockets;

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
}
