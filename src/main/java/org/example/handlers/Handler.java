package org.example.handlers;

import org.example.ape.Monkey;
import org.example.monkeyParser.MonkeyParser;

public abstract class Handler {
    private Handler neighbour;
    private MonkeyParser monkeyParser;

    public MonkeyParser getApeParser() {
        return monkeyParser;
    }

    public void setMonkeyParser(MonkeyParser monkeyParser) {
        this.monkeyParser = monkeyParser;
    }

    public Handler getNeighbour() {
        return neighbour;
    }

    public void setNeighbour(Handler neighbour) {
        this.neighbour = neighbour;
    }

    public abstract Monkey readFile(String path);
}
