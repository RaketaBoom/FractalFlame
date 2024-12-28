package backend.academy.fractalflame.loader;

import backend.academy.fractalflame.dto.AffineFunctionDto;
import backend.academy.fractalflame.dto.ConfigDto;
import backend.academy.fractalflame.dto.VariationDto;
import backend.academy.fractalflame.exception.JsonLoadException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.file.Path;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class JsonConfigLoaderTest {

    static JsonConfigLoader jsonConfigLoader;

    @BeforeAll
    static void setUp() {
        jsonConfigLoader = new JsonConfigLoader(new ObjectMapper());
    }

    @Test
    void testLoadConfig_configJsonFile_returnsConfigDto() {
        // Arrange
        Path jsonPath = Path.of("src/test/resources/config1.json");
        ConfigDto expectedConfigDto = getExpectedConfigDto1();

        // Act
        ConfigDto actualConfigDto = jsonConfigLoader.loadConfig(jsonPath);

        // Assert
        assertThat(actualConfigDto)
            .isEqualTo(expectedConfigDto);
    }

    @Test
    void testLoadConfig_invalidConfigJsonFile_throwsJsonLoadException() {
        // Arrange
        Path jsonPath = Path.of("src/test/resources/invalidConfig.json");

        // Act & Assert
        assertThatThrownBy(() -> jsonConfigLoader.loadConfig(jsonPath))
            .isInstanceOf(JsonLoadException.class);
    }

    @Test
    void testLoadConfig_invalidPath_throwsJsonLoadException() {
        // Arrange
        Path jsonPath = Path.of("src/test/resources/invalidPath.json");

        // Act & Assert
        assertThatThrownBy(() -> jsonConfigLoader.loadConfig(jsonPath))
            .isInstanceOf(JsonLoadException.class);
    }

    private ConfigDto getExpectedConfigDto1() {
        return new ConfigDto(
            1,
            1080,
            1920,
            1000,
            2,
            List.of(new VariationDto("Heart", 0.8, "#ebf2fa"),
                new VariationDto("Hyperbolic", 0.2, "#ebf2fa")),
            List.of(new AffineFunctionDto(0.5, 0.5, 0.5, 0.5, 0.5, 0.5,3,"#ebf2fa"),
                new AffineFunctionDto(0.5, 0.5, 0.5, 0.5, 0.5, 0.5, 2, "#ebf2fa")),
            "png"
        );
    }
}
