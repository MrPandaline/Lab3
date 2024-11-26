package states;

public record WorldState(String stateName, String stateDescription) {
    public WorldState(String stateName, String stateDescription) {
        this.stateName = stateName.toLowerCase();
        this.stateDescription = stateDescription.toLowerCase();
    }

    public WorldState(String stateName) {
        this(stateName, "");
    }

    @Override
    public String toString(){
        return stateName + (stateDescription.isEmpty() ? "" : ": " + stateDescription);
    }
}
