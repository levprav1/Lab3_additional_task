package org.example.handlers;

import org.example.ape.Monkey;

public class HandlerBuilder {
    private Handler xml;
    private Handler yaml;
    private Handler json;

    public Monkey getData(String path){
        setParam();
        return json.readFile(path);
    }

    private void setParam() {
        this.xml = new HandlerXML();
        this.yaml = new HandlerYAML();
        this.json = new HandlerJSON();

        json.setNeighbour(yaml);
        yaml.setNeighbour(xml);

    }


}
