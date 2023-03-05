package ru.krotarnya.leetcode.problem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static ru.krotarnya.leetcode.problem.p0010.Solution.isMatch;

class Test0010 {
    @Test
    void test1() {
        assertTrue(isMatch("", ""));
        assertFalse(isMatch("aa", "a"));
        assertTrue(isMatch("aa", "aa"));
        assertFalse(isMatch("aa", "aaa"));
    }
    
    @Test
    void test2() {
        assertTrue(isMatch("aa", "a*"));
        assertFalse(isMatch("ab", "a*"));
        assertTrue(isMatch("aa", ".*"));
        assertFalse(isMatch("aba", "b.*"));
    }
    
    @Test
    void test3() {
        assertTrue(isMatch("abababa", "a.*b.*a*"));
        assertFalse(isMatch("abababa", "a.*c.*a*"));
        assertTrue(isMatch("aab", "c*a*b"));
        assertTrue(isMatch("aaa", "ab*ac*a"));
    }
}