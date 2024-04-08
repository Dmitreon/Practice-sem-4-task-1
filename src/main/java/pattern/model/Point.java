package pattern.model;

/**
 Класс представляющий точку в 2D пространстве.
 */
public class Point {
    private final double x; // Координата X точки
    private final double y; // Координата Y точки

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    /**
     Вычисляет расстояние от этой точки до другой, округленное до двух знаков после запятой
     */
    public double distanceTo(Point other) {
        double distance = Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
        return roundToTwoDecimals(distance);
    }

    /**
     Переопределение метода toString для представления точки в текстовом формате
     */
    @Override
    public String toString() {
        return "Point{" + "x=" + x + ", y=" + y + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point point = (Point) o;
        return Double.compare(point.x, x) == 0 &&
                Double.compare(point.y, y) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(x);
        int result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    /**
     Метод для округления значения до двух знаков после запятой
     */
    public static double roundToTwoDecimals(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}
