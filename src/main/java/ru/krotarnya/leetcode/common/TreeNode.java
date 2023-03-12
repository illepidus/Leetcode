package ru.krotarnya.leetcode.common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * <p>Further methods are not allowed to use in Solution classes as they are custom.</p>
     * <p>Implemented for the ease of testing</p>
     */
    
    public List<Integer> toList(Order order) {
        return switch (order) {
            case IN_ORDER -> toListInOrder();
            case PRE_ORDER -> toListPreOrder();
            case POST_ORDER -> toListPostOrder();
            case NATURAL_ORDER -> toListNaturalOrder();
        };
    }

    public int depth() {
        return depth(0) + 1;
    }

    public Map<Integer, List<Integer>> toMap() {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int level = 0; level < depth(); level++) {
            List<Integer> list = new ArrayList<>();
            int limit = 1; for (int i = 0; i < level; i++)
                limit *= 2;

            for (int position = 0; position < limit; position++) {
                TreeNode node = subnode(level, position);
                list.add(Objects.nonNull(node)
                        ? node.val
                        : null
                );
            }
            map.put(level, list);
        }

        return map;
    }

    public TreeNode subnode(int level, int position) {
        if (!subnodeAddressValid(level, position))
            throw new IllegalArgumentException("Bad subnode address [" + level + "; " + position + "]");

        TreeNode subnode = this;
        for (int i = 0; i < level; i++) {
            subnode = ((position & 1) == 0)
                    ? subnode.left
                    : subnode.right;

            if (subnode == null)
                return null;

            position = position >> 1;
        }

        return subnode;
    }

    @Override
    public String toString() {
        return toMap()
                .values()
                .stream()
                .map(List::toString)
                .collect(Collectors.joining("\n"));
    }

    @SuppressWarnings("unused")
    public String toString(Order order) {
        return toList(order).toString();
    }
    
    private List<Integer> toListInOrder() {
        List<Integer> list = new ArrayList<>();
        if (Objects.nonNull(left)) list.addAll(left.toListInOrder());
        list.add(val);
        if (Objects.nonNull(right)) list.addAll(right.toListInOrder());
        return list;
    }

    private List<Integer> toListPreOrder() {
        List<Integer> list = new ArrayList<>();
        list.add(val);
        if (Objects.nonNull(left)) list.addAll(left.toListPreOrder());
        if (Objects.nonNull(right)) list.addAll(right.toListPreOrder());
        return list;
    }

    private List<Integer> toListPostOrder() {
        List<Integer> list = new ArrayList<>();
        if (Objects.nonNull(left)) list.addAll(left.toListPostOrder());
        if (Objects.nonNull(right)) list.addAll(right.toListPostOrder());
        list.add(val);
        return list;
    }

    private List<Integer> toListNaturalOrder() {
        return toMap()
                .values()
                .stream()
                .flatMap(Collection::stream)
                .toList();
    }
    
    private int depth(int currentLevel) {
        int maxLevel = currentLevel;
        if (Objects.nonNull(left)) maxLevel = Math.max(maxLevel, left.depth(currentLevel + 1));
        if (Objects.nonNull(right)) maxLevel = Math.max(maxLevel, right.depth(currentLevel + 1));
        return maxLevel;
    }
    
    private static boolean subnodeAddressValid(int level, int position) {
        if (position < 0) return false;
        if (level < 0) return false;

        int limit = 1;
        for (int i = 0; i < level; i++) limit *= 2;
        
        return position < limit;
    }
    
    public enum Order {
        IN_ORDER(),
        PRE_ORDER(), 
        POST_ORDER(),
        NATURAL_ORDER();
        
        Order() {
            
        }
    }
}
