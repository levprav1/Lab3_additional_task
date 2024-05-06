package org.example.monkeyParser;

import org.example.ape.ApeBot;
import org.example.ape.Monkey;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public interface MonkeyParser {
    public Monkey parse(String filePath) throws IOException, ParserConfigurationException, SAXException;
}
