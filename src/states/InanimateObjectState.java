package states;

public record InanimateObjectState(String stateName, String stateDescription) {
    public InanimateObjectState(String stateName, String stateDescription) {
        this.stateName = stateName.toLowerCase();
        this.stateDescription = stateDescription.toLowerCase();
    }

    public InanimateObjectState(String stateName) {
        this(stateName, "");
    }

    @Override
    public String toString(){
        return stateName + (stateDescription.isEmpty() ? "" : ": " + stateDescription);
    }
}
