package com.chs;

/**
 * @author : HongSheng.Chen
 * @date : 2020/9/23 15:22
 */
public class Solution968 {

    public int minCameraCover(TreeNode root) {

        return Math.min(white(root, 1), white(root, 0));
    }

    public int white(TreeNode root, int flag) {

        if (root == null) return 0;

        int a = white(root.left, 1);
        int b = white(root.left, 0);
        int c = white(root.right, 1);
        int d = white(root.right, 0);

        if (flag == 1) {
            return Math.min(a, b) + Math.min(c, d) + flag;
        }
        if (flag == 0) {
            if (a < c) {
                return a + Math.min(c, d);
            } else {
                return c + Math.min(a, b);
            }
        }
        return Math.min(a, b) + Math.min(c, d) + flag;

    }

}
