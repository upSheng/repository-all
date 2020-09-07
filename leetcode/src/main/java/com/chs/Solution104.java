package com.chs;

/**
 * @author : HongSheng.Chen
 * @date : 2020/7/28 9:44
 */
public class Solution104 {
    public int maxDepth(TreeNode root) {

        if (root == null) return 0;

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
