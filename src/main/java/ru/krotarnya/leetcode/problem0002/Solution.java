package ru.krotarnya.leetcode.problem0002;

/**
 * <p>You are given two non-empty linked lists representing two non-negative integers. 
 * The digits are stored in reverse order, and each of their nodes contains a single digit. 
 * Add the two numbers and return the sum as a linked list</p>
 * </p>You may assume the two numbers do not contain any leading zero, except the number 0 itself.</p>
 */

@SuppressWarnings("unused")
class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode first = new ListNode(0);
        ListNode prev = first;
        ListNode node = first;
        while (l1 != null || l2 != null) {
            node.val += (l1 == null) ? 0 : l1.val;
            node.val += (l2 == null) ? 0 : l2.val;
            if (node.val > 9) {
                node.val -= 10;
                node.next = new ListNode(1);
            }
            else {
                node.next = new ListNode(0);
            }
            prev = node;
            node = node.next;
            l1 = (l1 == null) ? null : l1.next;
            l2 = (l2 == null) ? null : l2.next;
        }
        if (node.val == 0) {
            prev.next = null;
        }
        return first;
    }
}