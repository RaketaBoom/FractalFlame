package backend.academy.fractalflame.transformation.impl;

import backend.academy.fractalflame.model.Point;
import backend.academy.fractalflame.transformation.Transformation;

public record AffineTransform(double a, double b, double c, double d, double e, double f) implements Transformation {
    @Override
    public Point apply(Point p) {
        double x = a * p.x() + b * p.y() + e;
        double y = c * p.x() + d * p.y() + f;
        return new Point(x, y);
    }
}
