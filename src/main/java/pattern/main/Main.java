package pattern.main;

import pattern.creator.impl.TriangleFactoryImpl;
import pattern.Util.FileParser;
import pattern.model.Triangle;
import pattern.model.Warehouse;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        TriangleFactoryImpl triangleFactory = new TriangleFactoryImpl();

        FileParser parser = new FileParser(triangleFactory);

        try {
            List<Triangle> trianglesFromFile = parser.parseTrianglesFromFile();
            System.out.println("Triangles created from file: " + trianglesFromFile.size());
            trianglesFromFile.forEach(System.out::println);
            Warehouse warehouse = Warehouse.getInstance();
            trianglesFromFile.forEach(triangle -> {
                System.out.println("Периметр треугольника с ID " + triangle.getTriangleId() + ": " + warehouse.get(triangle.getTriangleId()));
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
