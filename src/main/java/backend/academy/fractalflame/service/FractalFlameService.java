package backend.academy.fractalflame.service;

import backend.academy.fractalflame.constant.Constants;
import backend.academy.fractalflame.core.FractalImageGenerator;
import backend.academy.fractalflame.dto.FractalImageRequest;
import backend.academy.fractalflame.model.FractalImage;
import backend.academy.fractalflame.model.Rect;
import backend.academy.fractalflame.model.Variation;
import backend.academy.fractalflame.postprocessing.ImageProcessor;
import backend.academy.fractalflame.transformation.Transformation;
import backend.academy.fractalflame.transformation.impl.Symmetry;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FractalFlameService {
    private final FractalImageGenerator fractalImageGenerator;
    private final ImageProcessor imageProcessor;

    public FractalImage createFractalImage(FractalImageRequest request) {
        List<Variation> variations = request.variations();

        addSymmetry(variations, request.symmetry(), Constants.WORLD);

        return fractalImageGenerator.generate(
            request.width(),
            request.height(),
            request.iterations(),
            request.variations(),
            Constants.WORLD
        );
    }

    public FractalImage postProcessing(FractalImage image) {
        imageProcessor.process(image);

        return image;
    }

    private void addSymmetry(List<Variation> variations, int symmetryParts, Rect world) {
        double sum = variations.stream()
            .mapToDouble(Variation::weight).sum();
        Transformation symmetry = new Symmetry(symmetryParts, world);

        variations.add(new Variation(symmetry, sum, null));
    }
}
