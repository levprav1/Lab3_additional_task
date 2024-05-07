package org.example;

import org.example.ape.Gibbon;
import org.example.ape.Gorilla;
import org.example.convertFiles.ConvertJson2types;
import org.example.handlers.HandlerBuilder;

import javax.swing.tree.DefaultMutableTreeNode;
import java.io.IOException;

public class DataManipulation {
    private ApeManipulation apeManipulation = new ApeManipulation();
    private ConvertJson2types convertJson2types;
    private HandlerBuilder handlerBuilder =  new HandlerBuilder();


    public void createFiles() throws IOException {
        convertJson2types = new ConvertJson2types();
        convertJson2types.convert2yaml();
        convertJson2types.convert2xml();
    }

    public void importData(String path) {
        apeManipulation.setMonkey(handlerBuilder.getData(path));
    }

    public DefaultMutableTreeNode addInfo2GUI() {
        return apeManipulation.addInfo2GUI();
    }
    public void meetGorilla() throws Exception {
        apeManipulation.meetApe(new Gorilla());
    }
    public void meetGibon() throws Exception {
        apeManipulation.meetApe(new Gibbon());
    }
    public boolean hasMonkey(){
        return apeManipulation.hasMonkey();
    }
}
