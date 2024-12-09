package myObjects;

import myAbstractions.PhysicalObject;
import myExceptions.WrongAmountException;

public class BodyPart extends PhysicalObject {

    String bodyPartType;

    public BodyPart(String partType) throws WrongAmountException {
        this(partType, 1);
        bodyPartType = partType;
    }

    public BodyPart(String partType, int amount) throws WrongAmountException {
        this(partType, amount ,"");
    }

    public BodyPart(String partType, int amount, String description) throws WrongAmountException {
        super(partType, amount, description);
    }
}
