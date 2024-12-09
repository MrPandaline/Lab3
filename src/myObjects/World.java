package myObjects;

import states.WorldState;

import java.util.ArrayList;

public final class World {
    private final ArrayList<WorldState> worldStates;
    private static World instance;

    {
        worldStates = new ArrayList<>();
    }

    private World(WorldState... worldStates){
        for (WorldState worldState : worldStates){
            this.worldStates.add(worldState);
            System.out.println("Было " + worldState.toString());
        }
    }

    public void addWorldState(WorldState worldInanimateObjectState){
        boolean alreadyInStates = false;
        for (int i = 0; i< worldStates.size(); i++ ) {
            if (worldStates.get(i).toString().equals(worldInanimateObjectState.toString())){
                alreadyInStates = true;
                worldStates.set(i, worldInanimateObjectState);
            }
        }
        if(!alreadyInStates) {
            this.worldStates.add(worldInanimateObjectState);
        }
        System.out.println("Стало " + worldInanimateObjectState.toString());
    }

    public boolean isHaveState(WorldState worldState){
        for(WorldState worldStateIterable : worldStates){
            if(worldStateIterable.stateName().equals(worldState.stateName()) &&
                    worldStateIterable.stateDescription().equals(worldState.stateDescription())){
                return true;
            }
        }
        return false;
    }

    public static World getInstance(WorldState... worldStates){
        if (instance == null){
            instance = new World(worldStates);
        }
        return instance;
    }
}
