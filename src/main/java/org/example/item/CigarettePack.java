package org.example.item;

import javax.swing.tree.DefaultMutableTreeNode;

public class CigarettePack extends Item {
    private int currentNum;
    private int maxNum;

    public CigarettePack() {
        super("Пачка сигарет");
    }

    public CigarettePack(int maxNum, int currentNum) {
        super("Пачка сигарет");
        this.maxNum = maxNum;
        this.currentNum = currentNum;
    }

    public int getCurrentNum() {
        return currentNum;
    }

    public void setCurrentNum(int currentNum) {
        this.currentNum = currentNum;
    }

    public int getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(int maxNum) {
        this.maxNum = maxNum;
    }
    public DefaultMutableTreeNode getNode(){
        DefaultMutableTreeNode itemNode = new DefaultMutableTreeNode(getName());
        itemNode.add(new DefaultMutableTreeNode("Кол-во сигарет: "+getCurrentNum()));
        itemNode.add(new DefaultMutableTreeNode("Максимальное кол-во: "+getMaxNum()));
        return itemNode;
    }

    public boolean canAddCigarette(int numbCigarette){
        if ((currentNum + numbCigarette)> maxNum) return false;
        else return true;
    }

    public boolean canGrabCigarette(int numbCigarette){
        if ((currentNum - numbCigarette)< 0) return false;
        else return true;
    }

    public void addCigarette(int numbCigarette){
        currentNum+=numbCigarette;
    }

    public void grabCigarette(int numbCigarette){
        currentNum-= numbCigarette;
    }
}
