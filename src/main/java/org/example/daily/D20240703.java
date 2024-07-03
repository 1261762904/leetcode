package org.example.daily;

/**
 * https://leetcode.cn/problems/harshad-number/description/
 * 如果一个整数能够被其各个数位上的数字之和整除，则称之为 哈沙德数（Harshad number）。给你一个整数 x 。如果 x 是 哈沙德数 ，则返回 x 各个数位上的数字之和，否则，返回 -1 。
 * @author yixin
 * @since 2024/7/3
 */
public class D20240703 {
    public static void main(String[] args) {
        System.out.println(new D20240703().sumOfTheDigitsOfHarshadNumber(18));
        System.out.println(new D20240703().sumOfTheDigitsOfHarshadNumber(23));
    }

    /**
     * 获取x的每个位相加后的值，x和sum取余，判断余数是否是0
     * 如果是0，返回sum
     * 否则，返回-1
     * @param x
     * @return
     */
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int sum = get(x);
        if (x % sum == 0) {
            return sum;
        } else {
            return -1;
        }
    }

    /**
     * 获取x的每个位相加后的值
     * ----
     * 定义sum=0
     * 判断x是否大于0
     * true：sum+余数（x%10），并对x除10，继续循环 从个位开始依次相加
     * false：跳出循环
     */
    private int get(int x) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x = x / 10;
        }
        return sum;
    }
}
