package org.example.handlers;

import org.example.ape.Monkey;
import org.example.monkeyParser.MonkeyParserXml;

public class HandlerXML extends Handler {
    public HandlerXML() {
        setMonkeyParser(new MonkeyParserXml());
    }

    @Override
    public Monkey readFile(String path) {
        try {
            return getApeParser().parse(path);
        } catch (Exception e){
            return getNeighbour().readFile(path);
        }
    }
}
