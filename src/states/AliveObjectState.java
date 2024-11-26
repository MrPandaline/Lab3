package states;

public record AliveObjectState(String stateName, String stateDescription) {
    public AliveObjectState(String stateName, String stateDescription) {
        this.stateName = stateName.toLowerCase();
        this.stateDescription = stateDescription.toLowerCase();
    }

    public AliveObjectState(String stateName) {
        this(stateName, "");
    }

    @Override
    public String toString(){
        return stateName + (stateDescription.isEmpty() ? "" : ": " + stateDescription);
    }

}
