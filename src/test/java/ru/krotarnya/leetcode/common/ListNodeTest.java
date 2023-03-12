package ru.krotarnya.leetcode.common;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ListNodeTest {
    @Test
    @SuppressWarnings("DataFlowIssue")
    void testToString() {
        assertEquals(
                List.of(-10, 550, 556, 1562, Integer.MAX_VALUE, Integer.MIN_VALUE, 0).toString(), 
                ListNode.of(-10, 550, 556, 1562, Integer.MAX_VALUE, Integer.MIN_VALUE, 0).toString()
        );
    }

    @Test
    void testNull() {
        assertNull(ListNode.of());
    }

    @Test
    void testEquals() {
        assertEquals(ListNode.of(1, 2, 3, 4), ListNode.of(1, 2, 3, 4));
    }

    @Test
    void testNotEquals() {
        assertNotEquals(ListNode.of(1, 2, 3, 4), ListNode.of(4, 3, 2, 1));
    }
}