package backend.academy.fractalflame.exception;

public class IllegalIterationsException extends RuntimeException {
    private static final String MESSAGE_FORMAT = "Недопустимое количество итераций: %d";

    public IllegalIterationsException(int iterations) {
        super(MESSAGE_FORMAT.formatted(iterations));
    }
}
