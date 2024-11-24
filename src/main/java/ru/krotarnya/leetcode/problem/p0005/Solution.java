package ru.krotarnya.leetcode.problem.p0005;

import ru.krotarnya.leetcode.Complexity;
import ru.krotarnya.leetcode.Problem;
import ru.krotarnya.leetcode.Resolution;

/**
 * <p>Given a string s, return the longest palindromic substring in s.</p>
 * <p>Любопытно, что это решение не таймаутит.
 * Я делал когда-то делал очень похожее на C++ и оно таймаутило.
 * Надо бы как-нибудь всё-таки придумать что-то пооптимальнее.</p>
 */

@Problem(id = 5, name = "longest-palindromic-substring", complexity = Complexity.MEDIUM, resolution = Resolution.FAIR)
public class Solution {
    public static String longestPalindrome(String s) {
        if (s.length() < 2) return s;

        int window = s.length();
        while (window > 0) {
            for (int i = 0; i + window <= s.length(); i++) {
                String substring = s.substring(i, i + window);
                if (isPalindrome(substring)) return substring;
            }
            window--;
        }
        return "";
    }

    public static boolean isPalindrome(String s) {
        if (s.length() < 2) return true;

        int i = 0;
        int j = s.length() - 1;
        while (j - i > 0) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
