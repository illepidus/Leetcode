package ru.krotarnya.leetcode.problem.p0023;

import java.util.Arrays;
import java.util.PriorityQueue;

import ru.krotarnya.leetcode.Complexity;
import ru.krotarnya.leetcode.Problem;
import ru.krotarnya.leetcode.Resolution;
import ru.krotarnya.leetcode.common.ListNode;

/**
 * <p>You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.</p>
 * <p>Merge all the linked-lists into one sorted linked-list and return it.</p>
 */
@Problem(id = 23, name = "merge-k-sorted-lists", complexity = Complexity.HARD, resolution = Resolution.FAIR)
public class Solution {
    @SuppressWarnings("unused")
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.stream(lists).forEach(node -> {
            while (node != null) {
                pq.add(node.val);
                node = node.next;
            }
        });

        if (pq.isEmpty()) return null;

        ListNode head = new ListNode(pq.poll());
        ListNode next = head;
        while (pq.peek() != null) {
            next.next = new ListNode(pq.poll());
            next = next.next;
        }

        return head;
    }
}
