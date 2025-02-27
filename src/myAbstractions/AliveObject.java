package myAbstractions;

import myEnums.Daytime;
import myEnums.Location;
import myExceptions.LogicalContradiction;
import myExceptions.WrongAmountException;
import myInterfaces.IEnchantableObject;
import myInterfaces.ISuspectableObject;
import myObjects.World;
import states.AliveObjectState;
import states.WorldState;

import java.util.ArrayList;

public abstract class AliveObject extends MyCompositeObject implements IEnchantableObject, ISuspectableObject {
    public AliveObject(String nm, int amount, String description) throws WrongAmountException {
        super(nm, amount, description);
    }
    public AliveObject(String nm, int amount) throws WrongAmountException {
        super(nm, amount);
    }
    public AliveObject(String nm) throws WrongAmountException {
        super(nm);
    }
    private final ArrayList<AliveObjectState> aliveObjectStates;
    {
        aliveObjectStates = new ArrayList<>();
    }

    public void addState(AliveObjectState AliveObjectState){
        boolean alreadyInStates = false;
        for (int i = 0; i< aliveObjectStates.size(); i++ ) {
            if (aliveObjectStates.get(i).stateName().equals(AliveObjectState.stateName())){
                alreadyInStates = true;
                aliveObjectStates.set(i, AliveObjectState);
                break;
            }
        }
        if(!alreadyInStates) {
            aliveObjectStates.add(AliveObjectState);
        }
    }

    public void removeState(AliveObjectState AliveObjectState){
        boolean alreadyInStates = false;
        for (AliveObjectState locCopyAliveObjectState : aliveObjectStates) {
            if (locCopyAliveObjectState.stateName().equals(AliveObjectState.stateName())) {
                alreadyInStates = true;
                break;
            }
        }
        if(alreadyInStates) {
            aliveObjectStates.remove(AliveObjectState);
        }
    }

    public boolean isHaveState(AliveObjectState AliveObjectState){
        for(AliveObjectState AliveObjectStateIterable : aliveObjectStates){
            if(AliveObjectStateIterable.stateName().equals(AliveObjectState.stateName())){
                return true;
            }
        }
        return false;
    }

    public void sleep() throws LogicalContradiction{
        AliveObjectState sleeping = new AliveObjectState("спит");
        if (isHaveState(sleeping)) {
            this.removeState(sleeping);
            System.out.println(this + " больше не " + sleeping.stateName());
        }
        else if (World.getInstance().isHaveState(new WorldState(
                "время", Daytime.NIGHT.toString())) ||
                 World.getInstance().isHaveState(new WorldState("время", Daytime.EVENING.toString()))){
            this.addState(sleeping);
            System.out.println(this + " " + sleeping.stateName());
        }
        else {
            throw new LogicalContradiction("Невозможно уснуть днём");
        }
    }

    public void walk(Location locations) throws WrongAmountException {
        if (getLocation().equals(locations)){
            System.out.println(this + " ходит по " + locations);
        }
        else{
            System.out.println(this + " идёт из " + getLocation() + " в " + locations);
            setLocation(locations);
        }
    }

    public void walk(PhysicalObject aim) throws WrongAmountException {
        System.out.println(this + " идёт к " + aim + (this.getLocation().equals(aim.getLocation()) ?  "": " в " + aim.getLocation()));
        setLocation(aim.getLocation());
    }



    @Override
    public void beEnchanted(){
        addState(new AliveObjectState("зачарован"));
    }

    @Override
    public void beSuspected(){
        addState(new AliveObjectState("подозрительный"));
    }

    @Override
    public int hashCode() {
        return super.hashCode() + aliveObjectStates.hashCode(); // Генерация хэш-кода
    }
}
