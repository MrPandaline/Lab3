package myObjects;

import myEnums.Amounts;
import myEnums.Locations;

public class Droplet extends MyObject{
    public Droplet(String nm, int amount, String dcrpt){
        super(nm, amount, dcrpt);
    }
    public Droplet(String nm, int amount){
        super(nm, amount);
    }
    public Droplet(String nm){
        super(nm);
    }

    public void moveAt(Locations loca){
        System.out.println(this + " катятся по " + loca);
    }

    @Override
    public String toString(){return
            (getAmount().equals(Amounts.ONE) ? "": getAmount() + " " ) + "капля " +
            getName() + (getDescription().isEmpty() ? "": ": " + getDescription());}
}
