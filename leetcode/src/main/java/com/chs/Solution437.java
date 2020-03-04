package com.chs;

public class Solution437 {

    public int pathSum(TreeNode root, int sum) {

        if (root == null) return 0;

        return path(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);

    }

    public int path(TreeNode node, int sum) {
        if (node == null) return 0;

        return node.val == sum ? 1 : 0 + path(node.left, sum - node.val) + path(node.right, sum - node.val);

    }
}
