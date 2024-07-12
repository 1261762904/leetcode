package org.example.daily;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/minimum-number-game/description/
 * 你有一个下标从 0 开始、长度为 偶数 的整数数组 nums ，同时还有一个空数组 arr 。Alice 和 Bob 决定玩一个游戏，游戏中每一轮 Alice 和 Bob 都会各自执行一次操作。游戏规则如下：
 * 每一轮，Alice 先从 nums 中移除一个 最小 元素，然后 Bob 执行同样的操作。
 * 接着，Bob 会将移除的元素添加到数组 arr 中，然后 Alice 也执行同样的操作。
 * 游戏持续进行，直到 nums 变为空。
 * 返回结果数组 arr
 * @author yixin
 * @since 2024/7/12
 */
public class D20240712 {
    public static void main(String[] args) {
        int[] ints = {5,4,2,3};
        System.out.println(new D20240712().numberGame(ints));
    }

    public int[] numberGame(int[] nums) {
        int[] ints = new int[nums.length];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i = i + 2) {
            ints[i + 1] = nums[i];
            ints[i] = nums[i + 1];
        }
        return ints;
    }

    public int[] numberGameNew(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length - 1;
        for (int i = 0; i < n; i = i + 2) {
            int x = nums[i];
            nums[i] = nums[i + 1];
            nums[i + 1] = x;
        }
        return nums;
    }
}
