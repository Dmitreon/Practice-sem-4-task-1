package pattern.ehu.task1.filehandling;

import pattern.ehu.task1.exception.InvalidTriangleFormatException;
import pattern.ehu.task1.model.Triangle;

import java.io.IOException;
import java.util.List;

public interface FileParser {
    List<Triangle> parseTrianglesFromFile() throws IOException;
    void processLine(List<Triangle> triangles, String line) throws InvalidTriangleFormatException;
}
