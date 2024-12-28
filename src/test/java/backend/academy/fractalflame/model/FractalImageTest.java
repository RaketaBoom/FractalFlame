package backend.academy.fractalflame.model;

import backend.academy.fractalflame.model.pixel.Pixel;
import backend.academy.fractalflame.model.pixel.UnsafePixel;
import java.awt.Color;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FractalImageTest {

    @Test
    void pixel_validPixelPoint_returnsCorrectPixel() {
        // Arrange
        Pixel[][] data = new Pixel[2][2];
        Pixel expectedPixel = new UnsafePixel(Color.RED, 1);
        data[1][1] = expectedPixel;
        FractalImage fractalImage = new FractalImage(2, 2, data);
        PixelPoint pixelPoint = new PixelPoint(1, 1);

        // Act
        Pixel result = fractalImage.pixel(pixelPoint);

        // Assert
        assertEquals(expectedPixel, result);
    }

    @Test
    void pixel_validCoordinates_returnsCorrectPixel() {
        // Arrange
        Pixel[][] data = new Pixel[2][2];
        Pixel expectedPixel = new UnsafePixel(Color.RED, 1);
        data[1][1] = expectedPixel;
        FractalImage fractalImage = new FractalImage(2, 2, data);

        // Act
        Pixel result = fractalImage.pixel(1, 1);

        // Assert
        assertEquals(expectedPixel, result);
    }

    @Test
    void getColorsOfImage_returnsCorrectColors() {
        // Arrange
        Pixel[][] data = pixels();
        FractalImage fractalImage = new FractalImage(2, 2, data);
        Color[][] expectedColors = {
            {Color.RED, Color.RED},
            {Color.BLUE, Color.BLUE}
        };

        // Act
        Color[][] colors = fractalImage.getColorsOfImage();

        // Assert
        assertEquals(expectedColors[0][0], colors[0][0]);
        assertEquals(expectedColors[1][1], colors[1][1]);
        assertEquals(expectedColors[0][1], colors[0][1]);
        assertEquals(expectedColors[1][0], colors[1][0]);
    }

    @Test
    void contains_validPixelPoint_returnsTrue() {
        // Arrange
        FractalImage fractalImage = new FractalImage(2, 2, new Pixel[2][2]);
        PixelPoint pixelPoint = new PixelPoint(1, 1);

        // Act
        boolean result = fractalImage.contains(pixelPoint);

        // Assert
        assertTrue(result);
    }

    @Test
    void contains_invalidPixelPoint_returnsFalse() {
        // Arrange
        FractalImage fractalImage = new FractalImage(2, 2, new Pixel[2][2]);
        PixelPoint pixelPoint = new PixelPoint(2, 2);

        // Act
        boolean result = fractalImage.contains(pixelPoint);

        // Assert
        assertFalse(result);
    }

    @Test
    void contains_validCoordinates_returnsTrue() {
        // Arrange
        FractalImage fractalImage = new FractalImage(2, 2, new Pixel[2][2]);

        // Act
        boolean result = fractalImage.contains(1, 1);

        // Assert
        assertTrue(result);
    }

    @Test
    void contains_invalidCoordinates_returnsFalse() {
        // Arrange
        FractalImage fractalImage = new FractalImage(2, 2, new Pixel[2][2]);

        // Act
        boolean result = fractalImage.contains(2, 2);

        // Assert
        assertFalse(result);
    }

    private Pixel[][] pixels() {
        Pixel[][] data = new Pixel[2][2];
        data[0][0] = new UnsafePixel(Color.RED, 1);
        data[1][1] = new UnsafePixel(Color.BLUE, 1);
        data[0][1] = new UnsafePixel(Color.RED, 1);
        data[1][0] = new UnsafePixel(Color.BLUE, 1);
        return data;
    }
}
