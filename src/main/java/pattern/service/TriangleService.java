package pattern.service;

import pattern.model.Point;
import pattern.model.Triangle;

/**
 Сервис для работы с треугольниками
 */
public class TriangleService {

    /**
     Вычисляет периметр треугольника
     */
    public double perimeter(Triangle triangle) {
        double a = triangle.getA(); // Длина a
        double b = triangle.getB(); // Длина b
        double c = triangle.getC(); // Длина c
        double perimeter = a + b + c;

        // Округление периметра до двух знаков после запятой
        return Point.roundToTwoDecimals(perimeter);
    }
}
