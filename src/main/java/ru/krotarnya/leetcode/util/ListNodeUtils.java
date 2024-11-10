package ru.krotarnya.leetcode.util;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import ru.krotarnya.leetcode.common.ListNode;

public class ListNodeUtils {
    public static LinkedList<Integer> toList(ListNode node) {
        LinkedList<Integer> list = new LinkedList<>();

        while (Objects.nonNull(node)) {
            list.add(node.val);
            node = node.next;
        }

        return list;
    }

    public static String toString(ListNode node) {
        return toList(node).toString();
    }

    public static ListNode from(List<Integer> list) {
        if (list.isEmpty()) return null;

        ListNode head = new ListNode(list.get(0));
        ListNode node = head;
        for (int i = 1; i < list.size(); i++) {
            node.next = new ListNode(list.get(i));
            node = node.next;
        }
        return head;
    }

    public static ListNode from(int... values) {
        return from(Arrays.stream(values).boxed().toList());
    }

    public static boolean equals(ListNode first, ListNode second) {
        return toList(first).equals(toList(second));
    }

    public static boolean notEquals(ListNode first, ListNode second) {
        return !equals(first, second);
    }

    public static int size(ListNode node) {
        return toList(node).size();
    }
}
