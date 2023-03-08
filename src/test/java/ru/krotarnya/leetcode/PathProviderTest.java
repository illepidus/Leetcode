package ru.krotarnya.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PathProviderTest {
    private final PathProvider pathProvider = new PathProvider();

    @Test
    void projectPath() {
        assertTrue(pathProvider.projectPath().isAbsolute());
        assertEquals(System.getProperty("user.dir"), pathProvider.projectPath().toString());
    }

    @Test
    void readmePath() {
        assertTrue(pathProvider.readmePath().isAbsolute());
        assertTrue(pathProvider.readmePath().toFile().exists());
    }
}