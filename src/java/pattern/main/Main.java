package pattern.main;

import pattern.Util.FileParser;
import pattern.creator.TriangleFactory;
import pattern.creator.impl.TriangleFactoryImpl;
import pattern.model.Triangle;
import pattern.model.Warehouse;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        FileParser parser = new FileParser();
        TriangleFactory factory = new TriangleFactoryImpl();

        try {
            List<Triangle> result = parser.parseTrianglesFromFile()
                    .stream()
                    .flatMap(pointsArray -> {
                        int[][] params = new int[][] {
                                { (int) pointsArray[0].distanceTo(pointsArray[1]),
                                        (int) pointsArray[1].distanceTo(pointsArray[2]),
                                        (int) pointsArray[2].distanceTo(pointsArray[0]) }};
                        return factory.createTriangles(params).stream();
                    })
                    .collect(Collectors.toList());

            result.forEach(System.out::println);

            Warehouse warehouse = Warehouse.getInstance();
            result.forEach(triangle -> {
                System.out.println("Периметр треугольника с ID " + triangle.getTriangleId() + ": " + warehouse.get(triangle.getTriangleId()));
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
