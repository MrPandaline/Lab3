package myAbstractions;

import myEnums.Locations;

public abstract class PhysicalObject extends MyObject{
    final int amount;
    private Locations location;
    {
        location = Locations.SOMEWHERE;
    }

    public PhysicalObject(String nm) {
        this(nm, 1);
    }

    public PhysicalObject(String nm, int amount){
        super(nm);
        this.amount = amount;
    }

    public PhysicalObject(String nm, int amount, String dcrptn){
        super(nm, dcrptn);
        this.amount = amount;
    }

    public Locations getLocation(){ return location;}
    public void setLocation(Locations loca) {this.location = loca;}
    public int getAmount(){ return amount;}

    @Override
    public int hashCode() {
        return super.hashCode() * amount + location.hashCode(); // Генерация хэш-кода
    }

    @Override
    public String toString(){
        return (amount == 1 ? "" : amount + " ") + super.toString();
    }
}
