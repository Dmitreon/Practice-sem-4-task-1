package pattern.service;

import pattern.model.Point;

public class TriangleValidatorService {
    public boolean isValidTriangle(Point[] points) {
        double a = points[0].distanceTo(points[1]);
        double b = points[1].distanceTo(points[2]);
        double c = points[2].distanceTo(points[0]);

        // Проверка, что сумма длин любых двух сторон больше длины третьей стороны
        boolean sidesCheck = a + b > c && a + c > b && b + c > a;

        // Проверка, что площадь треугольника не равна нулю
        double area = 0.5 * Math.abs(
                points[0].getX() * (points[1].getY() - points[2].getY()) +
                        points[1].getX() * (points[2].getY() - points[0].getY()) +
                        points[2].getX() * (points[0].getY() - points[1].getY())
        );

        return sidesCheck && area > 0;
    }
}
