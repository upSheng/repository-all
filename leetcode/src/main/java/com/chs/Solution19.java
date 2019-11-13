package com.chs;

public class Solution19 {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {


        ListNode dummy = new ListNode(0);

        dummy.next = head;

        ListNode cur = dummy;
        int length = 0;
        while (cur.next != null){
            cur = cur.next;
            length ++;
        }


        cur = dummy;

        int i = 0;
        while(i<length - n){
            cur = cur.next;
            i++;
        }

        cur.next = cur.next.next;


        return dummy.next;


    }
}




