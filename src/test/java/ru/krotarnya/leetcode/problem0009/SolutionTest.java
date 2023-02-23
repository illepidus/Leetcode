package ru.krotarnya.leetcode.problem0009;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    void test() {
        assertFalse(Solution.isPalindrome(-1001));
        assertFalse(Solution.isPalindrome(-101));
        assertFalse(Solution.isPalindrome(-1));
        assertTrue(Solution.isPalindrome(0));
        assertFalse(Solution.isPalindrome(100));
        assertTrue(Solution.isPalindrome(101));
        assertTrue(Solution.isPalindrome(1001));
        assertFalse(Solution.isPalindrome(1011));
        assertTrue(Solution.isPalindrome(10101));
        assertTrue(Solution.isPalindrome(10001));
        assertFalse(Solution.isPalindrome(100101));
    }
}