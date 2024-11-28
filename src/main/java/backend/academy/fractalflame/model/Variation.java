package backend.academy.fractalflame.model;

import backend.academy.fractalflame.transformation.Transformation;
import java.awt.Color;

public record Variation(
    Transformation transformation,
    double weight,
    Color color
) {
}
