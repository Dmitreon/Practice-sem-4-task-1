package pattern.service;

import pattern.model.Triangle;

public class TriangleService {

    public double perimeter(Triangle triangle) {
        double a = triangle.getA();
        double b = triangle.getB();
        double c = triangle.getC();

        return a + b + c;
    }
}
