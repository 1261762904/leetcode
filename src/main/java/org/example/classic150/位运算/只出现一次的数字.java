package org.example.classic150.位运算;

/**
 * https://leetcode.cn/problems/single-number/description/?envType=study-plan-v2&envId=top-interview-150
 * 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
 * @author yixin
 * @since 2024/8/22
 */
public class 只出现一次的数字 {
    public static void main(String[] args) {
        System.out.println(new 只出现一次的数字().singleNumber(new int[]{2, 2, 1}));
    }
    public int singleNumber(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }
}
