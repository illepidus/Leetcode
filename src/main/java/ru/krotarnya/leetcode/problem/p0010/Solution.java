package ru.krotarnya.leetcode.problem.p0010;

import ru.krotarnya.leetcode.Complexity;
import ru.krotarnya.leetcode.Problem;
import ru.krotarnya.leetcode.Resolution;

/**
 * Я сделяль. Шутка.
 */

@Problem(id = 10, name = "regular-expression-matching", complexity = Complexity.HARD, resolution = Resolution.PASS)
public class Solution {
    public static boolean isMatch(String s, String p) {
        return s.matches(p);
    }
}