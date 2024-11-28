package backend.academy.fractalflame.utils;

import backend.academy.fractalflame.transformation.Transformation;
import backend.academy.fractalflame.transformation.impl.Heart;
import lombok.experimental.UtilityClass;
import java.util.Map;

@UtilityClass
public class MapTransformation {
    //TODO добавить закоменченные вариационные функции
    private static final Map<String, Transformation> TRANSFORMATION_MAP = Map.ofEntries(
//        Map.entry("Bent", new Bent()),
//        Map.entry("Diamond", new Diamond()),
//        Map.entry("Disc", new Disc()),
//        Map.entry("Ex", new Ex()),
//        Map.entry("Fisheye", new Fisheye()),
//        Map.entry("Handkerchief", new Handkerchief()),
        Map.entry("Heart", new Heart())
//        Map.entry("Horseshoe", new Horseshoe()),
//        Map.entry("Hyperbolic", new Hyperbolic()),
//        Map.entry("Sinusoidal", new Sinusoidal()),
//        Map.entry("Spherical", new Spherical()),
//        Map.entry("Spiral", new Spiral()),
//        Map.entry("Swirl", new Swirl())
    );

    public static Transformation get(String title){
        return TRANSFORMATION_MAP.get(title);
    }
}
