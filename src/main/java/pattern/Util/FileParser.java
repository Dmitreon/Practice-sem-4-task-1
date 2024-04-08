package pattern.Util;

import pattern.creator.TriangleFactory;
import pattern.exception.InvalidTriangleFormatException;
import pattern.model.Point;
import pattern.model.Triangle;
import pattern.service.TriangleDataValidatorService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class FileParser {
    private static final String DEFAULT_FILENAME = "triangles.txt";
    private final TriangleFactory triangleFactory;

    public FileParser(TriangleFactory triangleFactory) {
        this.triangleFactory = triangleFactory;
    }

    public List<Triangle> parseTrianglesFromFile() throws IOException {
        URL resourceUrl = getClass().getClassLoader().getResource(DEFAULT_FILENAME);
        if (resourceUrl == null) {
            throw new IOException("Resource file not found: " + DEFAULT_FILENAME);
        }

        List<Triangle> triangles = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(resourceUrl.openStream(), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    TriangleDataValidatorService.validateTriangleData(line);
                    Point[] points = convertToPoints(line.trim().split(";\\s*"));
                    Triangle triangle = triangleFactory.createTriangle(points);
                    if (triangle != null) {
                        triangles.add(triangle);
                    }
                } catch (InvalidTriangleFormatException e) {
                    System.err.println("Error processing line: " + line + " - " + e.getMessage());
                }
            }
        }
        return triangles;
    }

    private Point[] convertToPoints(String[] parts) {
        if (parts.length != 3) {
            throw new IllegalArgumentException("Each line must contain 3 points to form a Triangle.");
        }
        Point[] points = new Point[3];
        for (int i = 0; i < 3; i++) {
            points[i] = createPointFromPart(parts[i]);
        }
        return points;
    }

    private Point createPointFromPart(String part) {
        String[] coordinates = part.split(",");
        if (coordinates.length != 2) {
            throw new IllegalArgumentException("Each part must contain 2 coordinates to form a Point.");
        }
        double x = Double.parseDouble(coordinates[0].trim());
        double y = Double.parseDouble(coordinates[1].trim());
        return new Point(x, y);
    }
}
