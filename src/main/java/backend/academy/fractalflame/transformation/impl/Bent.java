package backend.academy.fractalflame.transformation.impl;

import backend.academy.fractalflame.model.Point;
import backend.academy.fractalflame.transformation.Transformation;

public class Bent implements Transformation {
    @Override
    public Point apply(Point point) {
        double newX = point.x() >= 0 ? point.x() : 2 * point.x();
        double newY = point.y() >= 0 ? point.y() : point.y() / 2;
        return new Point(newX, newY);
    }
}
