package backend.academy.fractalflame.service;

import backend.academy.fractalflame.constant.Constants;
import backend.academy.fractalflame.core.FlameHistogramGenerator;
import backend.academy.fractalflame.dto.HistogramRequest;
import backend.academy.fractalflame.dto.PostProcessingRequest;
import backend.academy.fractalflame.model.FractalImage;
import backend.academy.fractalflame.model.Rect;
import backend.academy.fractalflame.model.Variation;
import backend.academy.fractalflame.transformation.Transformation;
import backend.academy.fractalflame.transformation.impl.Symmetry;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FractalFlameService {
    private final FlameHistogramGenerator flameHistogramGenerator;

    public FractalImage createFlameHistogram(HistogramRequest request) {
        List<Variation> variations = request.variations();

        addSymmetry(variations, request.symmetry(), Constants.WORLD);

        return flameHistogramGenerator.generate(
            request.width(),
            request.height(),
            request.iterations(),
            request.variations(),
            Constants.WORLD
        );
    }

    //TODO написать постпроцессинг, можно тоже конфигурировать постпроцессинг
    public FractalImage postProcessing(PostProcessingRequest request) {
        return null;
    }

    private void addSymmetry(List<Variation> variations, int symmetryParts, Rect world) {
        double sum = variations.stream()
            .mapToDouble(Variation::weight).sum();
        Transformation symmetry = new Symmetry(symmetryParts, world);

        variations.add(new Variation(symmetry, sum, null));
    }
}
