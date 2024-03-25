package pattern.observer.impl;

import pattern.model.Triangle;
import pattern.model.TriangleState;
import pattern.model.Warehouse;
import pattern.observer.TriangleObserver;
import pattern.service.TriangleService;

public class TriangleObserverImpl implements TriangleObserver {
    private TriangleService service;

    // Конструктор, который принимает TriangleService
    public TriangleObserverImpl(TriangleService service) {
        this.service = service;
    }

    public TriangleObserverImpl() {
    }

    @Override
    public void update(Triangle triangle) {
        // Обновление состояния треугольника
        TriangleState state = TriangleState.detect(triangle);
        triangle.setState(state);

        // Вычисление периметра треугольника
        double perimeter = service.perimeter(triangle);

        // Получение ID треугольника
        int key = triangle.getTriangleId();

        // Получение экземпляра Warehouse
        Warehouse warehouse = Warehouse.getInstance();

        // Сохранение периметра в Warehouse
        warehouse.put(key, perimeter);
    }
}
