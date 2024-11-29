package backend.academy.fractalflame.exception;

public class InvalidColorValueException extends RuntimeException {
    private static final String MESSAGE_FORMAT = "Неправильное заданое значение цвета: %s";

    public InvalidColorValueException(String color) {
        super(MESSAGE_FORMAT.formatted(color));
    }
}
