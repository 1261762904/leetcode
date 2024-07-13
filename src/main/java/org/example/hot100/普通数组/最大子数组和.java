package org.example.hot100.普通数组;

/**
 * https://leetcode.cn/problems/maximum-subarray/description/?envType=study-plan-v2&envId=top-100-liked
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组是数组中的一个连续部分。
 * @author yixin
 * @since 2024/7/13
 */
public class 最大子数组和 {
    public static void main(String[] args) {
        int[] ints = {-1};
        System.out.println(new 最大子数组和().maxSubArray(ints));
    }

    //从左至右只要sum大于0就往后走，并且判断最大值，如果sum到小于0，则sum初始到0，
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            sum += num;
            max = Math.max(sum,max);
            if(sum<0){
                sum = 0;
            }
        }
        return max;
    }
}
