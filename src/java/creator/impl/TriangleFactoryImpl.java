package java.creator.impl;

import java.creator.TriangleFactory;
import java.model.Triangle;
import java.model.Point;
import java.service.TriangleValidatorService;

public class TriangleFactoryImpl implements TriangleFactory {
    private final TriangleValidatorService validatorService = new TriangleValidatorService();

    @Override
    public Triangle createTriangle(Point vertexA, Point vertexB, Point vertexC) {
        if (validatorService.isValidTriangle(vertexA, vertexB, vertexC)) {
            return new Triangle(vertexA, vertexB, vertexC);
        } else {
            // Здесь вы можете выбросить исключение или вернуть null, в зависимости от того, как вы хотите обрабатывать невалидные треугольники.
            // Например:
            throw new IllegalArgumentException("Points do not make a valid triangle.");
        }
    }
}
