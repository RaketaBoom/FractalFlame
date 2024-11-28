package backend.academy.fractalflame.service;

import backend.academy.fractalflame.constant.Constants;
import backend.academy.fractalflame.dto.HistogramRequest;
import backend.academy.fractalflame.generator.FlameHistogramGenerator;
import backend.academy.fractalflame.model.FractalImage;
import backend.academy.fractalflame.model.Rect;
import backend.academy.fractalflame.model.Variation;
import backend.academy.fractalflame.transformation.Transformation;
import backend.academy.fractalflame.transformation.impl.AffineTransform;
import backend.academy.fractalflame.transformation.impl.Symmetry;
import java.awt.Color;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FractalFlameService {
    private final FlameHistogramGenerator flameHistogramGenerator;

    public FractalImage createFlameHistogram(HistogramRequest request) {
        List<Variation> variations = request.variations();


        //TODO убрать затычку аффинных функций и брать их из конфигурации
        List<AffineTransform> predefinedAffineTransforms = List.of(
            new AffineTransform(0.5, 0.0, 0.0, 0.5, 0.0, 0.0), // Уменьшение
            new AffineTransform(0.85, 0.04, -0.04, 0.85, 0.0, 1.6) // Смещение вверх
//            new AffineTransform(0.2, -0.26, 0.23, 0.22, 0.0, 1.6), // Левое ответвление
//            new AffineTransform(-0.15, 0.28, 0.26, 0.24, 0.0, 0.44) // Правое ответвление
        );

        variations.addAll(
            predefinedAffineTransforms.stream()
                .map(transform -> new Variation(transform, 0.1, Color.decode("#0C1DBA")))
                .toList()
        );


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
    public FractalImage postProcessing(FractalImage fractalImage) {
        return null;
    }

    private void addSymmetry(List<Variation> variations, int symmetryParts, Rect world) {
        double sum = variations.stream()
            .mapToDouble(Variation::weight).sum();
        Transformation symmetry = new Symmetry(symmetryParts, world);

        variations.add(new Variation(symmetry, sum, null));
    }
}
