package myObjects;

import myAbstractions.MyCompositeObject;
import myAbstractions.MyObject;
import myExceptions.WrongAmountException;

import java.util.ArrayList;

public class Image extends MyCompositeObject {
    public Image(String nm, int amount, String description) throws WrongAmountException {
        super(nm, amount, description);
    }
    public Image(String nm, int amount){
        super(nm, amount);
    }
    public Image(String nm){
        super(nm);
    }

    @Override
    public String getDescription(){
        if(!getObjectParts().isEmpty()){
            ArrayList<String> message = new ArrayList<>();
            for (MyObject part : getObjectParts()){
                message.add(part.toString());
            }
            return "на картине изображен " + String.join(", ", message) +
                    (description.isEmpty() ? "": " " + description);
        }
        else {
            return description;
        }
    }
}
