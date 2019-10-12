package com.chs;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 */
public class Solution4 {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2};
        int[] nums2 = new int[]{3,4};

        Double d = findMedianSortedArrays(nums1,nums2);

        System.out.println(d);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] A = nums1.length <= nums2.length ? nums1 : nums2;

        int[] B = nums1.length > nums2.length ? nums1 : nums2;

        int m = A.length;
        int n = B.length;


        int i, j,iMin = 0, iMax = m;

        while (iMin <= iMax) {

            i = (iMin + iMax) / 2;

            j = (m + n + 1) / 2 - i;
            if (i < iMax && B[j - 1] > A[i]) {

                iMin = iMin + 1;
            } else if (i > iMin && A[i - 1] > B[j]) {
                iMax = iMax - 1;
            } else {

                int lMax;

                if (i == 0) {
                    lMax = B[j - 1];
                } else if (j == 0) {
                    lMax = A[i - 1];
                } else {
                    lMax = Math.max(A[i - 1], B[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return lMax;
                }

                int rMin;
                if (i == m) {
                    rMin = B[j];
                } else if (j == n) {
                    rMin = A[i];
                } else {
                    rMin = Math.min(A[i], B[j]);
                }

                return (lMax + rMin) / 2;

            }
        }


        return 0.0;


    }
}
