package myInterfaces;

import states.AliveObjectState;
import states.InanimateObjectState;

public interface IThinkingObject {
    default void ensure(String fact) {
        System.out.println(this + " убеждается, что " + fact);
    }

    default String suspect(IThinkingObject aim) {
        String message = this + " подозревает " + aim;
        System.out.println(this + " подозревает " + aim);
        aim.addState(new AliveObjectState("подозрительный"));
        return message;
    }

    default void rethink(String fact){
        System.out.println(this + " перетолковывает " + fact);
    }

    default void simulate(InanimateObjectState fact){
        System.out.println(this + " претворяется, что находится в состоянии " + fact);
    }

    void addState(AliveObjectState inanimateObjectState);
}
