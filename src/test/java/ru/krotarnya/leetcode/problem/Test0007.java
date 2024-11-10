package ru.krotarnya.leetcode.problem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.krotarnya.leetcode.problem.p0007.Solution;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author ivblinov
 */
public class Test0007 {
    @Test
    void test() {
        Assertions.assertEquals(Solution.reverse(123), 321);
        assertEquals(Solution.reverse(-123), -321);
        assertEquals(Solution.reverse(120), 21);
        assertEquals(Solution.reverse(1999999999), 0);
    }
}
