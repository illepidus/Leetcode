package ru.krotarnya.leetcode.problem;

import org.junit.jupiter.api.Test;
import ru.krotarnya.leetcode.common.ListNode;
import ru.krotarnya.leetcode.util.ListNodeUtils;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static ru.krotarnya.leetcode.problem.p0002.Solution.addTwoNumbers;
import static ru.krotarnya.leetcode.util.ListNodeUtils.from;

public class Test0002 {
    @Test
    void testPositive() {
        assertTrue(equals(from(0), null, null));
        assertTrue(equals(from(0), from(0), from(0)));
        assertTrue(equals(from(7, 0, 8), from(2, 4, 3), from(5, 6, 4)));
        assertTrue(equals(from(0, 1), from(5, 0), from(5, 0)));
        assertTrue(equals(from(8, 9, 9, 9, 0, 0, 0, 1),
                from(9, 9, 9, 9, 9, 9, 9), from(9, 9, 9, 9)));
    }

    @Test
    void testNegative() {
        assertFalse(equals(from(1), from(0), from(0)));
        assertFalse(equals(from(1, 0, 0), from(5, 0), from(5, 0)));
    }
    
    boolean equals(ListNode first, ListNode other1, ListNode other2) {
        return ListNodeUtils.equals(first, addTwoNumbers(other1, other2));
    }
}
