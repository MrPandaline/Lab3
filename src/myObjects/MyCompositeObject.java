package myObjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public abstract class MyCompositeObject extends MyObject{
    private ArrayList<MyObject> objectParts;
    {
        objectParts = new ArrayList<>();
    }

    @Override
    public abstract String getDescription();

    public MyCompositeObject(String nm, int amount, String dcrpt){
        super(nm, amount, dcrpt);
    }
    public MyCompositeObject(String nm, int amount){
        super(nm, amount);
    }
    public MyCompositeObject(String nm){
        super(nm);
    }

    public void addObjectParts(MyObject part){ //надо бы посмотреть и тоже подправить
        MyObject[] locCopyObjectParts = objectParts.toArray(new MyObject[0]);
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

    public boolean isHavePart(MyObject part){
        for(MyObject partIterable: objectParts){
            if(partIterable.getName().equals(part.getName())){
                return true;
            }
        }
        return false;
    }

    public ArrayList<MyObject> getObjectParts() {
        return objectParts;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getStates(), getLocation(), getObjectParts()); // Генерация хэш-кода
    }

}
