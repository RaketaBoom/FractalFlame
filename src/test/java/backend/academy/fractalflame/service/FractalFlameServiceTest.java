package backend.academy.fractalflame.service;

import backend.academy.fractalflame.core.FractalImageGenerator;
import backend.academy.fractalflame.dto.FractalImageRequest;
import backend.academy.fractalflame.model.FractalImage;
import backend.academy.fractalflame.model.Rect;
import backend.academy.fractalflame.model.Variation;
import backend.academy.fractalflame.model.pixel.Pixel;
import backend.academy.fractalflame.model.pixel.UnsafePixel;
import backend.academy.fractalflame.postprocessing.ImageProcessor;
import backend.academy.fractalflame.transformation.impl.Heart;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FractalFlameServiceTest {
    @Mock
    FractalImageGenerator mockGenerator;
    @Mock
    ImageProcessor processor;

    @InjectMocks
    FractalFlameService service;

    @Test
    void createFractalImage_validRequest_returnsFractalImage() {
        // Arrange
        FractalImageRequest request = request();
        FractalImage expectedImage = expectedImage();
        when(mockGenerator.generate(anyInt(), anyInt(), anyInt(), anyList(), any(Rect.class)))
            .thenReturn(expectedImage);

        // Act
        FractalImage actualImage = service.createFractalImage(request);

        // Assert
        assertEquals(expectedImage, actualImage);
    }

    @Test
    void postProcessing_validImage_returnsProcessedImage() {
        // Arrange
        FractalImage image = argumentImage();
        doAnswer(
            invocation -> {
                FractalImage imageArg = invocation.getArgument(0);
                imageArg.pixel(0, 0).color(Color.WHITE);
                return null;
            }
        ).when(processor).process(any(FractalImage.class));

        // Act
        FractalImage actualImage = service.postProcessing(image);

        // Assert
        assertEquals(image, actualImage);
    }

    private FractalImage argumentImage() {
        Pixel[][] pixels = new UnsafePixel[800][600];
        for (int i = 0; i < 800; i++) {
            for (int j = 0; j < 600; j++) {
                pixels[i][j] = new UnsafePixel(Color.BLACK, 0);
            }
        }
        return new FractalImage(800, 600, pixels);
    }

    private static FractalImageRequest request() {
        List<Variation> variations = new ArrayList<>();
        variations.add(new Variation(new Heart(), 2, Color.decode("#FFFFFF")));
        return new FractalImageRequest(800, 600, 1000, 2, variations);
    }

    private FractalImage expectedImage() {
        Pixel[][] pixels = new Pixel[800][600];
        return new FractalImage(800, 600, pixels);
    }
}
