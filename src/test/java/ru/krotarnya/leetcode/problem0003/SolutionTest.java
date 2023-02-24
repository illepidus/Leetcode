package ru.krotarnya.leetcode.problem0003;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static ru.krotarnya.leetcode.problem0003.Solution.lengthOfLongestSubstring;

/**
 * @author ivblinov
 */
class SolutionTest {
    @Test
    void test() {
        assertEquals(3, lengthOfLongestSubstring("abcabcbb"));
        assertEquals(1, lengthOfLongestSubstring("bbbbb"));
        assertEquals(3, lengthOfLongestSubstring("pwwkew"));
    }
}