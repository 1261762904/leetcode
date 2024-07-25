package org.example.hot100.普通数组;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/product-of-array-except-self/description/?envType=study-plan-v2&envId=top-100-liked
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。、
 * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * @author yixin
 * @since 2024/7/25
 */
public class 除自身以外数组的乘积 {
    public static void main(String[] args) {
        new 除自身以外数组的乘积().productExceptSelf(new int[]{1,2,3,4});

    }

    /**
     * 遍历获取左边的乘积
     * 遍历获取右边的乘积
     * 新值=左边乘积*右边乘积
     */
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        left[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i-1]*nums[i-1];
        }
        right[nums.length-1] = 1;
        for (int i = nums.length-2; i >= 0; i--) {
            right[i] = right[i+1]*nums[i+1];
        }
        for (int i = 0; i < nums.length; i++) {
            answer[i]=left[i]*right[i];
        }
        return answer;
    }

    /**
     * 遍历获取左边的乘积
     * 遍历获取右边的乘积 优化点：在这里直接相乘，减少空间复杂度
     * 新值=左边乘积*右边乘积
     */
    public int[] productExceptSelf1(int[] nums) {
        int[] answer = new int[nums.length];
        int[] left = new int[nums.length];
        left[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i-1]*nums[i-1];
        }
        int right = 1;
        for (int i = nums.length-1; i >= 0; i--) {
            answer[i]=left[i]*right;
            right = right*nums[i];
        }
        return answer;
    }

    /**
     * 双指针
     */
    public int[] productExceptSelf2(int[] nums) {
        int[] answer = new int[nums.length];
        Arrays.fill(answer, 1);
        int leftMulti = 1;
        int rightMulti = 1;
        for (int l = 0, r = nums.length - 1; l < nums.length; l++, r--) {
            answer[l] *= leftMulti;
            answer[r] *= rightMulti;
            leftMulti *= nums[l];
            rightMulti *= nums[r];
        }
        return answer;
    }

}
