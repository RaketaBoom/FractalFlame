package backend.academy.fractalflame.model;

import java.awt.Color;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Pixel {
    private Color color;
    private int hitCount;

    public int incrementHitCount() {
        hitCount++;
        return hitCount;
    }
}
