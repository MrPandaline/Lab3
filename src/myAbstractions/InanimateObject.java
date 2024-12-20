package myAbstractions;

import myExceptions.WrongAmountException;
import states.InanimateObjectState;

import java.util.ArrayList;


public abstract class InanimateObject extends MyCompositeObject{
    public InanimateObject(String nm, int amount, String description) throws WrongAmountException {
        super(nm, amount, description);
    }
    public InanimateObject(String nm, int amount) throws WrongAmountException {
        super(nm, amount);
    }
    public InanimateObject(String nm) throws WrongAmountException {
        super(nm);
    }

    private final ArrayList<InanimateObjectState> inanimateObjectStates;
    {
        inanimateObjectStates = new ArrayList<>();
    }

    public void addState(InanimateObjectState inanimateObjectState){
        boolean alreadyInStates = false;
        for (int i = 0; i< inanimateObjectStates.size(); i++ ) {
            if (inanimateObjectStates.get(i).stateName().equals(inanimateObjectState.stateName())){
                alreadyInStates = true;
                inanimateObjectStates.set(i, inanimateObjectState);
                break;
            }
        }
        if(!alreadyInStates) {
            inanimateObjectStates.add(inanimateObjectState);
        }
    }

    public void removeState(InanimateObjectState inanimateObjectState){
        boolean alreadyInStates = false;
        for (InanimateObjectState locCopyInanimateObjectState : inanimateObjectStates) {
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
