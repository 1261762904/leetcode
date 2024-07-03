package org.example.hot100.哈希;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/longest-consecutive-sequence/description/?envType=study-plan-v2&envId=top-100-liked
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * @author yixin
 * @since 2024/7/3
 */
public class 最长连续序列 {
    public static void main(String[] args) {
        int[] strings = {100,4,200,1,3,2};
        new 最长连续序列().longestConsecutive(strings);
    }

    /**
     * 如果nums.length等于0直接返回
     * 对nums排序，然后使用双指针滑动
     * 定义max:0,left：0，遍历排序好的nums,从1开始，就可以把index当成right
     * 判断nums[right]与nums[right-1]值
     *  是1：判断nums[right]-nums[left]+1 和max做比较
     *  是0：continue
     *  都不是：移动left left=right
     * return max；
     */
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) {
            return 0;
        }
        Arrays.sort(nums);
        int left = 0;
        int max = 1;
        for (int right = 1; right < nums.length; right++) {
            int diff = nums[right] - nums[right - 1];
            if(diff == 1){
                max = Math.max(max,nums[right]-nums[left]+1);
            }else if(diff == 0){
                continue;
            }else{
                left=right;
            }
        }
        return max;
    }
}
