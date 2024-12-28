package backend.academy.fractalflame.model.pixel;

import java.awt.Color;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class SafePixel implements Pixel {
    private final AtomicReference<Color> color;
    private final AtomicInteger hitCount;

    public SafePixel(Color color, int hitCount) {
        this.color = new AtomicReference<>(color);
        this.hitCount = new AtomicInteger(hitCount);
    }

    @Override
    public Color color() {
        return color.get();
    }

    @Override
    public void color(Color newColor) {
        color.updateAndGet(oldColor -> newColor);
    }

    @Override
    public int incrementHitCount() {
        return hitCount.incrementAndGet();
    }

    @Override
    public int hitCount() {
        return hitCount.get();
    }
}
