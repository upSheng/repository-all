package com.chs;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author : HongSheng.Chen
 * @date : 2020/10/9 15:29
 */
public class Solution111 {
    public int minDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int result = 0;
        Deque<TreeNode> deque = new LinkedList<>();

        deque.offer(root);

        while (!deque.isEmpty()) {
            result++;
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = deque.poll();
                if (poll.left == null && poll.right == null) {
                    return result;
                }
                if (poll.left != null) {
                    deque.offer(poll.left);
                }
                if (poll.right != null) {
                    deque.offer(poll.right);
                }
            }

        }
        return result;
    }
}
