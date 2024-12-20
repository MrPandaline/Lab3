package myAbstractions;

import myEnums.Location;
import myExceptions.WrongAmountException;

public abstract class PhysicalObject extends MyObject{
    final int amount;
    private Location location;
    {
        location = Location.SOMEWHERE;
    }

    public PhysicalObject(String nm) throws WrongAmountException{
        this(nm, 1 , "");
    }

    public PhysicalObject(String nm, int amount) throws WrongAmountException {
        this(nm, amount, "");
    }

    public PhysicalObject(String nm, int amount, String description) throws WrongAmountException{
        super(nm, description);
        if (amount <= 0){
            throw new WrongAmountException("Передано предмету " + this + " некорректное число " + amount +
                    "оно должно быть положительным");
        }
        this.amount = amount;
    }

    public Location getLocation(){ return location;}
    public void setLocation(Location location) throws WrongAmountException {this.location = location;}
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
