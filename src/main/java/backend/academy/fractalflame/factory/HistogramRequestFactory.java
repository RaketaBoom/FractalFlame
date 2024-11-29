package backend.academy.fractalflame.factory;

import backend.academy.fractalflame.dto.AffineFunctionDto;
import backend.academy.fractalflame.dto.ConfigDto;
import backend.academy.fractalflame.dto.HistogramRequest;
import backend.academy.fractalflame.dto.VariationDto;
import backend.academy.fractalflame.exception.IllegalTransformationException;
import backend.academy.fractalflame.model.Variation;
import backend.academy.fractalflame.transformation.Transformation;
import backend.academy.fractalflame.transformation.impl.AffineTransform;
import backend.academy.fractalflame.utils.MapTransformation;
import backend.academy.fractalflame.validator.ConfigValidator;
import backend.academy.fractalflame.validator.VariationValidator;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import lombok.experimental.UtilityClass;

@UtilityClass
public class HistogramRequestFactory {
    public static HistogramRequest createFromConfig(ConfigDto config) {
        ConfigValidator.validate(config);

        List<Variation> variations = mapVariations(config.variations(), config.affineFunctions());

        return new HistogramRequest(config.height(), config.width(), config.iterations(), config.symmetry(),
            variations);
    }

    private static List<Variation> mapVariations(
        List<VariationDto> variationDtos,
        List<AffineFunctionDto> affineFunctionDtos
    ) {
        List<Variation> variations = new ArrayList<>();
        for (var varDto : variationDtos) {
            VariationValidator.validateColor(varDto.color());
            Transformation transformation = getTransformation(varDto.name());
            variations.add(new Variation(
                transformation,
                varDto.weight(),
                Color.decode(varDto.color()))
            );
        }

        for (var funcDto : affineFunctionDtos) {
            VariationValidator.validateColor(funcDto.color());
            variations.add(new Variation(
                new AffineTransform(funcDto.a(), funcDto.b(), funcDto.c(), funcDto.d(), funcDto.e(), funcDto.f()),
                funcDto.weight(),
                Color.decode(funcDto.color())
            ));
        }
        return variations;
    }

    private static Transformation getTransformation(String title) {
        Transformation transformation = MapTransformation.get(title);
        if (transformation == null) {
            throw new IllegalTransformationException(title);
        }
        return transformation;
    }
}
