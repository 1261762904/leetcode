package org.example.hot100.栈;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://leetcode.cn/problems/daily-temperatures/description/?envType=study-plan-v2&envId=top-100-liked
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，
 * 其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。
 * 如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * @author yixin
 * @since 2024/8/13
 */
public class 每日温度 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new 每日温度().dailyTemperatures(new int[]{73,74,75,71,69,72,76,73})));
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            int j = i - 1;
            while (!stack.isEmpty() && stack.peek() < temperatures[i]) {
                while (result[j] != 0) j--;
                result[j] = i - j;
                stack.pop();
            }
            stack.push(temperatures[i]);
        }
        return result;
    }

    public int[] dailyTemperaturesNew(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                Integer j = stack.pop();
                result[j] = i - j;
            }
            stack.push(i);
        }
        return result;
    }

    public int[] dailyTemperaturesNew1(int[] temperatures) {
        int[] res = new int[temperatures.length];
        for(int i = res.length-2;i>=0;i--){
            for(int j = i+1;j<res.length;j+=res[j]){
                if(temperatures[j]>temperatures[i]){
                    res[i] = j-i;
                    break;
                }
                if(res[j] == 0)break;
            }
        }
        return res;
    }

}
