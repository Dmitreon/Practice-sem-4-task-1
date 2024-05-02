package pattern.ehu.task1.util;

import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ResourceLoader {
    private static final Logger LOGGER = Logger.getLogger(ResourceLoader.class.getName());

    public static URL getResourceURL(String filename) throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        URL resourceUrl = classLoader.getResource(filename);
        if (resourceUrl == null) {
            LOGGER.log(Level.SEVERE, "Resource file not found: {0}", filename);
            throw new IOException("Resource file not found: " + filename);
        }
        return resourceUrl;
    }
}
