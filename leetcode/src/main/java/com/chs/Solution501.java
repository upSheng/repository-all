package com.chs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : HongSheng.Chen
 * @date : 2020/9/24 9:24
 */
public class Solution501 {


    private List<Integer> result = new ArrayList<>();
    private int count = 0;

    private int base;
    private int baseCount = 0;

    public int[] findMode(TreeNode root) {

        if (root==null) return new int[]{};
        dfs(root);

        if (baseCount > count) {
            result.clear();
            result.add(base);
        }
        if (baseCount == count) {
            result.add(base);
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root.left);
        update(root.val);
        dfs(root.right);
    }

    public void update(int val) {
        if (baseCount == 0) {
            base = val;
            baseCount++;
            return;
        }

        if (base == val) {
            baseCount++;
            return;
        }

        if (baseCount > count) {
            count = baseCount;
            result.clear();
            result.add(base);
            base = val;
            baseCount =1;
            return;

        }
        if (baseCount == count) {
            result.add(base);
            base = val;
            baseCount =1;
        }

    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(2147483647);
//        root.right = new TreeNode(3);
//        root.right.right = new TreeNode(4);
//        root.right.right.right = new TreeNode(5);
//        root.right.right.right.right = new TreeNode(6);

        Solution501 solution501 = new Solution501();
        solution501.findMode(root);
        System.out.println();
    }


}
