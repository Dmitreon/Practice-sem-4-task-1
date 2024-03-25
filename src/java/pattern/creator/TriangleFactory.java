package pattern.creator;

import pattern.model.Triangle;
import pattern.model.Triangle;

import java.util.List;

public interface TriangleFactory {
    List<Triangle> createTriangles(int[][] sides);
}
