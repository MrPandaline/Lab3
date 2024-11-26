package myObjects;

import myAbstractions.PhysicalObject;

public class BodyPart extends PhysicalObject {

    String bodyPartType;

    public BodyPart(String partType) {
        this(partType, 1);
        bodyPartType = partType;
    }

    public BodyPart(String partType, int amount){
        this(partType, amount ,"");
    }

    public BodyPart(String partType, int amount, String description){
        super(partType, amount, description);
    }
}
