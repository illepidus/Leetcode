package ru.krotarnya.leetcode.common;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TreeNodeTest {
    private static final TreeNode TEST_NODE = new TreeNode(1, 
            new TreeNode(2 , new TreeNode(3), null), 
            new TreeNode(4, new TreeNode(5), new TreeNode(7)));

    @Test
    void toListInOrderTest() {
        assertEquals(List.of(3, 2, 1, 5, 4, 7), TEST_NODE.toList(TreeNode.Order.IN_ORDER));
    }

    @Test
    void toListPreOrderTest() {
        assertEquals(List.of(1, 2, 3, 4, 5, 7), TEST_NODE.toList(TreeNode.Order.PRE_ORDER));
    }

    @Test
    void toListPostOrderTest() {
        assertEquals(List.of(3, 2, 5, 7, 4, 1), TEST_NODE.toList(TreeNode.Order.POST_ORDER));
    }
    
    @Test
    void subnodeExceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> new TreeNode().subnode(-1, 0));
        assertThrows(IllegalArgumentException.class, () -> new TreeNode().subnode(0, -1));
        
        assertThrows(IllegalArgumentException.class, () -> new TreeNode().subnode(0, 1));
        assertThrows(IllegalArgumentException.class, () -> new TreeNode().subnode(1, 2));
        assertThrows(IllegalArgumentException.class, () -> new TreeNode().subnode(2, 4));
        assertThrows(IllegalArgumentException.class, () -> new TreeNode().subnode(3, 8));

        assertDoesNotThrow(() -> new TreeNode().subnode(0, 0));
        assertDoesNotThrow(() -> new TreeNode().subnode(1, 1));
        assertDoesNotThrow(() -> new TreeNode().subnode(2, 3));
        assertDoesNotThrow(() -> new TreeNode().subnode(3, 7));
    }
    
    @Test
    void depthTest() {
        assertEquals(1, new TreeNode(1).depth());
        assertEquals(2, new TreeNode(1, new TreeNode(2), null).depth());
        assertEquals(2, new TreeNode(1, null, new TreeNode(2)).depth());
        assertEquals(3, new TreeNode(1, new TreeNode(2), new TreeNode(3, null, new TreeNode(4))).depth());
        assertEquals(3, new TreeNode(1, new TreeNode(2, null, new TreeNode(3)), new TreeNode(4)).depth());
    }
}