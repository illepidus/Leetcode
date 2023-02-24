package ru.krotarnya.leetcode.problem1221;

import ru.krotarnya.leetcode.Problem;

/**
 * <p>Balanced strings are those that have an equal quantity of 'L' and 'R' characters.</p>
 * <p>Given a balanced string s, split it into some number of substrings such that:</p>
 * <p>Each substring is balanced.</p>
 * <p>Return the maximum number of balanced strings you can obtain.</p>
 */
@Problem(id = 1221, name = "split-a-string-in-balanced-strings")
public class Solution {
    public static int balancedStringSplit(String s) {
        int balance = 0;
        int result = 0;
        for (char c: s.toCharArray()) {
            if (c == 'L') balance--;
            if (c == 'R') balance++;
            if (balance == 0) result++;
        }
        return result;
    }
}