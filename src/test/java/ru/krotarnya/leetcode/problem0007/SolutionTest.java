package ru.krotarnya.leetcode.problem0007;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ivblinov
 */
class SolutionTest {
    @Test
    void test() {
        assertEquals(Solution.reverse(123), 321);
        assertEquals(Solution.reverse(-123), -321);
        assertEquals(Solution.reverse(120), 21);
        assertEquals(Solution.reverse(1999999999), 0);
    }
}