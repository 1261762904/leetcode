package org.example.daily;

import java.util.*;

/**
 * 感觉这个题不怎么好
 * https://leetcode.cn/problems/relocate-marbles/description/
 * 给你一个下标从 0 开始的整数数组 nums ，表示一些石块的初始位置。再给你两个长度 相等 下标从 0 开始的整数数组 moveFrom 和 moveTo 。
 * 在 moveFrom.length 次操作内，你可以改变石块的位置。在第 i 次操作中，你将位置在 moveFrom[i] 的所有石块移到位置 moveTo[i] 。
 * 完成这些操作后，请你按升序返回所有 有 石块的位置。
 * 注意：
 * 如果一个位置至少有一个石块，我们称这个位置 有 石块。
 * 一个位置可能会有多个石块。
 * @author yixin
 * @since 2024/7/24
 */
public class D20240724 {
    public static void main(String[] args) {
        new D20240724().relocateMarbles(new int[]{1,6,7,8},new int[]{1,7,2},new int[]{2,9,5});
    }


    public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 0; i < moveFrom.length; i++) {
            set.remove(moveFrom[i]);
            set.add(moveTo[i]);
        }

        List<Integer> ans = new ArrayList<>(set);
        Collections.sort(ans);

        return ans;
    }


}
