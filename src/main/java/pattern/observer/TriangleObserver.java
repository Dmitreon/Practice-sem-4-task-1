package pattern.observer;

import pattern.model.Triangle;

/**
 Интерфейс для наблюдателя, который реагирует на изменения треугольников
 */
public interface TriangleObserver {
    /**
     Вызывается, когда "наблюдаемый" треугольник изменяется.
     */
    void update(Triangle triangle);
}
