package myObjects;

import myInterfaces.IThinkingObject;

public class Witch extends Person{
    public Witch(String nm, int amount, String dcrptn){
        super(nm, amount, dcrptn);
    }
    public Witch(String nm, int amount){
        super(nm, amount);
    }
    public Witch(String nm){
        super(nm);
    }

    public void charm(IThinkingObject aim){
        aim.addState(new State("околдованный"));
        System.out.println("Ведьма " + this + " околдовывает " + aim);
    }
}
