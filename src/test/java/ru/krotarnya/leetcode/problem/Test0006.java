package ru.krotarnya.leetcode.problem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.krotarnya.leetcode.problem.p0006.Solution.convert;

/**
 * @author ivblinov
 */
class Test0006 {
    @Test
    void test1() {
        assertEquals("A", convert("A", 1));
        assertEquals("AB", convert("AB", 1));
        assertEquals("ABC", convert("ABC", 1));
    }
    
    @Test
    void test3() {
        assertEquals("PAHNAPLSIIGYIR", convert("PAYPALISHIRING", 3));
    }

    @Test
    void test4() {
        assertEquals("PINALSIGYAHRPI", convert("PAYPALISHIRING", 4));
    }

}