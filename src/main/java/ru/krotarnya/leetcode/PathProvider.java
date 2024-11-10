package ru.krotarnya.leetcode;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class PathProvider {
    private static final String README_FILENAME = "README.MD";
    private static final String README_TEMPLATE_FILENAME = "readme_template";

    public Path project() {
        return Path.of(System.getProperty("user.dir"));
    }

    public Path readme() {
        return project().resolve(README_FILENAME);
    }

    public Path readmeTemplate() {
        return resource(README_TEMPLATE_FILENAME);
    }

    public Path resource(String resourceName) {
        try {
            return Paths.get(Objects.requireNonNull(Thread.currentThread()
                    .getContextClassLoader()
                    .getResource(resourceName)).toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

}
