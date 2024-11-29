package backend.academy.fractalflame.exception;

public class IllegalTransformationException extends RuntimeException {
    private static final String MESSAGE_FORMAT = "Неправильное заданое значение цвета: %s";

    public IllegalTransformationException(String title) {
        super(MESSAGE_FORMAT.formatted(title));
    }
}
