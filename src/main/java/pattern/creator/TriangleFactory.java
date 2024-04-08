package pattern.creator;

import pattern.model.Triangle;
import pattern.model.Point;

/**
 Интерфейс фабрики для создания объектов треугольников
 */
public interface TriangleFactory {

    /**
     Создает треугольник на основе предоставленных точек
     */
    Triangle createTriangle(Point[] points);
}
