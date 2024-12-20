package myObjects;

import myAbstractions.PhysicalObject;
import myEnums.Location;
import myExceptions.WrongAmountException;

import static java.lang.Math.abs;

public class Droplet extends PhysicalObject {
    public Droplet(String nm, int amount, String description) throws WrongAmountException {
        super(nm, amount, description);

    }
    public Droplet(String nm, int amount) throws WrongAmountException {
        super(nm, amount);
    }
    public Droplet(String nm) throws WrongAmountException {
        super(nm);
    }

    private PhysicalObject location;

    {
        try {
            location = new PhysicalObject(super.getLocation().toString()){};
        } catch (WrongAmountException e) {
            System.out.println(e.getMessage());
            System.out.println("отрицательное число предметов схлопнуло вселенную в точку," +
                    " сценарий невозможно проиграть из-за произошедшего апокалипсиса");
        }
    }

    public void moveAt(PhysicalObject object){
        System.out.println(this + " катятся по " + object);
    }

    @Override
    public Location getLocation(){
        for (Location location : Location.values()){
            if (location.name().equals(this.location.getName())) {
                return location;
            }
        }
        return this.location.getLocation();
    }
    @Override
    public void setLocation(Location location) throws WrongAmountException {
        this.location = new PhysicalObject(location.toString()) {};
    }

    public void setLocation(PhysicalObject location){ this.location = location; }


    @Override
    public String toString(){return getAmount() + " капля " +
            getName() + (getDescription().isEmpty() ? "": ": " + getDescription());}
}
