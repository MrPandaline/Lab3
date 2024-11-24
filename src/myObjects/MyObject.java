package myObjects;

import myEnums.Amounts;
import myEnums.Locations;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class MyObject {
    private final String name;
    protected final String description;
    private ArrayList<State> states;
    private Locations location;
    private Amounts amounts;

    {
        states = new ArrayList<>();
        location = Locations.SOMEWHERE;
    }
    public MyObject(String nm) {
        this(nm, 1);
    }

    public MyObject(String nm, int amount){
        this(nm, amount, "");
    }

    public MyObject(String nm, int amount, String dcrptn){
        this.amounts = Amounts.getAmountFromInt(amount);
        description = dcrptn;
        name = nm;
    }

    public String getName(){ return name;}

    public String getDescription(){ return description;}

    public ArrayList<State> getStates(){return states;}

    public Locations getLocation(){ return location;}

    public Amounts getAmount(){ return amounts;}

    public void addState(State state){
        State[] locCopyStates = states.toArray(new State[0]);
        boolean alreadyInStates = false;
        for (int i = 0; i< locCopyStates.length; i++ ) {
            if (locCopyStates[i].stateName().equals(state.stateName())){
                alreadyInStates = true;
                locCopyStates[i] = state;
                break;
            }
        }
        if(alreadyInStates) {
            states = new ArrayList<>(Arrays.asList(locCopyStates));
        }
        else{
            states.add(state);
        }
    }

    public void setLocation(Locations loca) {this.location = loca;}

    public void removeState(State state){
        State[] locCopyStates = states.toArray(new State[0]);
        boolean alreadyInStates = false;
        for (State locCopyState : locCopyStates) {
            if (locCopyState.stateName().equals(state.stateName())) {
                alreadyInStates = true;
                break;
            }
        }
        if(alreadyInStates) {
            states.remove(state);
        }
    }

    public boolean isHaveState(State state){
        for(State stateIterable: states){
            if(stateIterable.stateName().equals(state.stateName())){
                return true;
            }
        }
        return false;
    }
    @Override
    public String toString(){return (amounts.equals(Amounts.ONE) ? "": amounts + " " ) + name + (description.isEmpty() ? "": ": " + description);}

    @Override
    public int hashCode() {
        return Objects.hash(name, states, location); // Генерация хэш-кода
    }

    @Override
    public boolean equals(Object obj){
        if (obj instanceof MyObject) {
            if ((((MyObject) obj).getName()).equals(this.getName())) {
                return true;
            }
            return false;
        }
        else {
            if (obj == this) {
                return true;
            }
            return true;
        }
    }

}
