package backend.academy.fractalflame.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.experimental.UtilityClass;

@UtilityClass
public class FileNameGenerator {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");

    public static String dataTimeName() {
        return LocalDateTime.now().format(FORMATTER);
    }
}
