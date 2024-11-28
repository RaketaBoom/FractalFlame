package backend.academy.fractalflame.generator;

import backend.academy.fractalflame.constant.Constants;
import backend.academy.fractalflame.model.FractalImage;
import backend.academy.fractalflame.model.Pixel;
import backend.academy.fractalflame.model.PixelPoint;
import backend.academy.fractalflame.model.Point;
import backend.academy.fractalflame.model.Rect;
import backend.academy.fractalflame.model.Variation;
import java.awt.Color;
import java.util.List;
import java.util.Random;
import lombok.RequiredArgsConstructor;

//TODO переназвать класс в FractalImageGenerator или FractalImage переименовать в Histogram
@RequiredArgsConstructor
public class FlameHistogramGenerator {
    public static final int MAX_COLOR_VALUE = 0xFFFFFF;

    private final Random random;

    public FractalImage generate( // тут мы думаем, что нам уже передали симметрию в variations
        int width,
        int height,
        int iterations,
        List<Variation> variations,
        Rect world
    ) {
        FractalImage fractalImage = new FractalImage(width, height);
        Point currPoint = randomStartPoint(world);
        Color currColor = randomStartColor();

        for (int i = 0; i < iterations; i++) {
            Variation variation = randomWeightedVariation(variations);
            currPoint = variation.transformation().apply(currPoint);

            currColor = mixColors(currColor, variation.color());

            if (!isWarmupIterations(i)) {
                PixelPoint pixelPoint = translatePointToPixel(fractalImage, world, currPoint);

                if (fractalImage.contains(pixelPoint)) {
                    Pixel pixel = fractalImage.pixel(pixelPoint);
                    pixel.color(currColor);
                    pixel.incrementHitCount();
                }
            }
        }

        return fractalImage;
    }

    //TODO переназвать переменные
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

    private Variation randomWeightedVariation(List<Variation> variations) { // Метод рулетки
        double totalWeight = variations.stream()
            .mapToDouble(Variation::weight)
            .sum();
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
