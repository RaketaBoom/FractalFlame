package backend.academy.fractalflame.model.pixel;

import java.awt.Color;

public interface Pixel {
    Color color();
    void color(Color color);
    int hitCount();
    int incrementHitCount();
}
