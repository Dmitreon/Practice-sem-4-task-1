package pattern.ehu.task1.creator;

import pattern.ehu.task1.model.Triangle;
import pattern.ehu.task1.model.Point;

public interface TriangleFactory {
    Triangle createTriangle(Point[] points);
}
