package backend.academy.fractalflame.exception;

public class EmptyFormatFieldException extends RuntimeException {
    private static final String MESSAGE = "Пустое поле формата";

    public EmptyFormatFieldException() {
        super(MESSAGE);
    }
}
