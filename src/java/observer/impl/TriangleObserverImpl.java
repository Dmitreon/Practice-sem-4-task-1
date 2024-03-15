package java.observer.impl;

import java.model.Triangle;
import java.model.TriangleState;
import java.model.Warehouse;
import java.observer.TriangleObserver;
import java.service.TriangleService;

public class TriangleObserverImpl implements TriangleObserver {
    @Override
    public void update(Triangle triangle) {
        TriangleState state = TriangleState.detect(triangle);
        TriangleService service = new TriangleService();
        double perimeter = service.perimeter(triangle);
        int key = triangle.getTriangleId();
        Warehouse warehouse = Warehouse.getInstance();
        warehouse.put(key, perimeter);

    }
}