package ru.krotarnya.leetcode.problem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.krotarnya.leetcode.problem.p0200.Solution;

public class Test0200 {
    private final Solution islandCounter = new Solution();

    @ValueSource(strings = {
            """
            1100000
            1000000
            0000011
            0000010
            2
            """,
            """
            110001111100
            100001000100
            000001010100
            000001000100
            001111111100
            3
            """,
    })
    @ParameterizedTest
    void test(String data) {
        String[] dataParts = data.split("\n");
        int expected = Integer.parseInt(dataParts[dataParts.length - 1]);
        char[][] grid = new char[dataParts.length - 1][dataParts[0].length()];
        for (int i = 0; i < grid.length; i++) {
            grid[i] = dataParts[i].toCharArray();
        }
        Assertions.assertEquals(expected, islandCounter.numIslands(grid));
    }
}
