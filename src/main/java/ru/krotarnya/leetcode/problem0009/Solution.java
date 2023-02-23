package ru.krotarnya.leetcode.problem0009;

public class Solution {
    private static boolean isPalindrome(String x) {
        boolean res = true;
        for (int i = 0; i < x.length() / 2; i++) {
            res  &= x.charAt(i) == x.charAt(x.length() - 1 - i);
        }
        return res;
    }

    public static boolean isPalindrome(int x) {
        return isPalindrome(String.valueOf(x));
    }
}
