package ru.krotarnya.leetcode.problem;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.krotarnya.leetcode.common.ListNode;
import ru.krotarnya.leetcode.common.TreeNode;
import ru.krotarnya.leetcode.util.ListNodeUtils;
import ru.krotarnya.leetcode.util.TreeNodeUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static ru.krotarnya.leetcode.problem.p0109.Solution.sortedListToBST;
import static ru.krotarnya.leetcode.util.TreeNodeUtils.isBalanced;

public class Test0109 {
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 7, 9, 12, 132})
    void test(int size) {
        test(Stream.iterate(1, i -> i + 1).limit(size).toList());
    }

    void test(List<Integer> list) {
        ListNode listNode = ListNodeUtils.from(list);
        List<Integer> expected = ListNodeUtils.toList(listNode);
        TreeNode treeNode = sortedListToBST(listNode);
        List<Integer> actual = TreeNodeUtils.toList(treeNode, TreeNodeUtils.Order.IN_ORDER);
        assertEquals(expected, actual);
        assertTrue(isBalanced(treeNode));
    }
}
