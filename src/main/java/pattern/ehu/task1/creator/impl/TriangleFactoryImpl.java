package pattern.ehu.task1.creator.impl;

import pattern.ehu.task1.creator.TriangleFactory;
import pattern.ehu.task1.model.Triangle;
import pattern.ehu.task1.model.Point;
import pattern.ehu.task1.service.TriangleValidatorService;

public class TriangleFactoryImpl implements TriangleFactory {
    private final TriangleValidatorService validatorService = new TriangleValidatorService();
    @Override
    public Triangle createTriangle(Point[] points) {
        if (validatorService.isValidTriangle(points)) {
            return new Triangle(points[0], points[1], points[2]);
        }
        return null;
    }
}
