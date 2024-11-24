package myObjects;

import myEnums.BodyPartEnum;

public class BodyPart extends MyObject{

    BodyPartEnum bodyPartType;

    public BodyPart(BodyPartEnum partType) {
        this(partType, 1);
        bodyPartType = partType;
    }

    public BodyPart(BodyPartEnum partType, int amount){
        this(partType, amount ,"");
    }

    public BodyPart(BodyPartEnum partType, int amount, String dcrptn){
        super(partType.toString(), amount, dcrptn);
    }
}
