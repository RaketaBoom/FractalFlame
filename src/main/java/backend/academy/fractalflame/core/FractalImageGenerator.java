package backend.academy.fractalflame.core;

import backend.academy.fractalflame.model.FractalImage;
import backend.academy.fractalflame.model.Rect;
import backend.academy.fractalflame.model.Variation;
import java.util.List;

public interface FractalImageGenerator {
    FractalImage generate(
        int width,
        int height,
        int iterations,
        List<Variation> variations,
        Rect world
    );
}
