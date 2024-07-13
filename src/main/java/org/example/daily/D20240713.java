package org.example.daily;

import java.util.BitSet;

/**
 * https://leetcode.cn/problems/find-if-array-can-be-sorted/description/
 * 给你一个下标从 0 开始且全是 正 整数的数组 nums 。
 * 一次 操作 中，如果两个 相邻 元素在二进制下数位为 1 的数目 相同 ，那么你可以将这两个元素交换。你可以执行这个操作 任意次 （也可以 0 次）。
 * 如果你可以使数组变有序，请你返回 true ，否则返回 false 。
 *
 * @author yixin
 * @since 2024/7/12
 */
public class D20240713 {
    public static void main(String[] args) {
        int[] ints = {8, 4, 2, 30, 15};
        System.out.println(new D20240713().canSortArray(ints));
    }

    /**
     * nums按照位数分组，记录上一组的最大值，然后判断当前组中的元素是否大于上一组的最小值，即后一组的最小值要比前一组的最大值都要大，才有可能是升序
     * 定义 上一组的最大值，上一组的位数，当前组的最大值
     * 遍历nums
     * 如果当前numbig和上一组位数相同，说明被分为同一组，那就需要判断最大值
     * 否则 相当于开启新的组，记录上一组的最大值，上一组的位数，初始化当前组的最大值
     * 判断当前num是否大于上一组的最大值，是的继续循环，否则返回false
     */
    public boolean canSortArray(int[] nums) {
        int lastMax = 0;
        int lastBitCount = 0;
        int curMax = 0;
        for (int num : nums) {
            int bitCount = Integer.bitCount(num);
            if (bitCount == lastBitCount) {
                curMax = Math.max(num, curMax);
            } else {
                lastBitCount = bitCount;
                lastMax = curMax;
                curMax = num;
            }
            if (num < lastMax) return false;
        }
        return true;
    }

}
