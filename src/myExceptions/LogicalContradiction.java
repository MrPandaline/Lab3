package myExceptions;

public class LogicalContradiction extends RuntimeException {
    public LogicalContradiction(String message) {
        super(message);
    }
}
