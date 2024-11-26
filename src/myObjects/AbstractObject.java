package myObjects;

import myAbstractions.MyCompositeObject;
import myAbstractions.MyObject;
import myAbstractions.PhysicalObject;

public class AbstractObject extends MyObject {
    public AbstractObject(String nm) {super(nm, "");}

    public AbstractObject(String nm, String dcrptn){
        super(nm, dcrptn);
    }

    public void iReown(PhysicalObject part, MyCompositeObject prevOwner){
        System.out.println(this + " будто завладевает " + part + " которая принадлежит " + prevOwner);
    }
    public void iFallFrom(PhysicalObject physicalObject){
        System.out.println(this + " будто сыпется с " + physicalObject);
    }

    public void iRunFrom(PhysicalObject aim){
        System.out.println(this + " будто убегает от " + aim);
    }
}
