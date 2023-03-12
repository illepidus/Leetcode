package ru.krotarnya.leetcode.common;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@SuppressWarnings("unused")
public class ListNode implements Iterator<ListNode> {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

        
    
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        
        return this.toString().equals(other.toString());
    }

    @Override
    public String toString() {
        return toList().toString();
    }
    
    public List<Integer> toList() {
        List<Integer> list = new ArrayList<>();
        var node = this;

        while (Objects.nonNull(node)) {
            list.add(node.val);
            node = node.next;
        }
        
        return list;
    }
        
    public static ListNode of(int ... val) {
        if (val.length == 0) return null;
        
        ListNode head = new ListNode(val[0]);
        ListNode node = head;
        
        for (int i = 1; i < val.length; i++) {
            node.next = new ListNode(val[i]);
            node = node.next;
        }
        
        return head;
    }

    @Override
    public boolean hasNext() {
        return Objects.nonNull(next);
    }

    @Override
    public ListNode next() {
        return next;
    }
}
