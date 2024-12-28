package backend.academy.fractalflame.exception;

public class EmptyVariationListException extends RuntimeException {
    private static final String MESSAGE = "Вариативные функции не указаны";

    public EmptyVariationListException() {
        super(MESSAGE);
    }
}
