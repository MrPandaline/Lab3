package myObjects;

import myEnums.BodyPartEnum;
import myInterfaces.IThinkingObject;

import java.util.ArrayList;

public class ImaginableObject extends MyCompositeObject implements IThinkingObject {
    public ImaginableObject(String nm, int amount, String dcrpt){
        super(nm, amount, dcrpt);
    }
    public ImaginableObject(String nm, int amount){
        super(nm, amount);
    }
    public ImaginableObject(String nm){
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

    @Override
    public void ensure(String fact) {
        System.out.println(this + " будто убеждается, что " + fact);
    }
    @Override
    public String suspect(Person aim) {
        String message = this + " подозревает " + aim;
        System.out.println(this + " подозревает " + aim);
        return message;
    }
    @Override
    public void rethink(String fact){
        System.out.println(this + " будто обдумывает " + fact);
    }
    @Override
    public void simulate(State fact){
        System.out.println(this + " будто притворяется, что " + fact);
    }

    public void iRunFrom(MyObject object){
        System.out.println(this + " будто убегает от " + object);
    }

    public void iFallFrom(MyObject object){
        System.out.println(this + " будто сыпется с " + object);
    }

    public void iReown(MyObject object, MyCompositeObject prevOwner){
        if (prevOwner.isHavePart(object)) {
            System.out.println(this + " будто завладевает " + object + " которое принадлежит " + prevOwner);
        }
        // надо бросать исключение
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
