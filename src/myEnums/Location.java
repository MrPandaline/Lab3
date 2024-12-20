package myEnums;

public enum Location {
    SOMEWHERE("где-то"),
    CONFESSIONAL("исповедальня"), //Исповедальня
    SLEEPING_ROOM("спальня"),
    SECRET_ROOM("потаённая комната");

    private final String locationTitle;

    Location(String title) {
        locationTitle = title;
    }

    @Override
    public String toString(){ return locationTitle;}
}
