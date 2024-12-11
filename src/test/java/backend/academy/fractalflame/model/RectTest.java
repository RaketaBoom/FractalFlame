package backend.academy.fractalflame.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RectTest {
    @Test
    void contains_pointInsideRect_returnsTrue() {
        // Arrange
        Rect rect = new Rect(0, 0, 10, 10);
        Point point = new Point(5, 5);

        // Act & Assert
        assertTrue(rect.contains(point));
    }

    @Test
    void contains_pointOutsideRect_returnsFalse() {
        // Arrange
        Rect rect = new Rect(0, 0, 10, 10);
        Point point = new Point(15, 5);

        // Act & Assert
        assertFalse(rect.contains(point));
    }

    @Test
    void contains_pointOnEdge_returnsTrue() {
        // Arrange
        Rect rect = new Rect(0, 0, 10, 10);
        Point point = new Point(10, 5);

        // Act & Assert
        assertTrue(rect.contains(point));
    }

    @Test
    void xRight_correctCalculation_returnsCorrectValue() {
        // Arrange
        Rect rect = new Rect(0, 0, 10, 10);

        // Act & Assert
        assertEquals(10, rect.xRight());
    }

    @Test
    void yTop_correctCalculation_returnsCorrectValue() {
        // Arrange
        Rect rect = new Rect(0, 0, 10, 10);

        // Act & Assert
        assertEquals(10, rect.yTop());
    }
}
