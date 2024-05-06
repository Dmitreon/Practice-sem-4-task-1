package pattern;

import org.junit.jupiter.api.Test;
import pattern.ehu.task1.creator.impl.TriangleFactoryImpl;
import pattern.ehu.task1.filehandling.impl.TriangleFileParserImpl;
import pattern.ehu.task1.model.Triangle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FileParserImplTest {

    @Test
    public void testParseTrianglesFromFile() {
        TriangleFactoryImpl factory = new TriangleFactoryImpl();
        TriangleFileParserImpl parser = new TriangleFileParserImpl(factory);
        try {
            List<Triangle> triangles = parser.parseTrianglesFromFile();
            assertEquals(6, triangles.size());
        } catch (IOException e) {
            fail("IOException was thrown");
        }
    }

    @Test
    public void testProcessLineValid() {
        TriangleFactoryImpl factory = new TriangleFactoryImpl();
        TriangleFileParserImpl parser = new TriangleFileParserImpl(factory);
        List<Triangle> triangles = new ArrayList<>();
        try {
            parser.processLine(triangles, "0.0,0.0; 3.0,0.0; 0.0,4.0");
            assertEquals(1, triangles.size());
        } catch (Exception e) {
            fail("Exception was thrown");
        }
    }

    @Test
    public void testProcessLineInvalid() {
        TriangleFactoryImpl factory = new TriangleFactoryImpl();
        TriangleFileParserImpl parser = new TriangleFileParserImpl(factory);
        List<Triangle> triangles = new ArrayList<>();
        try {
            parser.processLine(triangles, "0.0,0.0w; 2.0,0.0; 1.0,2.0");
            assertEquals(0, triangles.size());
        } catch (Exception e) {
            fail("Exception was thrown");
        }
    }
}
