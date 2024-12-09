package backend.academy.fractalflame.utils;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import static org.junit.jupiter.api.Assertions.*;

class FileNameGeneratorTest {

    @Test
    void dataTimeName_validFormat_correctFormat() {
        // Arrange
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");

        // Act
        String result = FileNameGenerator.dataTimeName();

        // Assert
        assertDoesNotThrow(() -> LocalDateTime.parse(result, formatter));
    }

    @Test
    void dataTimeName_notNull_notNull() {
        // Act
        String result = FileNameGenerator.dataTimeName();

        // Assert
        assertNotNull(result);
    }
}
