package com.chs;

/**
 * @author : HongSheng.Chen
 * @date : 2020/10/12 14:25
 */
public class Solution530 {

    private int pre = -1;
    private int result = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {

        dfs(root);
        return result;
    }

    private void dfs(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        dfs(treeNode.left);
        if (pre != -1) {
            result = Math.min(result, treeNode.val-pre);
        } else {
            pre = treeNode.val;
        }
        pre = treeNode.val;
        dfs(treeNode.right);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(4);
        treeNode.right = new TreeNode(7);
        Solution530 solution530 = new Solution530();
        int minimumDifference = solution530.getMinimumDifference(treeNode);
        System.out.println(minimumDifference);
    }
}
