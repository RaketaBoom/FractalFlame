package backend.academy.fractalflame.transformation.impl;

import backend.academy.fractalflame.model.Point;
import backend.academy.fractalflame.transformation.Transformation;

public class Heart implements Transformation {
    @Override
    public Point apply(Point point) {
        double r = point.distance();
        double theta = point.theta();
        return new Point(r * Math.sin(theta * r), -r * Math.cos(theta * r));
    }
}
