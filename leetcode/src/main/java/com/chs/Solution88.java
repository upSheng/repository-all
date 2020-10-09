package com.chs;

/**
 * @author : HongSheng.Chen
 * @date : 2020/10/9 11:20
 */
public class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] nums1_copy = new int[m];
        System.arraycopy(nums1, 0, nums1_copy, 0, m);

        int p1 = 0;
        int p2 = 0;
        int p = 0;

        while (p1 < m && p2 < n) {
            nums1[p++] = nums1_copy[p1] < nums2[p2] ? nums1_copy[p1++] : nums2[p2++];
        }
        if (p1 < m) {
            System.arraycopy(nums1_copy, p1, nums1, p, m - p1);
        }
        if (p2 < n) {
            System.arraycopy(nums2, p2, nums1, p, n - p2);
        }
        System.out.println(nums1);

    }

    public static void main(String[] args) {
        Solution88 solution88 = new Solution88();
        solution88.merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
    }
}
