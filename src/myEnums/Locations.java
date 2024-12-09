package myEnums;

public enum Locations {
    SOMEWHERE("где-то"),
    CONFESSIONAL("исповедальня"), //Исповедальня
    SLEEPING_ROOM("спальня"),
    SECRET_ROOM("потаённая комната");

    private final String locationTitle;

    Locations(String title) {
        locationTitle = title;
    }

    @Override
    public String toString(){ return locationTitle;}
}
