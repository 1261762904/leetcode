package org.example.daily;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/find-the-integer-added-to-array-i/description/
 * 给你两个长度相等的数组 nums1 和 nums2。
 * 数组 nums1 中的每个元素都与变量 x 所表示的整数相加。如果 x 为负数，则表现为元素值的减少。
 * 在与 x 相加后，nums1 和 nums2 相等 。当两个数组中包含相同的整数，并且这些整数出现的频次相同时，两个数组 相等 。
 * 返回整数 x 。
 * @author yixin
 * @since 2024/7/26
 */
public class D20240808 {
    public static void main(String[] args) {
        System.out.println(new D20240808().addedInteger(new int[]{2, 6, 4}, new int[]{9, 7, 5}));
    }


    /**
     * 计算nums1、nums2 SUM
     * 然后对sum相减再除数组长度即为x   x = (sum2-sum1)/sum1.length
     */
    public int addedInteger(int[] nums1, int[] nums2) {
        int sum1 = 0;
        for (int i = 0; i < nums1.length; i++) {
            sum1+=nums1[i];
        }
        int sum2=0;
        for (int i = 0; i < nums2.length; i++) {
            sum2+=nums2[i];
        }
        return (sum2-sum1)/nums1.length;
    }
}
