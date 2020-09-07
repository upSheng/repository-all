package com.chs;

/**
 * @author : HongSheng.Chen
 * @date : 2020/8/5 10:53
 */
public class Solution337 {

    public int rob(TreeNode root) {

        int[] help = help(root);
        return Math.max(help[0], help[1]);
    }

    private int[] help(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] a = help(root.left);
        int[] b = help(root.right);

        int selected = root.val + a[1] + b[1];
        int notSelect = Math.max(a[0], a[1]) + Math.max(b[0], b[1]);
        return new int[]{selected, notSelect};
    }
}
