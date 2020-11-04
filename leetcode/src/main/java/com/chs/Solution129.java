package com.chs;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author : HongSheng.Chen
 * @date : 2020/10/29 9:41
 */
public class Solution129 {

    public int sumNumbers(TreeNode root) {

        if (root == null) {
            return 0;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        int result = 0;
        while (!deque.isEmpty()) {

            int size = deque.size();

            for (int i = 0; i < size; i++) {
                TreeNode poll = deque.poll();

                if (poll.left == null && poll.right == null) {
                    result += poll.val;
                }
                if (poll.left != null) {
                    poll.left.val = poll.val * 10 + poll.left.val;
                    deque.push(poll.left);
                }
                if (poll.right != null) {
                    poll.right.val = poll.val * 10 + poll.right.val;
                    deque.push(poll.right);
                }
            }
        }
        return result;
    }
}
