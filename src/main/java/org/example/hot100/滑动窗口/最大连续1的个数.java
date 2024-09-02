package org.example.hot100.滑动窗口;

/**
 * https://leetcode.cn/problems/max-consecutive-ones-iii/description/
 * 给定一个二进制数组 nums 和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。
 * @author yixin
 * @since 2024/9/2
 */
public class 最大连续1的个数 {
    public static void main(String[] args) {
        System.out.println(new 最大连续1的个数().longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
    }

    public int longestOnes(int[] nums, int k) {
        int ans = 0;
        for (int sum = 0, left = 0, right = 0; right < nums.length; right++) {
            sum += nums[right] == 1 ? 0 : 1;
            while (sum > k) {
                sum -= nums[left++] == 1 ? 0 : 1;
            }
            ans = Math.max(right-left+1, ans);
        }
        return ans;
    }

}
