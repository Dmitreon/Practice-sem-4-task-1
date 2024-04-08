package pattern.observer.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pattern.model.Triangle;
import pattern.model.TriangleState;
import pattern.model.Warehouse;
import pattern.observer.TriangleObserver;
import pattern.service.TriangleService;

/**
 Реализация наблюдателя для треугольников
 Отвечает за обновление состояния и периметра треугольника в хранилище при его изменении
 */
public class TriangleObserverImpl implements TriangleObserver {
    private static final Logger LOGGER = LogManager.getLogger(TriangleObserverImpl.class); // Логгер для регистрации действий
    private TriangleService service; // Сервис для работы с треугольниками

    public TriangleObserverImpl(TriangleService service) {
        this.service = service;
    }

    /**
     Вызывается, когда треугольник изменяется
     Обновляет состояние и периметр треугольника в хранилище
     */
    @Override
    public void update(Triangle triangle) {
        LOGGER.debug("Updating triangle state and perimeter in Warehouse");

        // Определение текущего состояния треугольника
        TriangleState state = TriangleState.detect(triangle);

        // Если состояние изменилось, обновляем его в треугольнике без уведомления
        if (triangle.getState() != state) {
            triangle.setStateWithoutNotify(state);
            LOGGER.info("Triangle state changed to {}", state);
        }

        // Если сервис инициализирован, рассчитываем периметр и обновляем его в хранилище
        if (service != null) {
            double perimeter = service.perimeter(triangle);
            int key = triangle.getTriangleId();
            Warehouse warehouse = Warehouse.getInstance();
            warehouse.put(key, perimeter);
            LOGGER.info("Perimeter for triangle ID {} updated in Warehouse", key);
        } else {
            // В случае, если сервис не инициализирован, регистрируем ошибку
            LOGGER.error("TriangleService is not initialized in TriangleObserverImpl");
        }
    }
}
