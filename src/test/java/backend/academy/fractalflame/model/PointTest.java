package backend.academy.fractalflame.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PointTest {
    double DELTA = 1e-15;

    @Test
    void distance_origin_returnsZero() {
        // Arrange
        Point point = new Point(0, 0);

        // Act & Assert
        assertEquals(0, point.distance());
    }

    @Test
    void distance_positiveCoordinates_returnsCorrectDistance() {
        // Arrange
        Point point = new Point(3, 4);

        // Act & Assert
        assertEquals(5, point.distance());
    }

    @Test
    void distance_negativeCoordinates_returnsCorrectDistance() {
        // Arrange
        Point point = new Point(-3, -4);

        // Act & Assert
        assertEquals(5, point.distance());
    }

    @Test
    void theta_origin_returnsZero() {
        // Arrange
        Point point = new Point(0, 0);

        // Act & Assert
        assertEquals(0, point.theta());
    }

    @Test
    void theta_positiveCoordinates_returnsCorrectTheta() {
        // Arrange
        Point point = new Point(1, 1);

        // Act & Assert
        assertEquals(Math.PI / 4, point.theta(), DELTA);
    }

    @Test
    void theta_negativeCoordinates_returnsCorrectTheta() {
        // Arrange
        Point point = new Point(-1, -1);

        // Act & Assert
        assertEquals(-3 * Math.PI / 4, point.theta(), DELTA);
    }
}
