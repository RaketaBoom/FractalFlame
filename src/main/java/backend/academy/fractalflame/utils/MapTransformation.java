package backend.academy.fractalflame.utils;

import backend.academy.fractalflame.transformation.Transformation;
import backend.academy.fractalflame.transformation.impl.Bent;
import backend.academy.fractalflame.transformation.impl.Diamond;
import backend.academy.fractalflame.transformation.impl.Disc;
import backend.academy.fractalflame.transformation.impl.Ex;
import backend.academy.fractalflame.transformation.impl.Fisheye;
import backend.academy.fractalflame.transformation.impl.Heart;
import backend.academy.fractalflame.transformation.impl.Hyperbolic;
import backend.academy.fractalflame.transformation.impl.Sinusoidal;
import backend.academy.fractalflame.transformation.impl.Spherical;
import backend.academy.fractalflame.transformation.impl.Spiral;
import java.util.Map;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MapTransformation {
    private static final Map<String, Transformation> TRANSFORMATION_MAP = Map.ofEntries(
        Map.entry("Bent", new Bent()),
        Map.entry("Diamond", new Diamond()),
        Map.entry("Disc", new Disc()),
        Map.entry("Ex", new Ex()),
        Map.entry("Fisheye", new Fisheye()),
        Map.entry("Heart", new Heart()),
        Map.entry("Hyperbolic", new Hyperbolic()),
        Map.entry("Sinusoidal", new Sinusoidal()),
        Map.entry("Spherical", new Spherical()),
        Map.entry("Spiral", new Spiral())
    );

    public static Transformation get(String title) {
        return TRANSFORMATION_MAP.get(title);
    }
}
