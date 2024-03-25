package pattern.creator.impl;

import pattern.creator.TriangleFactory;
import pattern.model.Triangle;
import pattern.model.TriangleState;

import java.util.ArrayList;
import java.util.List;

public class TriangleFactoryImpl implements TriangleFactory {
    @Override
    public List<Triangle> createTriangles(int[][] sides) {
        List<Triangle> newTriangles = new ArrayList<>();
        for (int[] current : sides) {
            if (isValidTriangleSides(current[0], current[1], current[2])) {
                Triangle triangle = new Triangle(current[0], current[1], current[2]);
                TriangleState currentState = TriangleState.detect(triangle);
                triangle.setState(currentState);
                newTriangles.add(triangle);
            }
        }
        return newTriangles;
    }

    // Метод для валидации сторон треугольника
    private boolean isValidTriangleSides(double a, double b, double c) {
        // Проверка существования треугольника
        return (a + b > c) && (a + c > b) && (b + c > a);
    }
}

