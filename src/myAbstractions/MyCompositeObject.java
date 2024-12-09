package myAbstractions;

import myExceptions.WrongAmountException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public abstract class MyCompositeObject extends PhysicalObject{
    private ArrayList<PhysicalObject> objectParts;
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

    public void addObjectParts(PhysicalObject part){ //надо бы посмотреть и тоже подправить
        PhysicalObject[] locCopyObjectParts = objectParts.toArray(new PhysicalObject[0]);
        boolean alreadyInObjectParts = false;
        for (int i = 0; i< locCopyObjectParts.length; i++ ) {
            if (locCopyObjectParts[i].getName().equals(part.getName())){
                alreadyInObjectParts = true;
                locCopyObjectParts[i] = part;
            }
        }
        if(alreadyInObjectParts) {
            objectParts = new ArrayList<>(Arrays.asList(locCopyObjectParts));
        }
        else{
            objectParts.add(part);
        }
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
