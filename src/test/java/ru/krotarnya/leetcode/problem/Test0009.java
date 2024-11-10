package ru.krotarnya.leetcode.problem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.krotarnya.leetcode.problem.p0009.Solution;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Test0009 {
    @Test
    void test() {
        Assertions.assertFalse(Solution.isPalindrome(-1001));
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
