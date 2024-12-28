package backend.academy.fractalflame.exception;

public class IllegalTransformationException extends RuntimeException {
    private static final String MESSAGE_FORMAT = "Неправильное название вариационной функции: %s";

    public IllegalTransformationException(String title) {
        super(MESSAGE_FORMAT.formatted(title));
    }
}
