package com.chs;

/**
 * @author : HongSheng.Chen
 * @date : 2020/8/17 17:31
 */
public class Solution110 {


    public boolean isBalanced(TreeNode root) {

        return height(root) != -1;
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int a, b;

        if ((a = height(root.left)) == -1 || (b = height(root.right)) == -1 || Math.abs(a - b) > 1) {
            return -1;
        }

        return Math.max(a, b) + 1;
    }
}
