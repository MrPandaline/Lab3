package myEnums;

public enum BodyPartEnum {
    TOUNGE("язык"),
    CHEEKS("щёки"),
    BRAIN("мозг"),
    HEART("сердце"),
    LEGS("ноги"),
    HEAD("голова");


    private final String bodyPartTitle;

    BodyPartEnum(String title) {
        bodyPartTitle = title;
    }

    @Override
    public String toString(){ return bodyPartTitle;}
}
