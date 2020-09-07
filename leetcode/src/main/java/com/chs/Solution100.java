package com.chs;

/**
 * @author : HongSheng.Chen
 * @date : 2020/8/7 9:45
 */
public class Solution100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
