package backend.academy.fractalflame.core;

import backend.academy.fractalflame.constant.Constants;
import backend.academy.fractalflame.model.FractalImage;
import backend.academy.fractalflame.model.Rect;
import backend.academy.fractalflame.model.Variation;
import backend.academy.fractalflame.model.pixel.Pixel;
import backend.academy.fractalflame.model.pixel.SafePixel;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MultiThreadingFractalImageGenerator implements FractalImageGenerator {
    private final int threads;

    @Override
    public FractalImage generate(
        int width,
        int height,
        int iterations,
        List<Variation> variations,
        Rect world
    ) {
        FractalImage image = new FractalImage(width, height, safePixelMatrix(width, height));

        try (ExecutorService executor = Executors.newFixedThreadPool(threads)) {
            IntStream.range(0, threads).forEach(
                i -> executor.submit(() -> {
                    FractalGeneratingProcessor processor =
                        new FractalGeneratingProcessor(ThreadLocalRandom.current(), variations, world);
                    processor.process(image, iterations / threads);
                })
            );
        }

        return image;
    }

    private Pixel[][] safePixelMatrix(int width, int height) {
        Pixel[][] data = new Pixel[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                data[i][j] = new SafePixel(Constants.BACKGROUND_COLOR, 0);
            }
        }
        return data;
    }
}
