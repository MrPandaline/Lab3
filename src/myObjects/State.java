package myObjects;

public record State(String stateName, String stateDescription) {
    public State(String stateName, String stateDescription) {
        this.stateName = stateName.toLowerCase();
        this.stateDescription = stateDescription.toLowerCase();
    }

    public State(String stateName) {
        this(stateName, "");
    }

    @Override
    public String toString(){
        return stateName + (stateDescription.isEmpty() ? "" : ": " + stateDescription);
    }
}
