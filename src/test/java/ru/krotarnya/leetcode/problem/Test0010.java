package ru.krotarnya.leetcode.problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static ru.krotarnya.leetcode.problem.p0010.Solution.isMatch;

class Test0010 {
    @CsvSource({
            "a,a",
            "a,.",
            "a,a*",
            "a,b*a*.*",
            "ab,ab",
            "ab,.*",
            "ab,a.",
            "ab,a.*b.*",
            "ab,c*a*b*c*b",
    })
    @ParameterizedTest
    void testTrue(String string, String pattern) {
        assertTrue(isMatch(string, pattern));
    }

    @CsvSource({
            "a,b",
            "ab,aa",
            "ab,ba",
            "ab,b*a*",
            "ab,.*b*a",
    })
    @ParameterizedTest
    void testFalse(String string, String pattern) {
        assertFalse(isMatch(string, pattern));
    }
    
}