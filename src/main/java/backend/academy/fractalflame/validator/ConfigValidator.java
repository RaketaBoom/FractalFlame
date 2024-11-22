package backend.academy.fractalflame.validator;

import backend.academy.fractalflame.dto.ConfigDto;
import backend.academy.fractalflame.exception.IllegalIterationsException;
import backend.academy.fractalflame.exception.IllegalSizeException;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ConfigValidator {
    public static void validate(ConfigDto configDto) {
        validateSize(configDto.height(), configDto.width());
        validateIterations(configDto.iterations());
    }

    private static void validateSize(int height, int width) {
        if (height <= 0 || width <= 0) {
            throw new IllegalSizeException(height, width);
        }
    }

    private static void validateIterations(int iterations) {
        if (iterations <= 0) {
            throw new IllegalIterationsException(iterations);
        }
    }
}
