package backend.academy.fractalflame.validator;

import backend.academy.fractalflame.exception.InvalidColorValueException;
import lombok.experimental.UtilityClass;
import java.util.regex.Pattern;

@UtilityClass
public class VariationValidator {
    private static final Pattern HEX_COLOR_PATTERN = Pattern.compile("^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$");
    public static void validateColor(String color){
        if (!isValidHexColor(color))
            throw new InvalidColorValueException(color);
    }

    public static boolean isValidHexColor(String colorCode) {
        if (colorCode == null || colorCode.isEmpty()) {
            return false;
        }
        return HEX_COLOR_PATTERN.matcher(colorCode).matches();
    }
}
