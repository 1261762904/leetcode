package org.example.daily;

/**
 * https://leetcode.cn/problems/special-array-i/description/
 * 如果数组的每一对相邻元素都是两个奇偶性不同的数字，则该数组被认为是一个 特殊数组 。
 * 有一个整数数组 nums。如果 nums 是一个 特殊数组 ，返回 true，否则返回 false。
 * @author yixin
 * @since 2024/8/13
 */
public class D20240813 {
    public static void main(String[] args) {
        System.out.println(new D20240813().isArraySpecial(new int[]{4,3,1,6}));
    }


    public boolean isArraySpecial(int[] nums) {
        if(nums.length==1)return true;
        int before = nums[0]&1;
        for (int i = 1; i < nums.length; i++) {
            if((nums[i]&1) == before)return false;
            before = nums[i]&1;
        }
        return true;
    }
}
