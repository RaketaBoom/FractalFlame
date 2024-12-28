package backend.academy.fractalflame.exception;

public class UnknownImageFormatException extends RuntimeException {
    private static final String MESSAGE = "Неизвестный формат изображения";

    public UnknownImageFormatException() {
        super(MESSAGE);
    }
}
