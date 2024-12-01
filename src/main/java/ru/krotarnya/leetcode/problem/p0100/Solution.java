package ru.krotarnya.leetcode.problem.p0100;

import ru.krotarnya.leetcode.Complexity;
import ru.krotarnya.leetcode.Problem;
import ru.krotarnya.leetcode.Resolution;
import ru.krotarnya.leetcode.common.TreeNode;

/**
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 */
@Problem(id = 100, name = "same-tree", complexity = Complexity.EASY, resolution = Resolution.FAIR)
public class Solution {
    @SuppressWarnings("unused")
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
