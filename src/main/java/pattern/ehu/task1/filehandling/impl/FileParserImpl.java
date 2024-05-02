package pattern.ehu.task1.filehandling.impl;

import pattern.ehu.task1.creator.TriangleFactory;
import pattern.ehu.task1.exception.InvalidTriangleFormatException;
import pattern.ehu.task1.filehandling.FileParser;
import pattern.ehu.task1.model.Point;
import pattern.ehu.task1.model.Triangle;
import pattern.ehu.task1.service.TriangleDataValidatorService;
import pattern.ehu.task1.util.ResourceLoader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileParserImpl implements FileParser {
    private static final String DEFAULT_FILENAME = "triangles.txt";
    private static final String LINE_DELIMITER = ";\\s*";
    private static final String COORDINATE_DELIMITER = ",";
    private static final int POINTS_PER_TRIANGLE = 3;
    private final TriangleFactory triangleFactory;
    private static final Logger LOGGER = Logger.getLogger(FileParserImpl.class.getName());

    public FileParserImpl(TriangleFactory triangleFactory) {
        this.triangleFactory = triangleFactory;
    }

    @Override
    public List<Triangle> parseTrianglesFromFile() throws IOException {
        URL resourceUrl = ResourceLoader.getResourceURL(DEFAULT_FILENAME);

        List<Triangle> triangles = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(resourceUrl.openStream(), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                processLine(triangles, line);
            }
        } catch (InvalidTriangleFormatException e) {
            throw new RuntimeException(e);
        }
        return triangles;
    }

    @Override
    public void processLine(List<Triangle> triangles, String line) throws InvalidTriangleFormatException {
        try {
            TriangleDataValidatorService.validateTriangleData(line);
            Point[] points = convertToPoints(line.trim().split(LINE_DELIMITER));
            Triangle triangle = triangleFactory.createTriangle(points);
            if (triangle != null) {
                triangles.add(triangle);
            }
        } catch (InvalidTriangleFormatException e) {
            LOGGER.log(Level.INFO, "Error processing line: {0} - {1}", new Object[]{line, e.getMessage()});
        }
    }

    private Point[] convertToPoints(String[] parts) {
        if (parts.length != POINTS_PER_TRIANGLE) {
            throw new IllegalArgumentException("Each line must contain " + POINTS_PER_TRIANGLE + " points to form a Triangle.");
        }
        Point[] points = new Point[POINTS_PER_TRIANGLE];
        for (int i = 0; i < POINTS_PER_TRIANGLE; i++) {
            points[i] = createPointFromPart(parts[i]);
        }
        return points;
    }

    private Point createPointFromPart(String part) {
        String[] coordinates = part.split(COORDINATE_DELIMITER);
        if (coordinates.length != 2) {
            throw new IllegalArgumentException("Each part must contain 2 coordinates to form a Point.");
        }
        double x = Double.parseDouble(coordinates[0].trim());
        double y = Double.parseDouble(coordinates[1].trim());
        return new Point(x, y);
    }
}
