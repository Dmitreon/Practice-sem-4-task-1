package pattern.ehu.task1.service;

import pattern.ehu.task1.exception.InvalidTriangleFormatException;

public class TriangleDataValidatorService {

    public static void validateTriangleData(String triangleData) throws InvalidTriangleFormatException {
        String[] points = triangleData.split(";\\s*");
        if (points.length != 3) {
            throw new InvalidTriangleFormatException("Triangle must have 3 points, found: " + points.length);
        }

        for (String point : points) {
            if (!point.matches("\\s*\\d+(\\.\\d+)?,\\s*\\d+(\\.\\d+)?\\s*")) {
                throw new InvalidTriangleFormatException("Point does not match expected format: " + point);
            }
        }
    }
}
