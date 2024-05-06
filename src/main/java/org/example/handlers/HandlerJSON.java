package org.example.handlers;

import org.example.ape.Monkey;
import org.example.monkeyParser.MonkeyParserJson;

public class HandlerJSON extends Handler {
    public HandlerJSON() {
        setMonkeyParser(new MonkeyParserJson());
    }

    @Override
    public Monkey readFile(String path) {
        try {
            return getApeParser().parse(path);
        } catch (Exception e) {
            return getNeighbour().readFile(path);
        }
    }
}
