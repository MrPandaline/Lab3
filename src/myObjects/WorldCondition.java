package myObjects;

import states.InanimateObjectState;
import states.WorldState;

import java.util.ArrayList;
import java.util.Arrays;

public final class WorldCondition {
    private ArrayList<WorldState> worldStates;
    private static WorldCondition instance;

    {
        worldStates = new ArrayList<>();
    }

    private WorldCondition(WorldState... worldStates){
        for (WorldState worldState : worldStates){
            this.worldStates.add(worldState);
            System.out.println("Было " + worldState.toString());
        }
    }

    public ArrayList<WorldState> getWorldStates(){ return worldStates;}

    public void addWorldState(WorldState worldInanimateObjectState){
        WorldState[] locWorldStates = worldStates.toArray(new WorldState[0]);
        boolean alreadyInStates = false;
        for (int i = 0; i< locWorldStates.length; i++ ) {
            if (locWorldStates[i].toString().equals(worldInanimateObjectState.toString())){
                alreadyInStates = true;
                locWorldStates[i] = worldInanimateObjectState;
            }
        }
        if(alreadyInStates) {
            worldStates = new ArrayList<>(Arrays.asList(locWorldStates));
        }
        else{
            this.worldStates.add(worldInanimateObjectState);
        }
        System.out.println("Стало " + worldInanimateObjectState.toString());
    }

    public boolean isHaveState(WorldState worldState){
        for(WorldState worldStateIterable : worldStates){
            if(worldStateIterable.stateName().equals(worldState.stateName())){
                return true;
            }
        }
        return false;
    }

    public static WorldCondition getInstance(WorldState... worldStates){
        if (instance == null){
            instance = new WorldCondition(worldStates);
        }
        return instance;
    }
}
