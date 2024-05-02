package pattern.ehu.task1.service;

import pattern.ehu.task1.model.Point;

public class TriangleValidatorService {
    public boolean isValidTriangle(Point[] points) {
        double a = points[0].distanceTo(points[1]);
        double b = points[1].distanceTo(points[2]);
        double c = points[2].distanceTo(points[0]);

        boolean sidesCheck = a + b > c && a + c > b && b + c > a;

        double area = 0.5 * Math.abs(
                points[0].getX() * (points[1].getY() - points[2].getY()) +
                        points[1].getX() * (points[2].getY() - points[0].getY()) +
                        points[2].getX() * (points[0].getY() - points[1].getY())
        );

        return sidesCheck && area > 0;
    }
}
