package pattern.creator;

import pattern.model.Triangle;
import pattern.model.Point;

public interface TriangleFactory {
    Triangle createTriangle(Point[] points);
}
