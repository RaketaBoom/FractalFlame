package backend.academy.fractalflame.exception;

public class IllegalSymmetryException extends RuntimeException {
    private static final String MESSAGE_FORMAT = "Недопустимое значение параметра симметрии: %d";

    public IllegalSymmetryException(int symmetry) {
        super(MESSAGE_FORMAT.formatted(symmetry));
    }
}
