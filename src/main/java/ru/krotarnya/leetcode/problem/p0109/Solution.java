package ru.krotarnya.leetcode.problem.p0109;

import ru.krotarnya.leetcode.Complexity;
import ru.krotarnya.leetcode.Problem;
import ru.krotarnya.leetcode.Resolution;
import ru.krotarnya.leetcode.common.ListNode;
import ru.krotarnya.leetcode.common.TreeNode;

@Problem(id = 109, name = "convert-sorted-list-to-binary-search-tree", complexity = Complexity.MEDIUM, resolution = Resolution.FAIR)
public class Solution {
    public static TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);

        ListNode slow = head, fast = head.next.next;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        TreeNode result = new TreeNode(slow.next.val);
        ListNode rightList = slow.next.next;
        slow.next = null;
        
        result.left = sortedListToBST(head);
        result.right = sortedListToBST(rightList);
        
        return result;
    }
}
