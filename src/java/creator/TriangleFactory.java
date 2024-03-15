package java.creator;

import java.model.Triangle;
import java.model.Point;

import java.util.List;

public interface TriangleFactory {
    Triangle createTriangle(Point vertexA, Point vertexB, Point vertexC);
}
