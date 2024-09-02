package org.example.daily;

import java.util.*;

/**
 * https://leetcode.cn/problems/sum-of-digit-differences-of-all-pairs/description/
 * 你有一个数组 nums ，它只包含 正 整数，所有正整数的数位长度都 相同 。
 * 两个整数的 数位不同 指的是两个整数 相同 位置上不同数字的数目。
 * 请你返回 nums 中 所有 整数对里，数位不同之和。
 * @author yixin
 * @since 2024/8/30
 */
public class D20240830 {
    public static void main(String[] args) {
        System.out.println(new D20240830().sumDigitDifferences(new int[]{13,23,12}));
    }

    /**
     * 一位一位的对比
     * 因为位数都一样，第一个元素不为0其他元素也是不为0的
     *      cnt定义为当前位中0-9的个数
     *      循环所有nums，获取个位，并自身除10
     *      遍历cnt，计算
     */
    public long sumDigitDifferences(int[] nums) {
        long res = 0;
        int n = nums.length;
        while (nums[0] > 0) {
            int[] cnt = new int[10];
            for (int i = 0; i < n; i++) {
                cnt[nums[i] % 10]++;
                nums[i] /= 10;
            }
            for (int i = 0; i < 10; i++) {
                res += (long) (n - cnt[i]) * cnt[i];
            }
        }
        return res / 2;
    }

}
