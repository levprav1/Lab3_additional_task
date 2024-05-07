package org.example.ape;

import org.example.clothes.Clothes;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import java.util.ArrayList;

public class Monkey {

    private String name;
    private int age;
    private String job;
    private ArrayList<Clothes> clothes;
    private String source;

    public Monkey() {
    }

    public Monkey(String name, int age, String job, ArrayList<Clothes> clothes, String source) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.clothes = clothes;
        this.source = source;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public ArrayList<Clothes> getClothes() {
        return clothes;
    }

    public void setClothes(ArrayList<Clothes> clothes) {
        this.clothes = clothes;
    }

    public void addClothes(Clothes clothes) {
        this.clothes.add(clothes);
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public MutableTreeNode getNode() {
        DefaultMutableTreeNode monkeyNode = new DefaultMutableTreeNode(getName());
        monkeyNode.add(new DefaultMutableTreeNode("Возраст: "+getAge()));
        monkeyNode.add(new DefaultMutableTreeNode("Работа: "+getJob()));
        for (Clothes clothes1: clothes) {
            monkeyNode.add(clothes1.getNode());
        }
        monkeyNode.add(new DefaultMutableTreeNode("Источник: "+getSource()));
        return monkeyNode;
    }

    public void changeCigarette(int numbCigarette, String action) throws Exception {
        switch(action){
            case ("+"):
                addCigarette(numbCigarette);
                break;
            case ("-"):
                grabCigarette(numbCigarette);
                break;
            default:
                throw new Exception();
        }
    }
    private void addCigarette(int numbCigarette) throws Exception {
        for(Clothes clothes: clothes) {
            clothes.addCigarette(numbCigarette);
        }
    }

    private void grabCigarette(int numbCigarette) throws Exception {
        for(Clothes clothes: clothes) {
            clothes.grabCigarette(numbCigarette);
        }
    }
}
