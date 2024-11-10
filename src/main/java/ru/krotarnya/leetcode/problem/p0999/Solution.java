package ru.krotarnya.leetcode.problem.p0999;

import ru.krotarnya.leetcode.Complexity;
import ru.krotarnya.leetcode.Problem;


@SuppressWarnings("unused")
@Problem(id = 999, name = "available-captures-for-rook", complexity = Complexity.EASY)
public class Solution {
    public int numRookCaptures(char[][] board) {
        Location rook = findRook(board);
        int capture = 0;

        for (int i = rook.x; i >= 0; i--) {
            char c = board[i][rook.y];
            if (c == 'B') break;
            else if (c == 'p') {
                capture++;
                break;
            }
        }

        for (int i = rook.x; i < board.length; i++) {
            char c = board[i][rook.y];
            if (c == 'B') break;
            else if (c == 'p') {
                capture++;
                break;
            }
        }

        for (int j = rook.y; j >= 0; j--) {
            char c = board[rook.x][j];
            if (c == 'B') break;
            else if (c == 'p') {
                capture++;
                break;
            }
        }

        for (int j = rook.y; j < board[rook.x].length; j++) {
            char c = board[rook.x][j];
            if (c == 'B') break;
            else if (c == 'p') {
                capture++;
                break;
            }
        }

        return capture;
    }

    private Location findRook(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'R') return new Location(i, j);
            }
        }
        return new Location(0, 0);
    }

    private record Location(int x, int y) {}
}
