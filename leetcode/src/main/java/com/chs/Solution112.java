package com.chs;

/**
 * @author : HongSheng.Chen
 * @date : 2020/7/7 9:20
 */
public class Solution112 {
    public boolean hasPathSum(TreeNode root, int sum) {

        if (root == null) return false;
        return help(root,sum);


    }

    private boolean help(TreeNode root, int sum){
        if (root == null) {
            if (sum == 0) {
                return true;
            } else {
                return false;
            }
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }


}
