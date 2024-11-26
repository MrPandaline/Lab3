package myObjects;

import myAbstractions.PhysicalObject;
import myEnums.Locations;

public class Droplet extends PhysicalObject {
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
    public String toString(){return getAmount() + " капля " +
            getName() + (getDescription().isEmpty() ? "": ": " + getDescription());}
}
