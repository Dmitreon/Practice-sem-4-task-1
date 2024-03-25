package pattern.service;

import pattern.model.Triangle;

public class TriangleService {

    // Метод для вычисления периметра треугольника
    public double perimeter(Triangle triangle) {
        // Получение длин сторон треугольника
        double a = triangle.getA();
        double b = triangle.getB();
        double c = triangle.getC();

        // Вычисление и возврат периметра
        return a + b + c;
    }
}
