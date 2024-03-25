package pattern.service;

import pattern.model.Point;

public class TriangleValidatorService {

    public boolean isValidTriangle(Point vertexA, Point vertexB, Point vertexC) {
        double a = distanceBetweenPoints(vertexB, vertexC);
        double b = distanceBetweenPoints(vertexA, vertexC);
        double c = distanceBetweenPoints(vertexA, vertexB);

        return a + b > c && a + c > b && b + c > a;
    }

    private double distanceBetweenPoints(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));
    }
}

