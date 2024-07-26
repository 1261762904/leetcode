package org.example.daily;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/find-the-value-of-the-partition/description/
 * 给你一个 正 整数数组 nums 。
 * 将 nums 分成两个数组：nums1 和 nums2 ，并满足下述条件：
 * 数组 nums 中的每个元素都属于数组 nums1 或数组 nums2 。
 * 两个数组都 非空 。
 * 分区值 最小 。
 * 分区值的计算方法是 |max(nums1) - min(nums2)| 。
 * 其中，max(nums1) 表示数组 nums1 中的最大元素，min(nums2) 表示数组 nums2 中的最小元素。
 * 返回表示分区值的整数。
 * @author yixin
 * @since 2024/7/26
 */
public class D20240726 {
    public static void main(String[] args) {
        new D20240726().findValueOfPartition(new int[]{1,3,2,4});
    }


    /**
     * 求数组中元素的最小差值
     * 暴力解法 两层循环
     * 超时了
     */
    public int findValueOfPartition(int[] nums) {
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int diff = Math.abs(nums[i]-nums[j]);
                result = Math.min(result,diff);
            }
        }
        return result;
    }

    /**
     * 先排序
     * 在计算相邻的差值
     */
    public int findValueOfPartition1(int[] nums) {
        Arrays.sort(nums);
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length-1; i++) {
            result = Math.min(result,(nums[i+1]-nums[i]));
        }
        return result;
    }
}
