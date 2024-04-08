package pattern.main;

import pattern.creator.impl.TriangleFactoryImpl;
import pattern.Util.FileParser;
import pattern.model.Triangle;
import pattern.model.Warehouse;
import pattern.model.Point;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        // Инициализируем фабрику для создания треугольников
        TriangleFactoryImpl triangleFactory = new TriangleFactoryImpl();

        // Инициализируем парсер файлов передавая ему фабрику треугольников
        FileParser parser = new FileParser(triangleFactory);

        try {
            // Разбираем файл с данными и создаем список треугольников
            List<Triangle> trianglesFromFile = parser.parseTrianglesFromFile();
            // Выводим количество созданных треугольников
            System.out.println("Triangles created from file: " + trianglesFromFile.size());
            // Выводим информацию
            trianglesFromFile.forEach(System.out::println);

            // Получаем доступ к хранилищу данных
            Warehouse warehouse = Warehouse.getInstance();

            // Выводим периметр
            trianglesFromFile.forEach(triangle -> {
                System.out.println("The perimeter of the triangle with ID " + triangle.getTriangleId() + ": " + warehouse.get(triangle.getTriangleId()));
            });

            // Изменим последний треугольник
            if (!trianglesFromFile.isEmpty()) {
                Triangle lastTriangle = trianglesFromFile.get(trianglesFromFile.size() - 1);

                Point newVertex = new Point(5.0, 0.0); // Новая вершина для изменения треугольника

                lastTriangle.setA(newVertex.distanceTo(new Point(0.0, 0.0)));

                System.out.println("Modified perimeter of the triangle with ID " + lastTriangle.getTriangleId() + ": " + warehouse.get(lastTriangle.getTriangleId()));
            }

        } catch (Exception e) {
            // В случае ошибок во время выполнения, выводим stack trace
            e.printStackTrace();
        }
    }
}
