package ru.krotarnya.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author ivblinov
 */
public class QuickTest {


    public static void main(String[] args) {
        PriorityQueue<Integer> leftQueue = new PriorityQueue<>(Comparator.comparingInt(x -> -x));
        PriorityQueue<Integer> rightQueue = new PriorityQueue<>(Comparator.comparingInt(x -> x));
        leftQueue.add(2); rightQueue.add(2);
        leftQueue.add(3); rightQueue.add(3);
        leftQueue.add(1); rightQueue.add(1);

        System.out.println(leftQueue.peek());
        System.out.println(rightQueue.peek());

        System.out.println(leftQueue.peek());
        System.out.println(rightQueue.peek());
    }
}
