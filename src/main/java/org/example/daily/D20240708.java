package org.example.daily;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/find-pivot-index/description/
 * 给你一个整数数组 nums ，请计算数组的 中心下标 。
 * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
 * 如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。
 * 如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。
 * @author yixin
 * @since 2024/7/8
 */
public class D20240708 {
    public static void main(String[] args) {
        int[] ints = {1,7,3,6,5,6};
        System.out.println(new D20240708().pivotIndex(ints));
    }

    /**
     * 计算出nums总sum值，定义leftSum=0，rightSum=sum
     * 从左至右遍历nums
     * 计算rightSum-
     * 如果leftSum==rightSum
     *      break；
     * 否则
     *      leftSum+
     */
    public int pivotIndex(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int leftSum = 0;
        int rightSum = sum;
        for (int i = 0; i < nums.length; i++) {
            rightSum -= nums[i];
            if (leftSum == rightSum) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }


    /**
     * 假设中间位为index，则0-（index-1）的num相加*2+num[index]=sum一定成立
     * 计算nums总和sum，定义leftSum
     * 遍历nums
     *  判断0-（index-1）的num相加*2+num[index]=sum是否成立
     *      成立则return
     *      否则leftSum+num
     *
     */
    public int pivotIndexNew(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if(leftSum*2+nums[i]==sum){
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}
