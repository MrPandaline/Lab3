package myAbstractions;

import states.AliveObjectState;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class AliveObject extends MyCompositeObject{
    public AliveObject(String nm, int amount, String dcrptn){
        super(nm, amount, dcrptn);
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
    @Override
    public int hashCode() {
        return super.hashCode() + aliveObjectStates.hashCode(); // Генерация хэш-кода
    }
}
