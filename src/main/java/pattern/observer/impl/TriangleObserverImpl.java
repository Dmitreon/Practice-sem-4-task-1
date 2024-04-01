package pattern.observer.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pattern.model.Triangle;
import pattern.model.TriangleState;
import pattern.model.Warehouse;
import pattern.observer.TriangleObserver;
import pattern.service.TriangleService;

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
            triangle.setStateWithoutNotify(state);
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
