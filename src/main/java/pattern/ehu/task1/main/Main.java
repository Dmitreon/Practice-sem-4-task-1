package pattern.ehu.task1.main;

import pattern.ehu.task1.creator.impl.TriangleFactoryImpl;
import pattern.ehu.task1.filehandling.impl.TriangleFileParserImpl;
import pattern.ehu.task1.model.Triangle;
import pattern.ehu.task1.model.Warehouse;
import pattern.ehu.task1.model.Point;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        TriangleFactoryImpl triangleFactory = new TriangleFactoryImpl();

        TriangleFileParserImpl parser = new TriangleFileParserImpl(triangleFactory);

        try {
            List<Triangle> trianglesFromFile = parser.parseTrianglesFromFile();
            System.out.println("Triangles created from file: " + trianglesFromFile.size());
            trianglesFromFile.forEach(System.out::println);
            Warehouse warehouse = Warehouse.getInstance();
            trianglesFromFile.forEach(triangle -> {
                System.out.println("The perimeter of the triangle with ID " + triangle.getTriangleId() + ": " + warehouse.get(triangle.getTriangleId()));
            });
            if (!trianglesFromFile.isEmpty()) {
                Triangle lastTriangle = trianglesFromFile.get(trianglesFromFile.size() - 1);
                Point newVertex = new Point(5.0, 0.0);
                lastTriangle.setA(newVertex.distanceTo(new Point(0.0, 0.0)));
                System.out.println("Modified perimeter of the triangle with ID " + lastTriangle.getTriangleId() + ": " + warehouse.get(lastTriangle.getTriangleId()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}