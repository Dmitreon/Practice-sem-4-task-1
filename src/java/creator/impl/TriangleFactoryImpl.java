package java.creator.impl;

import java.creator.TriangleFactory;
import java.model.Triangle;
import java.model.Point;
import java.model.TriangleState;
import java.service.TriangleValidatorService;
import java.util.ArrayList;
import java.util.List;

public class TriangleFactoryImpl implements TriangleFactory {
    @Override
    public List<Triangle> createTriangles(int[][] sides) {
        List<Triangle> newTriangles = new ArrayList<>();
        for (int[] current : sides) {
            Triangle triangle = new Triangle(current[0], current[1],current[2]);
            TriangleState currentState = TriangleState.detect(triangle);
            //   triangle.setState(currentState);
            newTriangles.add(triangle);
        }
        return newTriangles;
    }
}
