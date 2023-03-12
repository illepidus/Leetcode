package ru.krotarnya.leetcode.problem.p0109;

import java.util.LinkedList;
import java.util.List;
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
        LinkedList<ListNode> list = createLinkedList(head);
        List<ListNode> left = list.subList(0, list.size() / 2);
        List<ListNode> right = list.subList(list.size() / 2 + 1, list.size());
        return null;
    }
    
    public static void addNode(TreeNode treeNode, int val, int balance) {
        if (val < treeNode.val) {
            //go left
            if (Objects.isNull(treeNode.left)) {
                treeNode.left = new TreeNode(val);
                return;
            }
            addNode(treeNode.left, val, balance - 1);
        }
        else {
            //go right
            if (Objects.isNull(treeNode.right)) {
                treeNode.right = new TreeNode(val);
                return;
            }
            addNode(treeNode.right, val, balance + 1);
        }
    }
    
    public static LinkedList<ListNode> createLinkedList(ListNode head) {
        LinkedList<ListNode> list = new LinkedList<>();
        
        while (head != null) {
            list.addLast(head);
            head = head.next;
        }
        
        return list;
    }
}
