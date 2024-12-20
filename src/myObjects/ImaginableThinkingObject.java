package myObjects;

import myAbstractions.InanimateObject;
import myAbstractions.MyObject;
import myExceptions.WrongAmountException;
import myInterfaces.IEnchantableObject;
import states.InanimateObjectState;

import java.util.ArrayList;

public class ImaginableThinkingObject extends InanimateObject implements IEnchantableObject {
    public ImaginableThinkingObject(String nm, int amount, String description) throws WrongAmountException {
        super(nm, amount, description);
    }
    public ImaginableThinkingObject(String nm, int amount) throws WrongAmountException {
        super(nm, amount);
    }
    public ImaginableThinkingObject(String nm) throws WrongAmountException {
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

    public void ishake(String bodyPart) throws WrongAmountException {
        if (isHavePart(new BodyPart(bodyPart))){
            System.out.println(this + " будто трясёт " + bodyPart);
        }
        // если нет, то бросить логическое исключение
    }

    @Override
    public void beEnchanted() {
        addState(new InanimateObjectState("зачарован"));
    }
}
