package ru.krotarnya.leetcode.problem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static ru.krotarnya.leetcode.problem.p0005.Solution.isPalindrome;
import static ru.krotarnya.leetcode.problem.p0005.Solution.longestPalindrome;

/**
 * @author ivblinov
 */

@SuppressWarnings("SpellCheckingInspection")
class Test0005 {
    @Test
    void test0() {
        assertEquals("", longestPalindrome(""));
    }
    
    @Test
    void test1() {
        assertEquals("a", longestPalindrome("a"));
    }

    @Test
    void test2() {
        assertEquals("bb", longestPalindrome("bb"));
    }

    @Test
    void test3() {
        assertEquals("bab", longestPalindrome("bab"));
        assertEquals("aa", longestPalindrome("baa"));
    }
    
    @Test
    void test4() {
        assertEquals("bb", longestPalindrome("cbbd"));
        assertEquals("zccz", longestPalindrome("zccz"));
    }

    @Test
    void test5() {
        assertEquals("bb", longestPalindrome("abbcd"));
        assertEquals("zccz", longestPalindrome("zcczs"));
        assertEquals("zcacz", longestPalindrome("zcacz"));
    }
    
    @Test
    void isPalindromeTest() {
        assertTrue(isPalindrome(""));
        assertTrue(isPalindrome("a"));
        assertTrue(isPalindrome("aa"));
        assertTrue(isPalindrome("aba"));
        assertTrue(isPalindrome("abba"));
        assertTrue(isPalindrome("abcba"));
        assertTrue(isPalindrome("abccba"));
        assertTrue(isPalindrome("abcdcba"));
        
        assertFalse(isPalindrome("ab"));
        assertFalse(isPalindrome("aab"));
        assertFalse(isPalindrome("abab"));
        assertFalse(isPalindrome("aacba"));
        assertFalse(isPalindrome("aacaba"));
        assertFalse(isPalindrome("abadcba"));
    }
}