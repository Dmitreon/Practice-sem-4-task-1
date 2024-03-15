package java.service;

import java.model.Point;
import java.model.Triangle;

public class TriangleService {

    public double calculatePerimeter(Triangle triangle) {
        double a = distanceBetweenPoints(triangle.getVertexA(), triangle.getVertexB());
        double b = distanceBetweenPoints(triangle.getVertexB(), triangle.getVertexC());
        double c = distanceBetweenPoints(triangle.getVertexC(), triangle.getVertexA());

        return a + b + c;
    }

    public TriangleType determineTriangleType(Triangle triangle) {
        double a = distanceBetweenPoints(triangle.getVertexA(), triangle.getVertexB());
        double b = distanceBetweenPoints(triangle.getVertexB(), triangle.getVertexC());
        double c = distanceBetweenPoints(triangle.getVertexC(), triangle.getVertexA());

        if (a == b && b == c) {
            return TriangleType.EQUILATERAL;
        } else if (a == b || a == c || b == c) {
            return TriangleType.ISOSCELES;
        } else {
            return TriangleType.SCALENE;
        }
    }

    private double distanceBetweenPoints(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));
    }

    public enum TriangleType {
        EQUILATERAL, // Равносторонний
        ISOSCELES,   // Равнобедренный
        SCALENE      // Разносторонний
    }
}
