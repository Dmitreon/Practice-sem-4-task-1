package pattern.ehu.task1.service;

import pattern.ehu.task1.exception.InvalidTriangleFormatException;

public class TriangleDataValidatorService {

    private static final String POINT_PATTERN = "\\s*\\d+(\\.\\d+)?,\\s*\\d+(\\.\\d+)?\\s*";
    private static final String LINE_DELIMITER = ";\\s*";

    public static void validateTriangleData(String triangleData) throws InvalidTriangleFormatException {
        String[] points = triangleData.split(LINE_DELIMITER);
        if (points.length != 3) {
            throw new InvalidTriangleFormatException("Triangle must have 3 points, found: " + points.length);
        }

        for (String point : points) {
            if (!point.matches(POINT_PATTERN)) {
                throw new InvalidTriangleFormatException("Point does not match expected format: " + point);
            }
        }
    }
}
