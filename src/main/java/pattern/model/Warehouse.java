package pattern.model;

import java.util.HashMap;
import java.util.StringJoiner;

/**
 Хранилище для хранения и доступа к данным треугольников
 */
public class Warehouse {
    // Единственный экземпляр класса.
    private static Warehouse instance = new Warehouse();

    // Карта для хранения данных треугольников. Ключ - ID треугольника, значение - его периметр.
    private HashMap<Integer, Double> map = new HashMap<>();

    // Приватный конструктор предотвращает создание экземпляров класса извне.
    private Warehouse() {
    }

    /**
     Возвращает единственный экземпляр класса Warehouse
     */
    public static Warehouse getInstance() {
        return instance;
    }

    /**
     Получает значение периметра треугольника по его ID
     */
    public Double get(Integer key) {
        return map.get(key);
    }

    /**
     Сохраняет или обновляет значение периметра треугольника по его ID
     */
    public Double put(Integer key, Double value) {
        return map.put(key, value);
    }

    /**
     Возвращает строковое представление объекта Warehouse
     */
    @Override
    public String toString() {
        return new StringJoiner(", ", Warehouse.class.getSimpleName() + "[", "]")
                .add("map=" + map)
                .toString();
    }
}
