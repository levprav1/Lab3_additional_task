package org.example.item;

public class CigarettePack extends Item {
    private int currentNum;
    private int maxNum;

    public CigarettePack(String name, int maxNum, int currentNum) {
        super(name);
        this.maxNum = maxNum;
        this.currentNum = currentNum;
    }
}
