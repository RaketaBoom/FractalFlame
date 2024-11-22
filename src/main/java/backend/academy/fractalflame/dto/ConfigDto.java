package backend.academy.fractalflame.dto;

import java.util.List;

public record ConfigDto(
    int height,
    int width,
    int iterations,
    boolean gammaCorrection,
    boolean symmetry,
    List<String> transformations
) {
}
