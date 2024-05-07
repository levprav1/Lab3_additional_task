package org.example.monkeyParser;

import org.example.ape.Monkey;

import org.example.clothes.Clothes;
import org.example.clothes.Pocket;
import org.example.clothes.Uniform;
import org.example.item.CigarettePack;
import org.example.item.Item;
import org.example.item.Thing;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Map;

public class MonkeyParserYaml implements MonkeyParser {
    public Monkey parse(String filePath) throws IOException {
        Yaml yaml = new Yaml();
        InputStream inputStream = new FileInputStream(filePath);
        Map<String, Object> data = yaml.load(inputStream);

        Map<String, Object> monkeyData = (Map<String, Object>) data.get("Мартышка");

        String name = "Мартышка"; // Если имя не указано, используем ключ "Мартышка"
        int age = (int) monkeyData.get("Возраст");
        String job = (String) monkeyData.get("Работа");

        ArrayList<Clothes> clothes = new ArrayList<>();
        ArrayList<Object> clothesData = (ArrayList<Object>) monkeyData.get("Одежда");
        for (Object clothData : clothesData) {
            Map<String, Object> clothMap = (Map<String, Object>) clothData;
            String clothName = (String) clothMap.get("Название");
            String color = (String) clothMap.get("Цвет");
            ArrayList<Pocket> pockets = new ArrayList<>();
            ArrayList<Object> pocketData = (ArrayList<Object>) clothMap.get("Карманы");
            for (Object pocket : pocketData) {
                Map<String, Object> pocketMap = (Map<String, Object>) pocket;
                ArrayList<Item> items = new ArrayList<>();
                ArrayList<Object> itemData = (ArrayList<Object>) pocketMap.get("Предметы");
                for (Object item : itemData) {
                    if (item instanceof String) {
                        items.add(new Thing((String) item));
                    } else {
                        Map<String, Object> itemMap = (Map<String, Object>) item;
                        String itemName = (String) itemMap.keySet().iterator().next();
                        Map<String, Object> itemDetails = (Map<String, Object>) itemMap.get(itemName);
                        int currentNum = (int) itemDetails.get("Кол-во_сигарет");
                        int maxNum = (int) itemDetails.get("Максимальная_вместимость");
                        items.add(new CigarettePack(maxNum, currentNum));
                    }
                }
                pockets.add(new Pocket(items));
            }
            clothes.add(new Uniform(clothName, color, pockets));
        }

        return new Monkey(name, age, job, clothes, "yaml");
    }
}
