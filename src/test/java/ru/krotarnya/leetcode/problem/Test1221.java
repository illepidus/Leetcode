package ru.krotarnya.leetcode.problem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static ru.krotarnya.leetcode.problem.p1221.Solution.balancedStringSplit;

/**
 * @author ivblinov
 */
class Test1221 {
    @Test
    @SuppressWarnings("SpellCheckingInspection")
    void test() {
        assertEquals(balancedStringSplit("LR"), 1);
        assertEquals(balancedStringSplit("RLRRLLRLRL"), 4);
        assertEquals(balancedStringSplit("RLRRRLLRLL"), 2);
        assertEquals(balancedStringSplit("LLLLRRRR"), 1);
    }
}