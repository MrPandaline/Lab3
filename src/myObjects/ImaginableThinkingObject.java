package myObjects;

import myAbstractions.InanimateObject;
import myAbstractions.MyCompositeObject;
import myAbstractions.MyObject;
import myEnums.BodyPartEnum;
import myInterfaces.IThinkingObject;

import java.util.ArrayList;

public class ImaginableThinkingObject extends InanimateObject{
    public ImaginableThinkingObject(String nm, int amount, String dcrpt){
        super(nm, amount, dcrpt);
    }
    public ImaginableThinkingObject(String nm, int amount){
        super(nm, amount);
    }
    public ImaginableThinkingObject(String nm){
        super(nm);
    }

    @Override
    public String getDescription(){
        if(!getObjectParts().isEmpty()){
            ArrayList<String> message = new ArrayList<>();
            for (MyObject part : getObjectParts()){
                message.add(part.toString());
            }
            return "состоит из " + String.join(", ", message) +
                    (description.isEmpty() ? "": " " + description);
        }
        else {
            return description;
        }
    }

    public void iSay(String phrase){
        System.out.println(this + " будто хотел сказать " + phrase);
    }

    public void ishake(BodyPartEnum bodyPart){
        if (isHavePart(new BodyPart(bodyPart))){
            System.out.println(this + " будто трясёт " + bodyPart.toString());
        }
        // если нет, то бросить логическое исключение
    }
}
