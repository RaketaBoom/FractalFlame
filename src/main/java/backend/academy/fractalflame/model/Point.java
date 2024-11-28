package backend.academy.fractalflame.model;

public record Point(double x, double y) {
    public double distance() {
        return Math.sqrt(x * x + y * y);
    }

    public double theta() {
        return Math.atan2(x, y);
    }
}
