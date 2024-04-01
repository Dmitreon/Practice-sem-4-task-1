package pattern.Util;

import pattern.creator.TriangleFactory;
import pattern.model.Triangle;
import pattern.model.Point;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

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

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(resourceUrl.openStream(), StandardCharsets.UTF_8))) {
            return reader.lines()
                    .map(line -> line.trim().split(";\\s*"))
                    .map(this::convertToPoints)
                    .map(triangleFactory::createTriangle)
                    .filter(triangle -> triangle != null)
                    .collect(Collectors.toList());
        }
    }

    private Point[] convertToPoints(String[] parts) {
        return new Point[]{
                createPointFromPart(parts[0]),
                createPointFromPart(parts[1]),
                createPointFromPart(parts[2])
        };
    }

    private Point createPointFromPart(String part) {
        String[] coordinates = part.split(",");
        return new Point(Double.parseDouble(coordinates[0]), Double.parseDouble(coordinates[1]));
    }
}
