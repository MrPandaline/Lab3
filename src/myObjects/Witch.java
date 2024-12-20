package myObjects;

import myExceptions.WrongAmountException;
import myInterfaces.IEnchantableObject;

public class Witch extends Person{
    public Witch(String nm, int amount, String description) throws WrongAmountException {
        super(nm, amount, description);
    }
    public Witch(String nm, int amount) throws WrongAmountException {
        super(nm, amount);
    }
    public Witch(String nm) throws WrongAmountException {
        super(nm);
    }

    public void charm(IEnchantableObject aim){
        aim.beEnchanted();
        System.out.println("Ведьма " + this + " околдовывает " + aim);
    }
}
