package backend.academy.fractalflame.core;

import backend.academy.fractalflame.constant.Constants;
import backend.academy.fractalflame.model.FractalImage;
import backend.academy.fractalflame.model.PixelPoint;
import backend.academy.fractalflame.model.Point;
import backend.academy.fractalflame.model.Rect;
import backend.academy.fractalflame.model.Variation;
import backend.academy.fractalflame.model.pixel.Pixel;
import java.awt.Color;
import java.util.List;
import java.util.Random;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FractalGeneratingProcessor {
    private static final int MAX_COLOR_VALUE = 0xFFFFFF;

    private final Random random;
    private final List<Variation> variations;
    private final Rect world;

    public void process(FractalImage image, int iterations) {
        Point currPoint = randomStartPoint(world);
        Color currColor = randomStartColor();
        double totalWeight = totalWeight(variations);

        for (int i = 0; i < iterations; i++) {
            Variation variation = randomWeightedVariation(variations, totalWeight);
            currPoint = variation.transformation().apply(currPoint);

            currColor = mixColors(currColor, variation.color());

            if (!isWarmupIterations(i)) {
                PixelPoint pixelPoint = translatePointToPixel(image, world, currPoint);

                if (image.contains(pixelPoint)) {
                    Pixel pixel = image.pixel(pixelPoint);
                    pixel.color(currColor);
                    pixel.incrementHitCount();
                }
            }
        }
    }

    private double totalWeight(List<Variation> variations) {
        return variations.stream()
            .mapToDouble(Variation::weight)
            .sum();
    }

    private Color mixColors(Color firstColor, Color secondColor) {
        if (firstColor == null || secondColor == null) {
            return firstColor;
        }
        int colorR = (firstColor.getRed() + secondColor.getRed()) / 2;
        int colorG = (firstColor.getGreen() + secondColor.getGreen()) / 2;
        int colorB = (firstColor.getBlue() + secondColor.getBlue()) / 2;

        return new Color(colorR, colorG, colorB);
    }

    private PixelPoint translatePointToPixel(
        FractalImage fractalImage,
        Rect world,
        Point point
    ) {
        int x = (int) ((point.x() - world.x()) / world.width() * fractalImage.width());
        int y = (int) ((point.y() - world.y()) / world.height() * fractalImage.height());
        return new PixelPoint(x, y);
    }

    private boolean isWarmupIterations(int i) {
        return i <= Constants.WARMUP_ITERATIONS;
    }

    private Variation randomWeightedVariation(List<Variation> variations, double totalWeight) { // Метод рулетки
        double randomValue = random.nextDouble() * totalWeight;

        for (Variation variation : variations) {
            randomValue -= variation.weight();
            if (randomValue <= 0) {
                return variation;
            }
        }

        return variations.getLast();
    }

    private Point randomStartPoint(Rect rect) {
        return new Point(
            random.nextDouble(rect.x(), rect.xRight()),
            random.nextDouble(rect.y(), rect.yTop())
        );
    }

    private Color randomStartColor() {
        return new Color(random.nextInt(MAX_COLOR_VALUE));
    }
}
