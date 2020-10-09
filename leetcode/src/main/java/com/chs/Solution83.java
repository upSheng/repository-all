package com.chs;

/**
 * @author : HongSheng.Chen
 * @date : 2020/10/9 10:33
 */
public class Solution83 {
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode pre = head;
        ListNode cur = head;

        while (cur != null) {

            if (pre.val != cur.val) {
                pre.next = cur;
                pre = cur;
            }
            cur = cur.next;
        }
        pre.next = null;

        return head;

    }
}
