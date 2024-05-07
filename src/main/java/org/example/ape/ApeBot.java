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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public int getNumbCigarette() {
        return numbCigarette;
    }

    public void setNumbCigarette(int numbCigarette) {
        this.numbCigarette = numbCigarette;
    }
}
