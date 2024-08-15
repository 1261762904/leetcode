package org.example.daily;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/special-array-ii/description/
 * 如果数组的每一对相邻元素都是两个奇偶性不同的数字，则该数组被认为是一个 特殊数组 。
 * 有一个整数数组 nums 和一个二维整数矩阵 queries，对于 queries[i] = [fromi, toi]，检查子数组 nums[fromi..toi] 是不是一个 特殊数组 。
 * 返回布尔数组 answer，如果 nums[fromi..toi] 是特殊数组，则 answer[i] 为 true ，否则，answer[i] 为 false 。
 * @author yixin
 * @since 2024/8/14
 */
public class D20240814 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new D20240814().isArraySpecial(new int[]{3,4,1,6},new int[][]{new int[]{0,2},new int[]{2,3}})));
    }


    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        boolean[] result = new boolean[queries.length];
        int[] ans = new int[nums.length];
        Arrays.fill(ans,1);
        for (int i = 1; i < nums.length; i++) {
            if(((nums[i]^nums[i-1])&1)==1){
                ans[i] = ans[i-1]+1;
            }
        }
        for (int i = 0; i < queries.length; i++) {
            int x = queries[i][0];
            int y = queries[i][1];
            result[i] = (ans[y]>=(y-x+1));
        }
        return result;
    }
}
