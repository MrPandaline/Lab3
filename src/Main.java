import myAbstractions.MyObject;
import myExceptions.WrongAmountException;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args){
        try {
            Script script = new Script();
            script.playScript();
        }
        catch (WrongAmountException e){
            System.out.println("отрицательное число предметов схлопнуло вселенную в точку," +
                    " сценарий невозможно проиграть из-за произошедшего апокалипсиса");
        }
    }
}
