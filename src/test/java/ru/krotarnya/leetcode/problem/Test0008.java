package ru.krotarnya.leetcode.problem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.krotarnya.leetcode.problem.p0008.Solution.myAtoi;

/**
 * @author ivblinov
 */
class Test0008 {
    @Test
    void test0() {
        assertEquals(0, myAtoi("a-10000dz"));
        assertEquals(0, myAtoi("a+10000dz"));
        assertEquals(0, myAtoi("a10000"));
    }
    
    @Test
    void test1() {
        assertEquals(10000,  myAtoi("10000"));
        assertEquals(-10000, myAtoi("-10000"));
        assertEquals(10000,  myAtoi("+10000"));
        assertEquals(10000,  myAtoi(" 10000"));
        assertEquals(10000,  myAtoi(" 10000dz"));
        assertEquals(-10000, myAtoi(" -10000dz"));
    }

    @Test
    void test2() {
        assertEquals(Integer.MAX_VALUE, myAtoi("999999999999999"));
        assertEquals(Integer.MIN_VALUE, myAtoi("-99999999999999"));
    }
}