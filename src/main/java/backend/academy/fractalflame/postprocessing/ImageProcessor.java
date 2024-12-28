package backend.academy.fractalflame.postprocessing;

import backend.academy.fractalflame.model.FractalImage;

@FunctionalInterface
public interface ImageProcessor {
    void process(FractalImage image);
}
