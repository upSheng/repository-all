package com.chs;

/**
 * @author : HongSheng.Chen
 * @date : 2020/7/3 11:28
 */
public class Solution108 {
    public static TreeNode sortedArrayToBST(int[] nums) {

        return help(nums, 0, nums.length - 1);
    }

    public static TreeNode help(int[] nums, int i, int j) {

        if (i > j) {
            return null;
        }
        int index = (j + i + 1) / 2;
        TreeNode node = new TreeNode(nums[index]);
        node.left = help(nums, i, index - 1);
        node.right = help(nums, index + 1, j);
        return node;
    }

    public static void main(String[] args) {
        TreeNode treeNode = sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        System.out.println(treeNode);
    }
}
