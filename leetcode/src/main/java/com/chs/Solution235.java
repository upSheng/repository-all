package com.chs;

/**
 * @author : HongSheng.Chen
 * @date : 2020/11/19 10:09
 */
public class Solution235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        while (true) {
            int compareTo1 = Integer.compare(root.val, p.val);
            int compareTo2 = Integer.compare(root.val, q.val);
            if (compareTo1 != compareTo2 || compareTo1 == 0) {
                return root;
            }
            root = compareTo1 > 0 ? root.left : root.right;
        }


    }
}
