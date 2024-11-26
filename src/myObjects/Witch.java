package myObjects;

import myInterfaces.IEnchantableObject;
import myInterfaces.IThinkingObject;
import states.AliveObjectState;

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

    public void charm(IEnchantableObject aim){
        aim.beEnchanted();
        System.out.println("Ведьма " + this + " околдовывает " + aim);
    }
}
