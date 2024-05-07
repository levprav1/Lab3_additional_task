package org.example;

import org.example.ape.ApeBot;
import org.example.ape.Monkey;

import javax.swing.tree.DefaultMutableTreeNode;

public class ApeManipulation {
    private Monkey monkey;

    public Monkey getMonkey() {
        return monkey;
    }

    public void setMonkey(Monkey monkey) {
        this.monkey = monkey;
    }

    public DefaultMutableTreeNode addInfo2GUI(){
        DefaultMutableTreeNode main = new DefaultMutableTreeNode("Обезьяны");
        main.add(monkey.getNode());
        return main;
    }

    public void meetApe(ApeBot apeBot) throws Exception {
        monkey.changeCigarette(apeBot.getNumbCigarette(), apeBot.getAction());
    }

    public boolean hasMonkey() {
        if (monkey == null) return false;
        else return true;
    }
}
