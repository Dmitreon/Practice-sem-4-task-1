package pattern.ehu.task1.service;

import pattern.ehu.task1.model.Point;
import pattern.ehu.task1.model.Triangle;

public class TriangleService {

    public double perimeter(Triangle triangle) {
        double a = triangle.getA();
        double b = triangle.getB();
        double c = triangle.getC();
        double perimeter = a + b + c;

        return Point.roundToTwoDecimals(perimeter);
    }
}
