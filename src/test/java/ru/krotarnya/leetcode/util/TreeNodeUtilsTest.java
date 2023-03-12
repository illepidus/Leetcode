package ru.krotarnya.leetcode.util;

import java.util.List;

import org.junit.jupiter.api.Test;
import ru.krotarnya.leetcode.common.TreeNode;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static ru.krotarnya.leetcode.util.TreeNodeUtils.depth;
import static ru.krotarnya.leetcode.util.TreeNodeUtils.subnode;

class TreeNodeUtilsTest {
    private static final TreeNode TEST_NODE = new TreeNode(1,
            new TreeNode(2 , new TreeNode(3), null),
            new TreeNode(4, new TreeNode(5), new TreeNode(7)));

    @Test
    void testToList() {
        assertEquals(List.of(1, 2, 3, 4, 5, 7), TreeNodeUtils.toList(TEST_NODE, TreeNodeUtils.Order.PRE_ORDER));
        assertEquals(List.of(3, 2, 1, 5, 4, 7), TreeNodeUtils.toList(TEST_NODE, TreeNodeUtils.Order.IN_ORDER));
        assertEquals(List.of(3, 2, 5, 7, 4, 1), TreeNodeUtils.toList(TEST_NODE, TreeNodeUtils.Order.POST_ORDER));
    }

    @Test
    void testDepth() {
        assertEquals(0, depth(null));
        assertEquals(3, depth(TEST_NODE));
    }

    @Test
    void subnodeExceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> subnode(TEST_NODE, -1, 0));
        assertThrows(IllegalArgumentException.class, () -> subnode(TEST_NODE, 0, -1));

        assertThrows(IllegalArgumentException.class, () -> subnode(TEST_NODE, 0, 1));
        assertThrows(IllegalArgumentException.class, () -> subnode(TEST_NODE, 1, 2));
        assertThrows(IllegalArgumentException.class, () -> subnode(TEST_NODE, 2, 4));
        assertThrows(IllegalArgumentException.class, () -> subnode(TEST_NODE, 3, 8));

        assertDoesNotThrow(() -> subnode(TEST_NODE, 0, 0));
        assertDoesNotThrow(() -> subnode(TEST_NODE, 1, 1));
        assertDoesNotThrow(() -> subnode(TEST_NODE, 2, 3));
        assertDoesNotThrow(() -> subnode(TEST_NODE, 3, 7));
    }
}