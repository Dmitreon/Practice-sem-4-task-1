package pattern;

import org.junit.jupiter.api.Test;
import pattern.ehu.task1.creator.impl.TriangleFactoryImpl;
import pattern.ehu.task1.model.Point;
import pattern.ehu.task1.model.Triangle;

import static org.junit.jupiter.api.Assertions.*;

public class TriangleFactoryImplTest {

    @Test
    public void testCreateValidTriangle() {
        TriangleFactoryImpl factory = new TriangleFactoryImpl();
        Point[] points = {
                new Point(0.0, 0.0),
                new Point(3.0, 0.0),
                new Point(0.0, 4.0)
        };
        Triangle triangle = factory.createTriangle(points);
        assertNotNull(triangle);
        assertEquals(5.0, triangle.getA(), 0.01);
        assertEquals(4.0, triangle.getB(), 0.01);
        assertEquals(3.0, triangle.getC(), 0.01);
    }

    @Test
    public void testCreateInvalidTriangle() {
        TriangleFactoryImpl factory = new TriangleFactoryImpl();
        Point[] points = {
                new Point(0.0, 0.0),
                new Point(1.0, 1.0),
                new Point(2.0, 2.0)
        };
        Triangle triangle = factory.createTriangle(points);
        assertNull(triangle);
    }
}
