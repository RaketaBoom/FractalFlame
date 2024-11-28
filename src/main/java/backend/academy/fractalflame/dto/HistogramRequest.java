package backend.academy.fractalflame.dto;

import backend.academy.fractalflame.model.Variation;
import java.util.List;

public record HistogramRequest(
    int height,
    int width,
    int iterations,
    int symmetry,
    List<Variation> variations
) {
}