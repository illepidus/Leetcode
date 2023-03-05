package ru.krotarnya.leetcode.problem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.krotarnya.leetcode.problem.p0013.Solution.romanToInt;
import static ru.krotarnya.leetcode.problem.p0013.Solution.romanToInt1;
import static ru.krotarnya.leetcode.problem.p0013.Solution.romanToInt2;

class Test0013 {
    @Test
    void test() {
        assertEquals(1, romanToInt("I"));
        assertEquals(5, romanToInt("V"));
        assertEquals(10, romanToInt("X"));
        assertEquals(50, romanToInt("L"));
        assertEquals(100, romanToInt("C"));
        assertEquals(500, romanToInt("D"));
        assertEquals(1000, romanToInt("M"));

        assertEquals(3, romanToInt("III"));
        assertEquals(58, romanToInt("LVIII"));
        assertEquals(1994, romanToInt("MCMXCIV"));

    }

    @Test
    void equalityTest() {
        assertEquals(romanToInt1("I"), romanToInt2("I"));
        assertEquals(romanToInt1("III"), romanToInt2("III"));
        assertEquals(romanToInt1("MCMXCIV"), romanToInt2("MCMXCIV"));
    }
}