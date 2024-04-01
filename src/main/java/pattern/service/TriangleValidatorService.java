package pattern.service;

import pattern.model.Point;

public class TriangleValidatorService {
    public boolean isValidTriangle(Point[] points) {
        double a = points[0].distanceTo(points[1]);
        double b = points[1].distanceTo(points[2]);
        double c = points[2].distanceTo(points[0]);
        return a + b > c && a + c > b && b + c > a;
    }
}
