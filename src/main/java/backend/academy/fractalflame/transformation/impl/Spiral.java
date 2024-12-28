package backend.academy.fractalflame.transformation.impl;

import backend.academy.fractalflame.model.Point;
import backend.academy.fractalflame.transformation.Transformation;

public class Spiral implements Transformation {
    @Override
    public Point apply(Point point) {
        double r = point.distance();
        double theta = point.theta();
        return new Point((Math.cos(theta) + Math.sin(r)) / r, (Math.sin(theta) + Math.cos(r)) / r);
    }
}
