package backend.academy.fractalflame.transformation.impl;

import backend.academy.fractalflame.model.Point;
import backend.academy.fractalflame.transformation.Transformation;

public class Fisheye implements Transformation {
    @Override
    public Point apply(Point point) {
        double r = point.distance();
        return new Point(2 * point.y() / (r + 1), 2 * point.x() / (r + 1));
    }
}
