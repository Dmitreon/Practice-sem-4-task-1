package pattern.model;

/**
 Возможные состояния треугольника
 */

public enum TriangleState {
    INVALID, // Треугольник не существует
    EQUILATERAL, // Равносторонний
    ISOSCELES, // Равнобедренный
    SCALENE, // Разносторонний
    RIGHT_ANGLED, // Прямоугольный
    ACUTE_ANGLED, // Остроугольный
    OBTUSE_ANGLED; // Тупоугольный

    public static TriangleState detect(Triangle triangle) {
        double a = triangle.getA();
        double b = triangle.getB();
        double c = triangle.getC();

        if (!isValidTriangle(a, b, c)) {
            return INVALID;
        }

        boolean isRightAngled = isRightAngled(a, b, c);
        boolean isEquilateral = isEquilateral(a, b, c);
        boolean isIsosceles = isIsosceles(a, b, c);
        boolean isObtuseAngled = isObtuseAngled(a, b, c);
        boolean isAcuteAngled = isAcuteAngled(a, b, c);

        if (isEquilateral) return EQUILATERAL;
        if (isIsosceles && isRightAngled) return RIGHT_ANGLED;
        if (isIsosceles) return ISOSCELES;
        if (isObtuseAngled) return OBTUSE_ANGLED;
        if (isAcuteAngled) return ACUTE_ANGLED;
        return SCALENE;
    }

    private static boolean isRightAngled(double a, double b, double c) {
        return Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2) ||
                Math.pow(a, 2) + Math.pow(c, 2) == Math.pow(b, 2) ||
                Math.pow(b, 2) + Math.pow(c, 2) == Math.pow(a, 2);
    }

    private static boolean isEquilateral(double a, double b, double c) {
        return Math.abs(a - b) < 0.01 && Math.abs(a - c) < 0.01;
    }

    private static boolean isIsosceles(double a, double b, double c) {
        return Math.abs(a - b) < 0.01 || Math.abs(a - c) < 0.01 || Math.abs(b - c) < 0.01;
    }

    private static boolean isObtuseAngled(double a, double b, double c) {
        return Math.pow(a, 2) + Math.pow(b, 2) < Math.pow(c, 2) ||
                Math.pow(a, 2) + Math.pow(c, 2) < Math.pow(b, 2) ||
                Math.pow(b, 2) + Math.pow(c, 2) < Math.pow(a, 2);
    }

    private static boolean isAcuteAngled(double a, double b, double c) {
        return !isRightAngled(a, b, c) && !isObtuseAngled(a, b, c);
    }

    private static boolean isValidTriangle(double a, double b, double c) {
        double semiPerimeter = (a + b + c) / 2.0;
        double area = Math.sqrt(semiPerimeter * (semiPerimeter - a) * (semiPerimeter - b) * (semiPerimeter - c));
        return a + b > c && a + c > b && b + c > a && area > 0;
    }
}
