package myExceptions;

public class WrongAmountException extends Exception {
    public WrongAmountException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return  "WrongAmountException: "+ super.getMessage();
    }
}
