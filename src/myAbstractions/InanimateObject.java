package myAbstractions;

import states.InanimateObjectState;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class InanimateObject extends MyCompositeObject{
    public InanimateObject(String nm, int amount, String dcrptn){
        super(nm, amount, dcrptn);
    }
    public InanimateObject(String nm, int amount){
        super(nm, amount);
    }
    public InanimateObject(String nm){
        super(nm);
    }

    private ArrayList<InanimateObjectState> inanimateObjectStates;
    {
        inanimateObjectStates = new ArrayList<>();
    }
    public ArrayList<InanimateObjectState> getStates(){return inanimateObjectStates;}

    public void addState(InanimateObjectState inanimateObjectState){
        InanimateObjectState[] locCopyInanimateObjectStates = inanimateObjectStates.toArray(new InanimateObjectState[0]);
        boolean alreadyInStates = false;
        for (int i = 0; i< locCopyInanimateObjectStates.length; i++ ) {
            if (locCopyInanimateObjectStates[i].stateName().equals(inanimateObjectState.stateName())){
                alreadyInStates = true;
                locCopyInanimateObjectStates[i] = inanimateObjectState;
                break;
            }
        }
        if(alreadyInStates) {
            inanimateObjectStates = new ArrayList<>(Arrays.asList(locCopyInanimateObjectStates));
        }
        else{
            inanimateObjectStates.add(inanimateObjectState);
        }
    }

    public void removeState(InanimateObjectState inanimateObjectState){
        InanimateObjectState[] locCopyInanimateObjectStates = inanimateObjectStates.toArray(new InanimateObjectState[0]);
        boolean alreadyInStates = false;
        for (InanimateObjectState locCopyInanimateObjectState : locCopyInanimateObjectStates) {
            if (locCopyInanimateObjectState.stateName().equals(inanimateObjectState.stateName())) {
                alreadyInStates = true;
                break;
            }
        }
        if(alreadyInStates) {
            inanimateObjectStates.remove(inanimateObjectState);
        }
    }

    public boolean isHaveState(InanimateObjectState inanimateObjectState){
        for(InanimateObjectState inanimateObjectStateIterable : inanimateObjectStates){
            if(inanimateObjectStateIterable.stateName().equals(inanimateObjectState.stateName())){
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + inanimateObjectStates.hashCode(); // Генерация хэш-кода
    }
}
