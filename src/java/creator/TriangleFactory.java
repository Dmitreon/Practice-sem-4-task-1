package java.creator;

import java.model.Triangle;
import java.model.Point;

import java.util.List;

public interface TriangleFactory {
    List<Triangle> createTriangles(int[][] sides);
}
