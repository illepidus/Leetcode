package ru.krotarnya.leetcode.problem.p0109;

import java.util.Objects;

import ru.krotarnya.leetcode.Complexity;
import ru.krotarnya.leetcode.Problem;
import ru.krotarnya.leetcode.Resolution;
import ru.krotarnya.leetcode.common.ListNode;
import ru.krotarnya.leetcode.common.TreeNode;

@SuppressWarnings("unused")
@Problem(id = 109, name = "convert-sorted-list-to-binary-search-tree", complexity = Complexity.MEDIUM, resolution = Resolution.NONE)
public class Solution {
    public static TreeNode sortedListToBST(ListNode head) {
        if (Objects.isNull(head)) return null;
            
        DoubleLinkedListNode doubleLinkedHead = DoubleLinkedListNode.from(null, head);
        DoubleLinkedListNode doubleLinkedMedian = doubleLinkedHead.median();
        TreeNode treeNodeHead = new TreeNode(doubleLinkedMedian.val);
        
        DoubleLinkedListNode prev = doubleLinkedMedian.prev;
        DoubleLinkedListNode next = doubleLinkedMedian.next;

        while (Objects.nonNull(prev) || Objects.nonNull(next)) {
            if (Objects.nonNull(prev)) {
                addNodeBST(treeNodeHead, prev.val);
                prev = prev.prev;
            }

            if (Objects.nonNull(next)) {
                addNodeBST(treeNodeHead, next.val);
                next = next.next;
            }
        }

        return treeNodeHead;
    }
    
    public static void addNodeBST(TreeNode treeNode, int val) {
        if (val < treeNode.val) {
            if (Objects.isNull(treeNode.left)) {
                treeNode.left = new TreeNode(val);
                return;
            }
            addNodeBST(treeNode.left, val);
        }
        else {
            if (Objects.isNull(treeNode.right)) {
                treeNode.right = new TreeNode(val);
                return;
            }
            addNodeBST(treeNode.right, val);
        }
    }
    
    private static class DoubleLinkedListNode {
        DoubleLinkedListNode prev;
        DoubleLinkedListNode next;
        int val;

        private DoubleLinkedListNode first() {
            DoubleLinkedListNode node = this;
            while (node.prev != null) node = node.prev;
            
            return node;
        }
        
        private int size() {
            DoubleLinkedListNode node = first();
            
            int size = 1;
            while (node.next != null) {
                node = node.next;
                size++;
            }
            return size;
        }
        
        public DoubleLinkedListNode median() {
            DoubleLinkedListNode node = first();
            int size = first().size();
            for (int i = 0; i < size / 2; i++) node = node.next;
            return node;
        }
        
        private DoubleLinkedListNode(int val, DoubleLinkedListNode prev, DoubleLinkedListNode next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }

        private DoubleLinkedListNode(int val) {
            this.val = val;
        }
        
        public static DoubleLinkedListNode from(DoubleLinkedListNode prevNode, ListNode listNode) {
            if (listNode == null) return null;
            DoubleLinkedListNode thisNode = new DoubleLinkedListNode(listNode.val, prevNode, null);
            thisNode.next = from(thisNode, listNode.next);
            return thisNode;
        }
        
        public static DoubleLinkedListNode from(ListNode listNode) {
            return from(null, listNode);
        }
    }
}
