package myObjects;

import myAbstractions.AliveObject;
import myAbstractions.MyObject;
import myAbstractions.PhysicalObject;
import myEnums.Daytime;
import myEnums.Locations;
import myExceptions.LogicalContradiction;
import myExceptions.WrongAmountException;
import myInterfaces.IEnchantableObject;
import myInterfaces.ISuspectableObject;
import myInterfaces.IThinkingObject;
import states.AliveObjectState;
import states.WorldState;

import java.util.ArrayList;
import java.util.Arrays;

public class Person extends AliveObject implements IThinkingObject{
    private ArrayList<PhysicalObject> inventory;
    {
        inventory = new ArrayList<>();
    }

    public Person(String nm, int amount, String description) throws WrongAmountException {
        super(nm, amount, description);
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
        String[] bodyParts = {"язык", "щёки", "мозг", "сердце", "ноги", "голова"};
        for (String bpart: bodyParts){
            try {
                addObjectParts(new BodyPart(bpart));
            } catch (WrongAmountException e) {
                System.out.println("У человека отсутствуют органы");
            }
        }
    }

    public ArrayList<PhysicalObject> getInventory(){return inventory;}

    public void addToInventory(PhysicalObject obj){
        PhysicalObject[] locCopyInventory = inventory.toArray(new PhysicalObject[0]);
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

    public void say(String phrase) {
        System.out.println(this + " говорит " + phrase);
    }

    public void say(String phrase, Person aim) throws LogicalContradiction{
        if(this.getLocation().equals(aim.getLocation())) {
            System.out.println(this + " говорит " + phrase + ". Обращаяется к " + aim);
        }
        else { throw new LogicalContradiction(this + " и " + aim + " находятся в разных локациях");}
    }

    public void shake(String bodyPart) throws LogicalContradiction, WrongAmountException {
        if (isHavePart(new BodyPart(bodyPart))){
            System.out.println(this + " трясёт " + bodyPart);
        }
        else {
            throw new LogicalContradiction(this + " не имеет части тела " + bodyPart);
        }
    }

    public void see(PhysicalObject object) throws LogicalContradiction{
        if (object.getLocation().equals(getLocation())){
            System.out.println(this + " увидел " + object);
        }
        else{
            throw new LogicalContradiction(this + " не может увидеть " + object + ": они находятся в разных локациях");
        }
    }

    public void disappear(){
        System.out.println(this + " скрывается из " + getLocation());
        setLocation(Locations.SOMEWHERE);
    }
}
