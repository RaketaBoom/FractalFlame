package backend.academy.fractalflame.transformation.impl;

import backend.academy.fractalflame.model.Point;
import backend.academy.fractalflame.transformation.Transformation;

public class Ex implements Transformation {
    @Override
    public Point apply(Point point) {
        double r = point.distance();
        double theta = point.theta();
        double p0 = Math.sin(theta + r);
        double p1 = Math.cos(theta - r);
        double p03 = p0 * p0 * p0;
        double p13 = p1 * p1 * p1;
        return new Point(r * (p03 + p13), r * (p03 - p13));
    }
}
