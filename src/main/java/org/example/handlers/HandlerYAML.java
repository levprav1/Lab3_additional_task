package org.example.handlers;

import org.example.ape.Monkey;
import org.example.monkeyParser.MonkeyParserYaml;

public class HandlerYAML extends Handler {
    public HandlerYAML() {
        setMonkeyParser(new MonkeyParserYaml());
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
