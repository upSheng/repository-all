package com.chs;

/**
 * @author : HongSheng.Chen
 * @date : 2020/6/21 14:37
 */
public class Solution124 {

    int max = Integer.MIN_VALUE;


    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }


    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = Math.max(dfs(root.left), 0);
        int right = Math.max(dfs(root.right), 0);

        max = Math.max(max, left + right + root.val);
        return Math.max(left, right) + root.val;
    }
}
