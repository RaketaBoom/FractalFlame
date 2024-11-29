package backend.academy.fractalflame.model;

import java.awt.Color;
import java.util.Arrays;
import lombok.Getter;

@Getter
public class FractalImage {
    private final int width;
    private final int height;
    private final Pixel[][] data;

    public FractalImage(int width, int height) {
        this.width = width;
        this.height = height;
        data = new Pixel[height][width];

        Arrays.setAll(data, i -> {
            Arrays.setAll(data[i], j -> new Pixel());
            return data[i];
        });
    }

    public Pixel pixel(PixelPoint pixelPoint) {
        return data[pixelPoint.y()][pixelPoint.x()];
    }

    public Pixel pixel(int x, int y) {
        return data[y][x];
    }

    public Color[][] getColorsOfImage() {
        Color[][] colors = new Color[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                colors[i][j] = data[i][j].color();
            }
        }

        return colors;
    }

    public boolean contains(PixelPoint pixelPoint) {
        return pixelPoint.x() > 0 && pixelPoint.x() < width
               && pixelPoint.y() > 0 && pixelPoint.y() < height;
    }
}
