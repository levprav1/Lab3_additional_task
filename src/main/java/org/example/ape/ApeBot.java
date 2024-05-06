package org.example.ape;

public abstract class ApeBot {
    protected String name;
    protected String action;
    protected int numbCigarette;

    public ApeBot(String name, String action, int numbCigarette) {
        this.name = name;
        this.action = action;
        this.numbCigarette = numbCigarette;
    }
}
