package com.chs;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author : HongSheng.Chen
 * @date : 2020/6/28 11:11
 */
public class Solution25 {

    public static ListNode reverseKGroup(ListNode head, int k) {

        Deque<ListNode> deque = new LinkedList<>();
        ListNode result = new ListNode(0);
        ListNode cur = result;
        while (head != null) {

            while (head != null && deque.size() != k) {

                deque.push(head);
                head = head.next;
            }

            if (deque.size() == k) {
                while (!deque.isEmpty()) {
                    cur.next = deque.pop();
                    cur = cur.next;
                }
            } else {
                while (!deque.isEmpty()) {
                    cur.next = deque.pollLast();
                    cur = cur.next;
                }
            }
        }
        cur.next = null;
        return result.next;
    }


}
