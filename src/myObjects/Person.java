package myObjects;

import myEnums.BodyPartEnum;
import myEnums.Locations;
import myInterfaces.IThinkingObject;

import java.util.ArrayList;
import java.util.Arrays;

public class Person extends MyCompositeObject implements IThinkingObject {
    private ArrayList<MyObject> inventory;

    {
        inventory = new ArrayList<>();
    }

    public Person(String nm, int amount, String dcrptn){
        super(nm, amount, dcrptn);
    }
    public Person(String nm, int amount){
        super(nm, amount);
    }
    public Person(String nm){
        super(nm);
    }

    @Override
    public String getDescription(){
        if(!getInventory().isEmpty()){
            ArrayList<String> message = new ArrayList<>();
            for (MyObject thing : getInventory()){
                message.add(thing.toString());
            }
            return "обладает " + String.join(",", message) +
                    (description.isEmpty() ? "": " " + description);
        }
        else {
            return description;
        }
    }

    {
        for (BodyPartEnum bpart: BodyPartEnum.values()){
            addObjectParts(new BodyPart(bpart));
        }
    }

    public ArrayList<MyObject> getInventory(){return inventory;}

    public void addToInventory(MyObject obj){
        MyObject[] locCopyInventory = inventory.toArray(new MyObject[0]);
        boolean alreadyInObjectParts = false;
        for (int i = 0; i< locCopyInventory.length; i++ ) {
            if (locCopyInventory[i].getName().equals(obj.getName())){
                alreadyInObjectParts = true;
                locCopyInventory[i] = obj;
            }
        }
        if(alreadyInObjectParts) {
            inventory = new ArrayList<>(Arrays.asList(locCopyInventory));
        }
        else{
            inventory.add(obj);
        }

    }
    public boolean isHaveInInventory(MyObject obj){
        for(MyObject partIterable: inventory){
            if(partIterable.getName().equals(obj.getName())){
                return true;
            }
        }
        return false;
    }


    public void sleep(){
        State sleeping = new State("спит");
        if (isHaveState(sleeping)) {
            this.removeState(sleeping);
            System.out.println(this + " больше не " + sleeping.stateName());
        }
        else{
            this.addState(sleeping);
            System.out.println(this + " " + sleeping.stateName());
        }
    }

    public void say(String phrase){
        System.out.println(this + " говорит " + phrase);
    }

    public void say(String phrase, Person aim){
        if(this.getLocation().equals(aim.getLocation())) {
            System.out.println(this + " говорит " + phrase + ". Обращаяется к " + aim);
        }
    }

    public void walk(Locations locations){
        if (getLocation().equals(locations)){
            System.out.println(this + " ходит по " + locations);
        }
        else{
            System.out.println(this + " идёт из " + getLocation() + " в " + locations);
            setLocation(locations);
        }
    }

    public void walk(MyObject aim) {
        System.out.println(this + " идёт к " + aim + " в " + aim.getLocation());
        setLocation(aim.getLocation());
    }

    public void shake(BodyPartEnum bodyPart){
        if (isHavePart(new BodyPart(bodyPart))){
            System.out.println(this + " трясёт " + bodyPart.toString());
        }
        // если нет, то бросить логическое исключение
    }

    public void see(MyObject object){
        if (object.getLocation().equals(getLocation())){
            System.out.println(this + " увидел " + object);
        }
    }

    public void disappear(){
        System.out.println(this + " скрывается из " + getLocation());
        setLocation(Locations.SOMEWHERE);
    }
}
