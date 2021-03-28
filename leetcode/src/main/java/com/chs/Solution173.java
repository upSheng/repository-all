package com.chs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : HongSheng.Chen
 * @date : 2021/3/28 17:51
 */
public class Solution173 {

    private Queue<TreeNode> queue;

    public Solution173(TreeNode root) {
        queue = new LinkedList<>();
        dfs(root);
    }

    public int next() {
        return queue.poll().val;
    }

    public boolean hasNext() {

        return !queue.isEmpty();
    }

    private void dfs(TreeNode root) {

        if (root == null) {
            return;
        }
        dfs(root.left);
        queue.offer(root);
        dfs(root.right);
    }
}
