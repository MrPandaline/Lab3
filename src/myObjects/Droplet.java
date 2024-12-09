package myObjects;

import myAbstractions.AliveObject;
import myAbstractions.PhysicalObject;
import myEnums.Locations;
import myExceptions.WrongAmountException;

import static java.lang.Math.abs;

public class Droplet extends PhysicalObject {
    public Droplet(String nm, int amount, String description) throws WrongAmountException {
        super(nm, amount, description);

    }
    public Droplet(String nm, int amount){
        super(nm, amount);
    }
    public Droplet(String nm){
        super(nm);
    }

    private PhysicalObject location;

    {
        location = new PhysicalObject(super.getLocation().toString()){};
    }

    public void moveAt(PhysicalObject object){
        System.out.println(this + " катятся по " + object);
    }

    @Override
    public Locations getLocation(){
        for (Locations location : Locations.values()){
            if (location.name().equals(this.location.getName())) {
                return location;
            }
        }
        return this.location.getLocation();
    }
    @Override
    public void setLocation(Locations location) {
        this.location = new PhysicalObject(location.toString()) {
        };
    }

    public void setLocation(PhysicalObject location){ this.location = location; }


    @Override
    public String toString(){return getAmount() + " капля " +
            getName() + (getDescription().isEmpty() ? "": ": " + getDescription());}
}
