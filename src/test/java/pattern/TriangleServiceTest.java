package pattern;

import org.junit.jupiter.api.Test;
import pattern.ehu.task1.model.Point;
import pattern.ehu.task1.model.Triangle;
import pattern.ehu.task1.service.TriangleService;

import static org.junit.jupiter.api.Assertions.*;

public class TriangleServiceTest {

    @Test
    public void testPerimeter() {
        TriangleService service = new TriangleService();
        Triangle triangle = new Triangle(
                new Point(0.0, 0.0),
                new Point(3.0, 0.0),
                new Point(0.0, 4.0)
        );
        double perimeter = service.perimeter(triangle);
        assertEquals(12.0, perimeter, 0.01);
    }
}
