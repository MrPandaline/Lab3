package myInterfaces;

import myAbstractions.PhysicalObject;
import java.util.ArrayList;

@FunctionalInterface
public interface PhysicalObjectArrayListFunc {
    void doWithList(ArrayList<PhysicalObject> arrayList);

    static void addToList(ArrayList<PhysicalObject> arrayList, PhysicalObject toAdd){
        boolean alreadyInObjectParts = false;
        for (int i = 0; i< arrayList.size(); i++ ) {
            if (arrayList.get(i).getName().equals(toAdd.getName())){
                alreadyInObjectParts = true;
                arrayList.add(i, toAdd);
            }
        }
        if(!alreadyInObjectParts) {
            arrayList.add(toAdd);
        }
    }
}
