package org.example.daily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.cn/problems/double-modular-exponentiation/description/
 * 给你一个下标从 0 开始的二维数组 variables ，其中 variables[i] = [ai, bi, ci, mi]，以及一个整数 target 。
 * 如果满足以下公式，则下标 i 是 好下标：
 * 0 <= i < variables.length
 * ((ai^bi % 10)^ci) % mi == target
 * 返回一个由 好下标 组成的数组，顺序不限 。
 * @author yixin
 * @since 2024/7/30
 */
public class D20240730 {
    public static void main(String[] args) {
        int[][] ints = {
                {2,3,3,10},
                {3,3,3,1},
                {31,12,21,24}
        };

        System.out.println(new D20240730().getGoodIndices(ints,2));
    }

    /**
     * 分治
     * x * x^2 * x^4 * x^ 8
     * x^5 = x * x^4 5的二进制：0101
     * x^10 = x^2 * x^ 8  10二进制：1010
     * 那怎么判断需要哪些数相乘呢？
     * 对二进制向右移动，每移一次判断个位是否等于1，如果等于1说明要乘，否则继续
     */
    public List<Integer> getGoodIndices(int[][] variables, int target) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < variables.length; i++) {
            int[] variable = variables[i];
            if(pow(pow(variable[0],variable[1],10),variable[2],variable[3])==target){
                result.add(i);
            }
        }
        return result;
    }
    private int pow(int x, int n, int mod) {
        int result = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                result = result * x % mod;
            }
            x = x * x % mod;
            n = n >> 1;
        }
        return result;
    }
}
