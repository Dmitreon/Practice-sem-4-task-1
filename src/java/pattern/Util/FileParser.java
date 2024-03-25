package pattern.Util;

import pattern.model.Point;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileParser {
    private static final String DEFAULT_FILENAME = "src/resources/triangles.txt";

    public List<Point[]> parseTrianglesFromFile() throws IOException {
        List<Point[]> triangles = new ArrayList<>();
        try (Stream<String> lines = Files.lines(Paths.get(DEFAULT_FILENAME))) {
            triangles = lines
                    .map(line -> line.trim().split(";\\s*"))
                    .filter(parts -> parts.length == 6 && areAllDoubles(parts))
                    .map(this::convertToPoints)
                    .filter(this::isValidTriangle)
                    .collect(Collectors.toList());
        }
        return triangles;
    }

    private boolean areAllDoubles(String[] parts) {
        try {
            for (String part : parts) {
                Double.parseDouble(part);
            }
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private Point[] convertToPoints(String[] parts) {
        return new Point[] {
                new Point(Double.parseDouble(parts[0]), Double.parseDouble(parts[1])),
                new Point(Double.parseDouble(parts[2]), Double.parseDouble(parts[3])),
                new Point(Double.parseDouble(parts[4]), Double.parseDouble(parts[5]))
        };
    }

    private boolean isValidTriangle(Point[] points) {
        double a = points[0].distanceTo(points[1]);
        double b = points[1].distanceTo(points[2]);
        double c = points[2].distanceTo(points[0]);
        return (a + b > c) && (a + c > b) && (b + c > a);
    }
}
