package ru.krotarnya.leetcode.problem1221;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static ru.krotarnya.leetcode.problem1221.Solution.balancedStringSplit;

/**
 * @author ivblinov
 */
class SolutionTest {
    @Test
    @SuppressWarnings("SpellCheckingInspection")
    void test() {
        assertEquals(balancedStringSplit("LR"), 1);
        assertEquals(balancedStringSplit("RLRRLLRLRL"), 4);
        assertEquals(balancedStringSplit("RLRRRLLRLL"), 2);
        assertEquals(balancedStringSplit("LLLLRRRR"), 1);
    }
}