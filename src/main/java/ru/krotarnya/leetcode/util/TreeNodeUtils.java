package ru.krotarnya.leetcode.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import ru.krotarnya.leetcode.common.TreeNode;

public class TreeNodeUtils {
    public static List<Integer> toList(TreeNode node, Order order) {
        return switch (order) {
            case PRE_ORDER -> toListPreOrder(node);
            case IN_ORDER -> toListInOrder(node);
            case POST_ORDER -> toListPostOrder(node);
            case NATURAL_ORDER -> toListNaturalOrder(node);
        };
    }
    
    public static String toString(TreeNode node) {
        return toMap(node)
                .values()
                .stream()
                .map(List::toString)
                .collect(Collectors.joining("\n"));
    }
    
    public static Map<Integer, List<Integer>> toMap(TreeNode node) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int level = 0; level < depth(node); level++) {
            List<Integer> list = new ArrayList<>();
            
            int limit = 1;
            for (int i = 0; i < level; i++) limit *= 2;

            for (int position = 0; position < limit; position++) {
                TreeNode target = subnode(node, level, position);
                list.add(Objects.nonNull(target)
                        ? target.val
                        : null
                );
            }
            map.put(level, list);
        }

        return map;
    }

    public static int depth(TreeNode node) {
        if (node == null) return 0;
        return depth(node, 1);
    }

    private static List<Integer> toListPreOrder(TreeNode node) {
        List<Integer> list = new ArrayList<>();
        list.add(node.val);
        if (Objects.nonNull(node.left)) list.addAll(toListPreOrder(node.left));
        if (Objects.nonNull(node.right)) list.addAll(toListPreOrder(node.right));
        return list;
    }
    
    private static List<Integer> toListInOrder(TreeNode node) {
        List<Integer> list = new ArrayList<>();
        if (Objects.nonNull(node.left)) list.addAll(toListInOrder(node.left));
        list.add(node.val);
        if (Objects.nonNull(node.right)) list.addAll(toListInOrder(node.right));
        return list;
    }

    private static List<Integer> toListPostOrder(TreeNode node) {
        List<Integer> list = new ArrayList<>();
        if (Objects.nonNull(node.left)) list.addAll(toListPostOrder(node.left));
        if (Objects.nonNull(node.right)) list.addAll(toListPostOrder(node.right));
        list.add(node.val);
        return list;
    }

    public static TreeNode subnode(TreeNode node, int level, int position) {
        if (!subnodeAddressValid(level, position))
            throw new IllegalArgumentException("Bad subnode address [" + level + "; " + position + "]");
        
        for (int i = 0; i < level; i++) {
            node = ((position & 1) == 0)
                    ? node.left
                    : node.right;

            if (node == null)
                return null;

            position = position >> 1;
        }

        return node;
    }

    private static List<Integer> toListNaturalOrder(TreeNode node) {
        return toMap(node)
                .values()
                .stream()
                .flatMap(Collection::stream)
                .toList();
    }

    private static int depth(TreeNode node, int currentLevel) {
        int maxLevel = currentLevel;
        if (Objects.nonNull(node.left)) maxLevel = Math.max(maxLevel, depth(node.left, currentLevel + 1));
        if (Objects.nonNull(node.right)) maxLevel = Math.max(maxLevel, depth(node. right, currentLevel + 1));
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
        PRE_ORDER, IN_ORDER, POST_ORDER, NATURAL_ORDER
    }
}
