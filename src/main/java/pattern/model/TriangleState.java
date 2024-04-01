package pattern.model;

public enum TriangleState {
    INVALID, EQUILATERAL, ISOSCELES, SCALENE, RIGHT_ANGLED;

    public static TriangleState detect(Triangle triangle) {
        double a = triangle.getA();
        double b = triangle.getB();
        double c = triangle.getC();

        if (a + b <= c || a + c <= b || b + c <= a) {
            return INVALID;
        }

        boolean isRightAngled = Math.abs(a * a + b * b - c * c) < 0.0001 ||
                Math.abs(a * a + c * c - b * b) < 0.0001 ||
                Math.abs(b * b + c * c - a * a) < 0.0001;

        boolean isEquilateral = Math.abs(a - b) < 0.0001 && Math.abs(b - c) < 0.0001;

        boolean isIsosceles = Math.abs(a - b) < 0.0001 || Math.abs(a - c) < 0.0001 || Math.abs(b - c) < 0.0001;

        if (isRightAngled) return RIGHT_ANGLED;
        if (isEquilateral) return EQUILATERAL;
        if (isIsosceles) return ISOSCELES;
        return SCALENE;
    }
}
