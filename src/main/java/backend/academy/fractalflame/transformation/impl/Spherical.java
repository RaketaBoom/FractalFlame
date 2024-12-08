package backend.academy.fractalflame.transformation.impl;

import backend.academy.fractalflame.model.Point;
import backend.academy.fractalflame.transformation.Transformation;

public class Spherical implements Transformation {
    @Override
    public Point apply(Point point) {
        double r = point.distance();
        double r2 = r * r;
        return new Point(point.x() / r2, point.y() / r2);
    }
}
