package ru.krotarnya.leetcode;

import java.nio.file.Path;

public class PathProvider {
    private static final String README_FILENAME = "README.MD";
    public Path projectPath() {
        return Path.of(System.getProperty("user.dir"));
    }
    public Path readmePath() {
        return projectPath().resolve(README_FILENAME);
    }
}
