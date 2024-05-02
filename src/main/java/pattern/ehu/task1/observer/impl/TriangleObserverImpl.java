package pattern.ehu.task1.observer.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pattern.ehu.task1.model.Triangle;
import pattern.ehu.task1.model.TriangleState;
import pattern.ehu.task1.model.Warehouse;
import pattern.ehu.task1.observer.TriangleObserver;
import pattern.ehu.task1.service.TriangleService;

public class TriangleObserverImpl implements TriangleObserver {
    private static final Logger LOGGER = LogManager.getLogger(TriangleObserverImpl.class);
    private TriangleService service;

    public TriangleObserverImpl(TriangleService service) {
        this.service = service;
    }

    @Override
    public void update(Triangle triangle) {
        LOGGER.debug("Updating triangle state and perimeter in Warehouse");

        TriangleState state = TriangleState.detect(triangle);

        if (triangle.getState() != state) {
            LOGGER.info("Triangle state changed to {}", state);
        }

        if (service != null) {
            double perimeter = service.perimeter(triangle);
            int key = triangle.getTriangleId();
            Warehouse warehouse = Warehouse.getInstance();
            warehouse.put(key, perimeter);
            LOGGER.info("Perimeter for triangle ID {} updated in Warehouse", key);
        } else {
            LOGGER.error("TriangleService is not initialized in TriangleObserverImpl");
        }
    }
}
