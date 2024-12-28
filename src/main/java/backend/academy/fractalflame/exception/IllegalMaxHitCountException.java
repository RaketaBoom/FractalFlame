package backend.academy.fractalflame.exception;

public class IllegalMaxHitCountException extends RuntimeException {
    private static final String MESSAGE = "Max hit count is 0";

    public IllegalMaxHitCountException() {
        super(MESSAGE);
    }
}
