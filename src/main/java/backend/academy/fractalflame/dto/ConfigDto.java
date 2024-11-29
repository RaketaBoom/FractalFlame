package backend.academy.fractalflame.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public record ConfigDto(
    int height,
    int width,
    int iterations,
    int symmetry,
    List<VariationDto> variations,

    @JsonProperty("affine_functions")
    List<AffineFunctionDto> affineFunctions,
    String format
) {
}
