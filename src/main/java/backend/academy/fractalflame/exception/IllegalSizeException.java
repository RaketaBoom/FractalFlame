package backend.academy.fractalflame.exception;

public class IllegalSizeException extends RuntimeException {
    private static final String MESSAGE_FORMAT = "Недопустимое значения размеров изображения: height=%d, width=%d";

    public IllegalSizeException(int height, int width) {
        super(MESSAGE_FORMAT.formatted(height, width));
    }
}
