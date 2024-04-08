package pattern.creator.impl;

import pattern.creator.TriangleFactory;
import pattern.model.Triangle;
import pattern.model.Point;
import pattern.service.TriangleValidatorService;

/**
 Фабрика для создания треугольников
 */
public class TriangleFactoryImpl implements TriangleFactory {
    // Сервис для проверки треугольников
    private final TriangleValidatorService validatorService = new TriangleValidatorService();
    @Override
    public Triangle createTriangle(Point[] points) {
        // Если точки образуют треугольник, создаем его
        if (validatorService.isValidTriangle(points)) {
            return new Triangle(points[0], points[1], points[2]);
        }
        // Если нет, возвращаем null
        return null;
    }
}
