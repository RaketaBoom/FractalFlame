package backend.academy.fractalflame.transformation.impl;

import backend.academy.fractalflame.model.Point;
import backend.academy.fractalflame.transformation.Transformation;

public class Noise implements Transformation {
    @Override
    public Point apply(Point point) {
        double x = point.x();
        double y = point.y();

        double noiseX = Math.random() - 0.5;
        double noiseY = Math.random() - 0.5;

        return new Point(x + noiseX, y + noiseY);
    }
}
