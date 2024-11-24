package backend.academy.fractalflame.dto;

import java.util.List;

public record ConfigDto(
    int height,
    int width,
    int iterations,
    int symmetry,
    List<VariationDto> variations,
    String format
) {
}
