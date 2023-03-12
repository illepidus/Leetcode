package ru.krotarnya.leetcode.util;

import java.util.List;

import org.junit.jupiter.api.Test;
import ru.krotarnya.leetcode.common.ListNode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static ru.krotarnya.leetcode.util.ListNodeUtils.from;
import static ru.krotarnya.leetcode.util.ListNodeUtils.size;
import static ru.krotarnya.leetcode.util.ListNodeUtils.toList;

class ListNodeUtilsTest {
    private static final ListNode TEST_NODE = new ListNode(1, new ListNode(2, new ListNode(3)));
    @Test
    void testToList() {
        assertEquals(List.of(), toList(null));
        assertEquals(List.of(1, 2 ,3), toList(TEST_NODE));
    }

    @Test
    void testToString() {
        assertEquals("[1, 2, 3]", ListNodeUtils.toString(TEST_NODE));
    }

    @Test
    void testEquals() {
        assertTrue(ListNodeUtils.equals(null, from()));
        assertFalse(ListNodeUtils.equals(TEST_NODE, from()));

        assertTrue(ListNodeUtils.equals(TEST_NODE, from(1, 2, 3)));
        assertFalse(ListNodeUtils.equals(TEST_NODE, from(3, 2, 1)));

        assertTrue(ListNodeUtils.notEquals(TEST_NODE, from(3, 2, 1)));
        assertFalse(ListNodeUtils.notEquals(TEST_NODE, from(1, 2, 3)));
    }
    
    @Test
    void testSize() {
        assertEquals(3, size(TEST_NODE));
    }
}