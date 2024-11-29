package backend.academy.fractalflame.validator;

import backend.academy.fractalflame.constant.Constants;
import backend.academy.fractalflame.dto.ConfigDto;
import backend.academy.fractalflame.dto.VariationDto;
import backend.academy.fractalflame.exception.EmptyFormatFieldException;
import backend.academy.fractalflame.exception.EmptyVariationListException;
import backend.academy.fractalflame.exception.IllegalIterationsException;
import backend.academy.fractalflame.exception.IllegalSizeException;
import backend.academy.fractalflame.exception.IllegalSymmetryException;
import java.util.List;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ConfigValidator {
    public static void validate(ConfigDto configDto) {
        validateSize(configDto.height(), configDto.width());
        validateIterations(configDto.iterations());
        validateSymmetry(configDto.symmetry());
        validateVariations(configDto.variations());
        validateFormat(configDto.format());
    }

    private static void validateSize(int height, int width) {
        if (height <= 0 || width <= 0) {
            throw new IllegalSizeException(height, width);
        }
    }

    private static void validateIterations(int iterations) {
        if (iterations <= Constants.WARMUP_ITERATIONS) {
            throw new IllegalIterationsException(iterations);
        }
    }

    private static void validateSymmetry(int symmetry) {
        if (symmetry <= 0) {
            throw new IllegalSymmetryException(symmetry);
        }
    }

    private static void validateVariations(List<VariationDto> variationDtos) {
        if (variationDtos == null || variationDtos.isEmpty()) {
            throw new EmptyVariationListException();
        }
    }

    private static void validateFormat(String name) {
        if (name == null || name.isBlank()) {
            throw new EmptyFormatFieldException();
        }
    }
}
