package com.chs;

public class Solution543 {

    private int res;

    public int diameterOfBinaryTree(TreeNode root) {

        res = 1;

        dfs(root);
        return res - 1;
    }

    public int dfs(TreeNode node) {

        if (node == null) {
            return 0;
        }

        int left = dfs(node.left);
        int right = dfs(node.right);
        res = Math.max(res, left + right + 1);


        return Math.max(left, right) + 1;

    }
}
