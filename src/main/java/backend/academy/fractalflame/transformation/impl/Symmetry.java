package backend.academy.fractalflame.transformation.impl;

import backend.academy.fractalflame.model.Point;
import backend.academy.fractalflame.model.Rect;
import backend.academy.fractalflame.transformation.Transformation;

public class Symmetry implements Transformation {
    private final double angle;
    private final Point center;

    public Symmetry(int symmetryParts, Rect rect) {
        this.angle = 2 * Math.PI / symmetryParts;
        this.center = new Point(rect.x() + rect.width() / 2, rect.y() + rect.height() / 2);
    }

    @Override
    public Point apply(Point point) {
        double dx = point.x() - center.x();
        double dy = point.y() - center.y();
        return new Point(
            dx * Math.cos(angle) - dy * Math.sin(angle) + center.x(),
            dx * Math.sin(angle) + dy * Math.cos(angle) + center.y()
        );
    }
}
