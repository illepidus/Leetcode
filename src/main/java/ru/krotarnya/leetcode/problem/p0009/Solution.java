package ru.krotarnya.leetcode.problem.p0009;

import ru.krotarnya.leetcode.Complexity;
import ru.krotarnya.leetcode.Problem;
import ru.krotarnya.leetcode.Resolution;

/**
 * Given an integer x, return true if x is a palindrome, and false otherwise.
 */
@Problem(id = 9, name = "palindrome-number", complexity = Complexity.EASY, resolution = Resolution.FAIR)
public class Solution {
    private static boolean isPalindrome(String x) {
        boolean res = true;
        for (int i = 0; i < x.length() / 2; i++) {
            res &= x.charAt(i) == x.charAt(x.length() - 1 - i);
        }
        return res;
    }

    public static boolean isPalindrome(int x) {
        return isPalindrome(String.valueOf(x));
    }
}
