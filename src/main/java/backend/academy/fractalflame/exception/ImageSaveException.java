package backend.academy.fractalflame.exception;

public class ImageSaveException extends RuntimeException {
    private static final String MESSAGE = "Ошибка сохранения изображения";

    public ImageSaveException() {
        super(MESSAGE);
    }
}
