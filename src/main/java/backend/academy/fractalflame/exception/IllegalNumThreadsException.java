package backend.academy.fractalflame.exception;

public class IllegalNumThreadsException extends RuntimeException {
    private static final String MESSAGE_FORMAT = "Недопустимое количество потоков: threads=%d";
    public IllegalNumThreadsException(int threads) {
        super(MESSAGE_FORMAT.formatted(threads));
    }
}
