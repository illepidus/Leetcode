package ru.krotarnya.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PathProviderTest {
    private final PathProvider pathProvider = new PathProvider();

    @Test
    void projectPath() {
        assertTrue(pathProvider.project().isAbsolute());
        assertEquals(System.getProperty("user.dir"), pathProvider.project().toString());
    }

    @Test
    void readmePath() {
        assertTrue(pathProvider.readme().isAbsolute());
        assertTrue(pathProvider.readme().toFile().exists());
    }
}