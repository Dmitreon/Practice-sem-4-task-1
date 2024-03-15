package java.Util;

import java.model.Point;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileParser {
    public List<Point[]> parseTrianglesFromFile(String filePath) throws IOException {
        List<Point[]> triangles = new ArrayList<>();
        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            triangles = lines.map(line -> {
                String[] points = line.split(";\\s*");
                return new Point[] {
                        new Point(Double.parseDouble(points[0]), Double.parseDouble(points[1])),
                        new Point(Double.parseDouble(points[2]), Double.parseDouble(points[3])),
                        new Point(Double.parseDouble(points[4]), Double.parseDouble(points[5]))
                };
            }).collect(Collectors.toList());
        }
        return triangles;
    }
}

