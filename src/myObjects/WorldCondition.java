package myObjects;

import java.util.ArrayList;
import java.util.Arrays;

public final class WorldCondition {
    private ArrayList<State> worldStates;
    private static WorldCondition instance;

    {
        worldStates = new ArrayList<>();
    }

    private WorldCondition(State... states){
        for (State worldState : states){
            worldStates.add(worldState);
            System.out.println("Было " + worldState.toString());
        }
    }

    public ArrayList<State> getWorldStates(){ return worldStates;}

    public void addWorldState(State worldState){
        State[] locWorldStates = worldStates.toArray(new State[0]);
        boolean alreadyInStates = false;
        for (int i = 0; i< locWorldStates.length; i++ ) {
            if (locWorldStates[i].toString().equals(worldState.toString())){
                alreadyInStates = true;
                locWorldStates[i] = worldState;
            }
        }
        if(alreadyInStates) {
            worldStates = new ArrayList<>(Arrays.asList(locWorldStates));
        }
        else{
            worldStates.add(worldState);
        }
        System.out.println("Стало " + worldState.toString());
    }

    public static WorldCondition getInstance(State... states){
        if (instance == null){
            instance = new WorldCondition(states);
        }
        return instance;
    }
}
