package myEnums;

public enum Daytime{
    MORNING("утро"),
    NOON("день"),
    EVENING("вечер"),
    NIGHT("ночь");

    private final String daytimeTitle;

    Daytime(String title) {
       daytimeTitle = title;
    }

    @Override
    public String toString(){ return daytimeTitle;}
}
