package backend.academy.fractalflame.postprocessing.impl;

import backend.academy.fractalflame.exception.IllegalMaxHitCountException;
import backend.academy.fractalflame.model.FractalImage;
import backend.academy.fractalflame.model.pixel.Pixel;
import backend.academy.fractalflame.postprocessing.ImageProcessor;
import java.awt.Color;

public record LogDensity(double gamma) implements ImageProcessor {

    @Override
    public void process(FractalImage image) {
        int maxHitCount = findMaxHitCount(image);
        if(maxHitCount == 0){
            throw new IllegalMaxHitCountException();
        }

        for (int y = 0; y < image.height(); y++) {
            for (int x = 0; x < image.width(); x++) {
                Pixel pixel = image.pixel(x, y);
                if (pixel.hitCount() > 0) {
                    double normalizedDensity = 1.0 * pixel.hitCount() / maxHitCount;
                    double brightness = Math.log(1 + normalizedDensity * (Math.E - 1)); // Логарифмическая шкала
                    brightness = Math.pow(brightness, 1.0 / gamma); // Гамма-коррекция
                    pixel.color(scaleBrightness(pixel.color(), brightness));
                }
            }
        }
    }

    private int findMaxHitCount(FractalImage image) {
        int maxHitCount = 0;
        for (int y = 0; y < image.height(); y++) {
            for (int x = 0; x < image.width(); x++) {
                maxHitCount = Math.max(maxHitCount, image.pixel(x, y).hitCount());
            }
        }
        return maxHitCount;
    }

    private Color scaleBrightness(Color color, double brightness) {
        int red = (int) (color.getRed() * brightness);
        int green = (int) (color.getGreen() * brightness);
        int blue = (int) (color.getBlue() * brightness);

        // Ограничиваем значения цвета в диапазоне [0, 255]
        red = Math.min(255, Math.max(0, red));
        green = Math.min(255, Math.max(0, green));
        blue = Math.min(255, Math.max(0, blue));

        return new Color(red, green, blue);
    }

}
