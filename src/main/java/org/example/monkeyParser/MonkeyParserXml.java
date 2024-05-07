package org.example.monkeyParser;
import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.example.ape.Monkey;

import org.example.clothes.Clothes;
import org.example.clothes.Pocket;
import org.example.clothes.Uniform;
import org.example.item.CigarettePack;
import org.example.item.Item;
import org.example.item.Thing;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;

public class MonkeyParserXml implements MonkeyParser {
    @Override
    public Monkey parse(String filePath) throws IOException, ParserConfigurationException, SAXException {
        File inputFile = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();

        Node monkeyNode = doc.getElementsByTagName("Мартышка").item(0);
        Element monkeyElement = (Element) monkeyNode;

        String nameMonkey = monkeyElement.getNodeName();
        int age = Integer.parseInt(monkeyElement.getElementsByTagName("Возраст").item(0).getTextContent());
        String job = monkeyElement.getElementsByTagName("Работа").item(0).getTextContent();

        ArrayList<Clothes> clothes = new ArrayList<>();

        NodeList clothesNodeList = monkeyElement.getElementsByTagName("Одежда");
        for (int i = 0; i < clothesNodeList.getLength(); i++) {
            Node clothesNode = clothesNodeList.item(i);
            Element clothesElement = (Element) clothesNode;

            String clothesName = clothesElement.getElementsByTagName("Название").item(0).getTextContent();
            String color = clothesElement.getElementsByTagName("Цвет").item(0).getTextContent();
            ArrayList<Pocket> pockets = new ArrayList<>();

            NodeList pocketsNodeList = clothesElement.getElementsByTagName("Карманы");
            for (int j = 0; j < pocketsNodeList.getLength(); j++) {
                Node pocketNode = pocketsNodeList.item(j);
                Element pocketElement = (Element) pocketNode;
                ArrayList<Item> items = new ArrayList<>();

                NodeList itemsNodeList = pocketElement.getElementsByTagName("Предметы");
                for (int k = 0; k < itemsNodeList.getLength(); k++) {
                    Node itemNode = itemsNodeList.item(k);
                    Element itemElement = (Element) itemNode;
                    if (itemsNodeList.getLength()==1) {
                        NodeList itemCig = itemElement.getElementsByTagName("Пачка_сигарет");
                        Element cigNode =(Element)itemCig.item(0);
                        int currentNum = Integer.parseInt(cigNode.getElementsByTagName("Кол-во_сигарет").item(0).getTextContent());
                        int maxNum = Integer.parseInt(cigNode.getElementsByTagName("Максимальная_вместимость").item(0).getTextContent());
                        items.add(new CigarettePack(maxNum, currentNum));
                    } else {
                        String itemName = itemElement.getTextContent();
                        items.add(new Thing(itemName));
                    }
                }
                pockets.add(new Pocket(items));
            }

            clothes.add(new Uniform(clothesName, color, pockets));
        }
            return new Monkey(nameMonkey, age, job, clothes, "xml");
    }
}


