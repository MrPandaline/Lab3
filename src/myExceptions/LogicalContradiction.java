package myExceptions;

public class LogicalContradiction extends RuntimeException {
    public LogicalContradiction(String message) {super(message);}

    @Override
    public String getMessage() {
        return  "LogicalContradiction: "+ super.getMessage();
    }
}
