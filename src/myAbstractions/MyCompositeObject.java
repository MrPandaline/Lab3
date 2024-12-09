package myAbstractions;

import myExceptions.WrongAmountException;
import myInterfaces.PhysicalObjectArrayListFunc;

import java.util.ArrayList;

public abstract class MyCompositeObject extends PhysicalObject{
    private final ArrayList<PhysicalObject> objectParts;
    {
        objectParts = new ArrayList<>();
    }

    @Override
    public abstract String getDescription();

    public MyCompositeObject(String nm, int amount, String description) throws WrongAmountException {
        super(nm, amount, description);
    }
    public MyCompositeObject(String nm, int amount){
        super(nm, amount);
    }
    public MyCompositeObject(String nm){
        super(nm);
    }

    public void addObjectParts(PhysicalObject part){
        PhysicalObjectArrayListFunc addObjectParts = arrayList -> PhysicalObjectArrayListFunc.addToList(arrayList, part);
        addObjectParts.doWithList(objectParts);
    }

    public boolean isHavePart(PhysicalObject part){
        for(PhysicalObject partIterable: objectParts){
            if(partIterable.getName().equals(part.getName())){
                return true;
            }
        }
        return false;
    }

    public ArrayList<PhysicalObject> getObjectParts() {
        return objectParts;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + objectParts.hashCode(); // Генерация хэш-кода
    }

}
