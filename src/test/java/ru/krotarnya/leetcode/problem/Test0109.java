package ru.krotarnya.leetcode.problem;

import org.junit.jupiter.api.Test;
import ru.krotarnya.leetcode.common.TreeNode;
import ru.krotarnya.leetcode.util.ListNodeUtils;

import static ru.krotarnya.leetcode.problem.p0109.Solution.sortedListToBST;

public class Test0109 {
    private static final TreeNode TEST_NODE = new TreeNode(1,
            new TreeNode(2 , new TreeNode(3), null),
            new TreeNode(4, new TreeNode(5), new TreeNode(7)));
    
    @Test
    void test() {
        System.out.println(sortedListToBST(ListNodeUtils.from(0,1,2,3,4,5,6,7,8,9,10)));
    }
}
