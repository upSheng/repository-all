package com.chs;

/**
 * @author : HongSheng.Chen
 * @date : 2020/11/20 14:20
 */
public class Solution147 {

    public ListNode insertionSortList(ListNode head) {

        ListNode res = new ListNode(0);



        while (head != null) {



            head = head.next;
        }

        return res.next;


    }
}
