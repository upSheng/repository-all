package com.chs;

/**
 * @author : HongSheng.Chen
 * @date : 2020/8/18 13:42
 */
public class Solution109 {

    ListNode cur;

    public TreeNode sortedListToBST(ListNode head) {
        int n = 0;
        cur = head;
        while (cur != null) {
            n++;
            cur = cur.next;
        }
        cur = head;
        return buildTree(0, n - 1);
    }

    public TreeNode buildTree(int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right + 1) / 2;
        TreeNode root = new TreeNode();
        root.left = buildTree(left, mid - 1);
        root.val = cur.val;
        cur = cur.next;
        root.right = buildTree(mid + 1, right);
        return root;
    }
}
