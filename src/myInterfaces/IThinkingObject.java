package myInterfaces;

import states.InanimateObjectState;

public interface IThinkingObject {


    default void ensure(String fact) {
        System.out.println(this + " убеждается, что " + fact);
    }

    default void suspect(ISuspectableObject aim) {
        String message = this + " подозревает " + aim;
        System.out.println(this + " подозревает " + aim);
        aim.beSuspected();
    }

    default void rethink(String fact){
        System.out.println(this + " перетолковывает " + fact);
    }

    default void simulate(InanimateObjectState fact){
        System.out.println(this + " претворяется, что находится в состоянии " + fact);
    }

}
