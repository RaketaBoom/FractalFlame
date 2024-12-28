package backend.academy.fractalflame.exception;

public class JsonLoadException extends RuntimeException {
    private static final String MESSAGE_FORMAT = "Невозможно загрузить конфигурацию с файла: %s";

    public JsonLoadException(String errorMessage) {
        super(MESSAGE_FORMAT.formatted(errorMessage));
    }
}
