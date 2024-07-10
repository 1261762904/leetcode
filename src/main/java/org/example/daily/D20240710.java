package org.example.daily;

/**
 * https://leetcode.cn/problems/count-the-number-of-incremovable-subarrays-i/description/
 * 给你一个下标从 0 开始的 正 整数数组 nums 。
 * 如果 nums 的一个子数组满足：移除这个子数组后剩余元素 严格递增 ，那么我们称这个子数组为 移除递增 子数组。
 * 比方说，[5, 3, 4, 6, 7] 中的 [3, 4] 是一个移除递增子数组，因为移除该子数组后，[5, 3, 4, 6, 7] 变为 [5, 6, 7] ，是严格递增的。
 * 请你返回 nums 中 移除递增 子数组的总数目。
 * 注意 ，剩余元素为空的数组也视为是递增的。
 * 子数组 指的是一个数组中一段连续的元素序列。
 * @author yixin
 * @since 2024/7/8
 */
public class D20240710 {
    public static void main(String[] args) {
        int[] ints = {4,3,5,1};
        System.out.println(new D20240710().incremovableSubarrayCount(ints));
    }

    /**
     * 两重循环，第一层left，第二层right
     * 若 nums[l] 左侧有元素，并且这些元素满足严格递增；
     * 若 nums[r] 右侧有元素，并且这些元素满足严格递增；
     * 若 nums[l] 左侧有元素并且 nums[r] 右侧有元素，并且 nums[l]<nums[r+1]。
     */
    public int incremovableSubarrayCount(int[] nums) {
        int result = 0;
        for (int left = 0; left < nums.length; left++) {
            boolean isIncrease = true;
            for (int i = 0; i < left-1; i++) {
                if(nums[i]>=nums[i+1]){
                    isIncrease=false;
                    break;
                }
            }
            //若 nums[l] 左侧有元素，并且这些元素满足严格递增；
            if(!isIncrease) continue;
            for (int right = left; right < nums.length; right++) {
                isIncrease=true;
                if (right<nums.length-1){
                    if(left>0 && nums[left-1]>=nums[right+1]){
                        //若 nums[l] 左侧有元素并且 nums[r] 右侧有元素，并且 nums[l]<nums[r+1]。
                        continue;
                    }
                    //若 nums[r] 右侧有元素，并且这些元素满足严格递增；
                    for (int j = right+1; j < nums.length-1; j++) {
                        if(nums[j]>=nums[j+1]){
                            isIncrease=false;
                            break;
                        }
                    }
                }
                if(isIncrease) {
                    System.out.printf(String.format("[%s,%s]%n",nums[left],nums[right]));
                    result++;
                }
            }
        }
        return result;
    }
}
