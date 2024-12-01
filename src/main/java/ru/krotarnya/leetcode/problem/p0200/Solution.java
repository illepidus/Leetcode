package ru.krotarnya.leetcode.problem.p0200;

import ru.krotarnya.leetcode.Complexity;
import ru.krotarnya.leetcode.Problem;
import ru.krotarnya.leetcode.Resolution;

/**
 * <p>Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of
 * islands.</p>
 * <p>An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may
 * assume all four edges of the grid are all surrounded by water.</p>
 */
@Problem(id = 200, name = "number-of-islands", complexity = Complexity.EASY, resolution = Resolution.FAIR)
public class Solution {
    char[][] land;
    int[][] landmarks;
    int currentLandmark;

    public int numIslands(char[][] grid) {
        land = grid;
        landmarks = new int[land.length][land[0].length];

        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == '0') continue;
                if (landmarks[i][j] != 0) continue;
                landmark(i, j, ++currentLandmark);
            }
        }
        return currentLandmark;
    }

    private void landmark(int i, int j, int landmark) {
        landmarks[i][j] = landmark;
        if (i != 0 && land[i - 1][j] == '1' && landmarks[i - 1][j] != landmark)
            landmark(i - 1, j, landmark);
        if (i != landmarks.length - 1 && land[i + 1][j] == '1' && landmarks[i + 1][j] != landmark)
            landmark(i + 1, j, landmark);
        if (j != 0 && land[i][j - 1] == '1' && landmarks[i][j - 1] != landmark)
            landmark(i, j - 1, landmark);
        if (j != landmarks[0].length - 1 && land[i][j + 1] == '1' && landmarks[i][j + 1] != landmark)
            landmark(i, j + 1, landmark);
    }
}
