package pattern.model;

public enum TriangleState {
    INVALID, EQUILATERAL, ISOSCELES, SCALENE, RIGHT_ANGLED;

    public static TriangleState detect(Triangle triangle) {
        double a = triangle.getA();
        double b = triangle.getB();
        double c = triangle.getC();

        // Проверка на существование треугольника
        if (a + b <= c || a + c <= b || b + c <= a) {
            return INVALID;
        }

        // Проверка на прямоугольный треугольник по теореме Пифагора
        boolean isRightAngled = Math.abs(a * a + b * b - c * c) < 0.001 ||
                Math.abs(a * a + c * c - b * b) < 0.001 ||
                Math.abs(b * b + c * c - a * a) < 0.001;

        // Проверка на равносторонний треугольник
        boolean isEquilateral = Math.abs(a - b) < 0.001 && Math.abs(b - c) < 0.001;

        // Проверка на равнобедренный треугольник
        boolean isIsosceles = Math.abs(a - b) < 0.001 || Math.abs(a - c) < 0.001 || Math.abs(b - c) < 0.001;

        if (isRightAngled) return RIGHT_ANGLED;
        if (isEquilateral) return EQUILATERAL;
        if (isIsosceles) return ISOSCELES;
        return SCALENE;
    }
}
