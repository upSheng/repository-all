package com.chs;

public class Solution2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = new ListNode(1);

        ListNode temp = result;

        while (true) {
            if (l1 == null) {
                temp.next =l2;
                return result.next;
            }

            if (l2 == null) {
                temp.next =l1;
                return result.next;
            }

            ListNode node = new ListNode(1);
            node.val = l1.val + l2.val;
            temp.next = node;
            temp = node;

            l1 = l1.next;
            l2 = l2.next;
        }


    }
}
