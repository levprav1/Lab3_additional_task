package org.example.monkeyParser;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import org.example.ape.Monkey;
import org.example.clothes.Clothes;
import org.example.clothes.Pocket;
import org.example.clothes.Uniform;
import org.example.item.CigarettePack;
import org.example.item.Item;
import org.example.item.Thing;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;


public class MonkeyParserJson implements MonkeyParser {
    public Monkey parse(String filePath) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode rootNode = objectMapper.readTree(new File(filePath));

        Map<String, JsonNode> monkeyMap = objectMapper.convertValue(rootNode.get("Мартышка"), new TypeReference<Map<String, JsonNode>>() {
        });

        Monkey monkey = new Monkey();
        monkey.setName("Мартышка");
        monkey.setAge(monkeyMap.get("Возраст").asInt());
        monkey.setJob(monkeyMap.get("Работа").asText());
        monkey.setSource("json");

        ArrayList<Clothes> clothes = new ArrayList<>();
        for (JsonNode clothesNode : monkeyMap.get("Одежда")) {
            Uniform clothes1 = new Uniform();
            clothes1.setName(clothesNode.get("Название").asText());
            clothes1.setColor(clothesNode.get("Цвет").asText());

            ArrayList<Pocket> pockets = new ArrayList<>();
            for (JsonNode pocketNode : clothesNode.get("Карманы")) {
                Pocket pocket = new Pocket();
                ArrayList<Item> items = new ArrayList<>();
                for (JsonNode itemNode : pocketNode.get("Предметы")) {
                    if (itemNode.isTextual()) {
                        Thing thing = new Thing();
                        thing.setName(itemNode.asText());
                        items.add(thing);
                    } else {
                        JsonNode cigarPack = itemNode.get("Пачка_сигарет");
                        CigarettePack pack = new CigarettePack();
                        pack.setCurrentNum(cigarPack.get("Кол-во_сигарет").asInt());
                        pack.setMaxNum(cigarPack.get("Максимальная_вместимость").asInt());
                        items.add(pack);
                    }
                }
                pocket.setItems(items);
                pockets.add(pocket);
            }
            clothes1.setPockets(pockets);
            clothes.add(clothes1);
        }
        monkey.setClothes(clothes);
        return monkey;
    }
}
