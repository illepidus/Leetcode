package ru.krotarnya.leetcode.problem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.krotarnya.leetcode.problem.p0200.Solution;

public class Test0200 {
    private final Solution islandCounter = new Solution();

    @ValueSource(strings = {
            """
            0000
            0000
            0000
            0
            """,
            """
            1001
            1111
            1001
            1
            """,
            """
            1111000
            1001000
            0001011
            0000010
            2
            """,
            """
            111001111100
            100001000111
            010001010100
            010001000100
            001111111100
            4
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
