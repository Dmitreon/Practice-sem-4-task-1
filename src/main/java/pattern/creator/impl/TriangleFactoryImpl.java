package pattern.creator.impl;

import pattern.creator.TriangleFactory;
import pattern.model.Triangle;
import pattern.model.Point;
import pattern.service.TriangleValidatorService;

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
