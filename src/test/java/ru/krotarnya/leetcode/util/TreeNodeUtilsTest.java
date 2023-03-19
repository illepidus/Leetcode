package ru.krotarnya.leetcode.util;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import ru.krotarnya.leetcode.common.TreeNode;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static ru.krotarnya.leetcode.util.TreeNodeUtils.depth;
import static ru.krotarnya.leetcode.util.TreeNodeUtils.isBalanced;
import static ru.krotarnya.leetcode.util.TreeNodeUtils.isBinarySearchTree;
import static ru.krotarnya.leetcode.util.TreeNodeUtils.size;
import static ru.krotarnya.leetcode.util.TreeNodeUtils.subnode;

class TreeNodeUtilsTest {
    private static final TreeNode TEST_EMPTY_NODE = new TreeNode();
    private static final TreeNode TEST_SINGLE_NODE = new TreeNode(1);
    private static final TreeNode TEST_NODE = new TreeNode(1,
            new TreeNode(2 , new TreeNode(3), null),
            new TreeNode(4, new TreeNode(5), new TreeNode(7)));

    private static final TreeNode TEST_BST_NODE = new TreeNode(8,
            new TreeNode(3 , new TreeNode(1), null),
            new TreeNode(10, new TreeNode(9), new TreeNode(14)));

    private static final TreeNode TEST_UNBALANCED_SHORT_NODE = new TreeNode(1,
            new TreeNode(2 , new TreeNode(3), null), null);

    private static final TreeNode TEST_UNBALANCED_LONG_NODE = new TreeNode(1,
            new TreeNode(2 , new TreeNode(3, new TreeNode(4, new TreeNode(5), null), null), null), null);

    @Test
    void testToList() {
        assertEquals(List.of(1, 2, 3, 4, 5, 7), TreeNodeUtils.toList(TEST_NODE, TreeNodeUtils.Order.PRE_ORDER));
        assertEquals(List.of(3, 2, 1, 5, 4, 7), TreeNodeUtils.toList(TEST_NODE, TreeNodeUtils.Order.IN_ORDER));
        assertEquals(List.of(3, 2, 5, 7, 4, 1), TreeNodeUtils.toList(TEST_NODE, TreeNodeUtils.Order.POST_ORDER));
        
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2); expected.add(4);
        expected.add(3); expected.add(5); expected.add(null); expected.add(7);
        
        assertEquals(expected, TreeNodeUtils.toList(TEST_NODE, TreeNodeUtils.Order.NATURAL_ORDER));
    }

    @Test
    void testSize() {
        assertEquals(0, size(null));
        assertEquals(1, size(TEST_EMPTY_NODE));
        assertEquals(1, size(TEST_SINGLE_NODE));
        assertEquals(6, size(TEST_NODE));
        assertEquals(6, size(TEST_BST_NODE));
        assertEquals(3, size(TEST_UNBALANCED_SHORT_NODE));
        assertEquals(5, size(TEST_UNBALANCED_LONG_NODE));
    }
    
    @Test
    void testDepth() {
        assertEquals(0, depth(null));
        assertEquals(1, depth(TEST_EMPTY_NODE));
        assertEquals(1, depth(TEST_SINGLE_NODE));
        assertEquals(3, depth(TEST_NODE));
        assertEquals(3, depth(TEST_BST_NODE));
        assertEquals(3, depth(TEST_UNBALANCED_SHORT_NODE));
        assertEquals(5, depth(TEST_UNBALANCED_LONG_NODE));
    }

    @Test
    void testSubnodeException() {
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
    
    @Test 
    void testIsBST() {
        assertTrue(isBinarySearchTree(null));
        assertTrue(isBinarySearchTree(TEST_SINGLE_NODE));
        assertTrue(isBinarySearchTree(TEST_EMPTY_NODE));
        assertTrue(isBinarySearchTree(TEST_BST_NODE));
        assertFalse(isBinarySearchTree(TEST_UNBALANCED_SHORT_NODE));
        assertFalse(isBinarySearchTree(TEST_UNBALANCED_LONG_NODE));
    }

    @Test
    void testIsBalanced() {
        assertTrue(isBalanced(null));
        assertTrue(isBalanced(TEST_EMPTY_NODE));
        assertTrue(isBalanced(TEST_SINGLE_NODE));
        assertTrue(isBalanced(TEST_NODE));
        assertTrue(isBalanced(TEST_BST_NODE));
        assertFalse(isBalanced(TEST_UNBALANCED_SHORT_NODE));
        assertFalse(isBalanced(TEST_UNBALANCED_LONG_NODE));
    }

    @Test
    void testToString() {
        assertEquals("", TreeNodeUtils.toString(null));
        assertEquals("0", TreeNodeUtils.toString(TEST_EMPTY_NODE));
        assertEquals("1", TreeNodeUtils.toString(TEST_SINGLE_NODE));
        assertEquals("1\n2 4\n3 5 _ 7", TreeNodeUtils.toString(TEST_NODE));
        assertEquals("8\n3 10\n1 9 _ 14", TreeNodeUtils.toString(TEST_BST_NODE));
        assertEquals("1\n2 _\n3 _ _ _", TreeNodeUtils.toString(TEST_UNBALANCED_SHORT_NODE));
    }
}