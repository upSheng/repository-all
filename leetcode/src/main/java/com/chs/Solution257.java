package com.chs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : HongSheng.Chen
 * @date : 2020/11/19 16:07
 */
public class Solution257 {

    private List<String> res = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {

        dfs(root, new ArrayList<>());
        return res;
    }

    private void dfs(TreeNode node, List<String> temp) {

        if (node.left == null && node.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < temp.size(); i++) {
                sb.append(temp.get(i));
                sb.append("->");
            }
            sb.append(node.val);
            res.add(sb.toString());
        }

        if (node.left != null) {
            temp.add(String.valueOf(node.val));
            dfs(node.left, temp);
            temp = temp.subList(0, temp.size() - 1);
        }
        if (node.right != null) {
            temp.add(String.valueOf(node.val));
            dfs(node.right, temp);

        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);

        Solution257 solution257 = new Solution257();
        List<String> list = solution257.binaryTreePaths(root);
        System.out.println(list);
    }


}
