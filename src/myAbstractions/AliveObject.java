package myAbstractions;

import myEnums.Daytime;
import myEnums.Locations;
import myExceptions.LogicalContradiction;
import myExceptions.WrongAmountException;
import myInterfaces.IEnchantableObject;
import myInterfaces.ISuspectableObject;
import myObjects.World;
import states.AliveObjectState;
import states.WorldState;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class AliveObject extends MyCompositeObject implements IEnchantableObject, ISuspectableObject {
    public AliveObject(String nm, int amount, String description) throws WrongAmountException {
        super(nm, amount, description);
    }
    public AliveObject(String nm, int amount){
        super(nm, amount);
    }
    public AliveObject(String nm){
        super(nm);
    }
    private ArrayList<AliveObjectState> aliveObjectStates;
    {
        aliveObjectStates = new ArrayList<>();
    }
    public ArrayList<AliveObjectState> getStates(){return aliveObjectStates;}

    public void addState(AliveObjectState AliveObjectState){
        AliveObjectState[] locCopyaliveObjectStates = aliveObjectStates.toArray(new AliveObjectState[0]);
        boolean alreadyInStates = false;
        for (int i = 0; i< locCopyaliveObjectStates.length; i++ ) {
            if (locCopyaliveObjectStates[i].stateName().equals(AliveObjectState.stateName())){
                alreadyInStates = true;
                locCopyaliveObjectStates[i] = AliveObjectState;
                break;
            }
        }
        if(alreadyInStates) {
            aliveObjectStates = new ArrayList<>(Arrays.asList(locCopyaliveObjectStates));
        }
        else{
            aliveObjectStates.add(AliveObjectState);
        }
    }

    public void removeState(AliveObjectState AliveObjectState){
        AliveObjectState[] locCopyaliveObjectStates = aliveObjectStates.toArray(new AliveObjectState[0]);
        boolean alreadyInStates = false;
        for (AliveObjectState locCopyAliveObjectState : locCopyaliveObjectStates) {
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
        else if (World.getInstance().isHaveState(new WorldState("время", Daytime.NIGHT.toString())) ||
                 World.getInstance().isHaveState(new WorldState("время", Daytime.EVENING.toString()))){
            this.addState(sleeping);
            System.out.println(this + " " + sleeping.stateName());
        }
        else {
            throw new LogicalContradiction("невозможно уснуть днём");
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

    public void walk(PhysicalObject aim) {
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
