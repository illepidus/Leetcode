package ru.krotarnya.leetcode.problem;

import org.junit.jupiter.api.Test;
import ru.krotarnya.leetcode.common.ListNode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static ru.krotarnya.leetcode.problem.p0002.Solution.addTwoNumbers;

public class Test0002 {
    @Test
    void testPositive() {
        assertEquals(ListNode.of(7, 0, 8), addTwoNumbers(ListNode.of(2, 4, 3), ListNode.of(5, 6, 4)));
        
        assertEquals(ListNode.of(8, 9, 9, 9, 0, 0, 0, 1), 
                addTwoNumbers(ListNode.of(9, 9, 9, 9, 9, 9, 9), ListNode.of(9, 9, 9, 9)));

        assertEquals(ListNode.of(0), addTwoNumbers(ListNode.of(0), ListNode.of(0)));

        assertEquals(ListNode.of(0), addTwoNumbers(null, null));
    }

    @Test
    void testNegative() {
        assertNotEquals(ListNode.of(1), addTwoNumbers(ListNode.of(0), ListNode.of(0)));
        assertNotEquals(ListNode.of(1, 0, 0), addTwoNumbers(ListNode.of(5, 0), ListNode.of(5, 0)));
    }
}
