package backend.academy.fractalflame.model.pixel;

import java.awt.Color;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UnsafePixel implements Pixel {
    private Color color;
    private int hitCount;

    @Override
    public Color color() {
        return color;
    }

    @Override
    public void color(Color color) {
        this.color = color;
    }

    @Override
    public int incrementHitCount() {
        hitCount++;
        return hitCount;
    }

    @Override
    public int hitCount() {
        return hitCount;
    }
}
