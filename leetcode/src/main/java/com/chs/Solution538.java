package com.chs;

import java.util.Stack;

/**
 * @author : HongSheng.Chen
 * @date : 2020/3/26 10:58
 */
public class Solution538 {

    private int sum = 0;

    /**
     * 递归
     * @param root
     * @return
     */
    public TreeNode convertBST(TreeNode root) {

        if (root != null) {
            convertBST(root.right);
            sum = sum + root.val;
            root.val = sum;
            convertBST(root.left);
        }

        return root;
    }


    /**
     * 栈实现
     * @param root
     * @return
     */
    public TreeNode convertBST1(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {

            while (node != null) {
                stack.push(node);
                node = node.right;
            }

            node = stack.pop();
            sum = sum + node.val;
            node.val = sum;
            node = node.left;
        }

        return root;
    }
}
