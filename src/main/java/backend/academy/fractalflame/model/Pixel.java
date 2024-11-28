package backend.academy.fractalflame.model;

import backend.academy.fractalflame.constant.Constants;
import java.awt.Color;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Pixel {
    private Color color;
    private int hitCount;

    public Pixel() {
        color = Constants.BACKGROUND_COLOR;
        hitCount = 0;
    }

    public int incrementHitCount() {
        hitCount++;
        return hitCount;
    }
}
